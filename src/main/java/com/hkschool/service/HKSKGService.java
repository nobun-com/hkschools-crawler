package com.hkschool.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hkschool.models.KGEntity;
import com.hkschool.repository.KGJpaRepository;
import com.hkschool.util.ImageDownloader;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Component
public class HKSKGService {

	@Resource
	private KGJpaRepository schoolJpaRepository;
	
	@Resource
	ImageDownloader imageDownloader;
	
	@Value(value = "${images.path}")
	String imagePath = "";
	
	@Value(value = "${images.pathTop}")
	String imagePathTop = "";
	
	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/kgdt_processing.php?draw=1").asJson().getBody();
		JSONArray records = (JSONArray) jsonResponse.getObject().get("data");

		int cnt1 = 0;
		int cnt2 = 0;
		for (int index = 0; index < records.length(); index++) {
			JSONArray elements = (JSONArray) records.get(index);
			String element = (String) elements.get(0);
			String[] tokens = element.replace('"', '@').split("@");
			
			if (tokens[1] != null) {
				String schoolName = element.split("<|>")[2];
				String schoolId = tokens[1];
				List<KGEntity> list = schoolJpaRepository.findBySchoolName(schoolName);
				if (list.size() > 0) {
					try {
						for(KGEntity kGEntity : list) {
							schoolJpaRepository.save(pull(schoolId, kGEntity));
							System.out.println("updated : " + schoolName + " " + cnt1++);
						}
						
					} catch (Exception e) {
						System.out.println("Error : " + e.getMessage());
					}
				} else {
					System.out.println("not found to updadte : " + schoolName + " " + cnt2++);
				}
			}
		}
	}

	private KGEntity pull(String schoolId, KGEntity kGEntity) throws IOException {

		Document doc = Jsoup.connect("https://www.schooland.hk/kg/" + schoolId).get();
		Elements rows = doc.getElementsByClass("row");
		
		
		
		Element row = rows.get(0);
		String description = row.getElementsByTag("p").get(0).text();
		
		String imageUrl = kGEntity.getImage();
		
		if(imageUrl == null || imageUrl.isEmpty())
		{
		row = rows.get(5);//school images
		row = doc.getElementsByClass("contact-pic").get(0);
		Element link = row.getElementsByTag("img").get(0);
		
		imageUrl = "https://www.schooland.hk" + link.attr("src");
		String imageBottomS3url = imageDownloader.saveImage(imageUrl, "kg");
		kGEntity.setImage(imageBottomS3url);
		}
		
		String imageUrlTop = kGEntity.getImageTop();
		
		if(imageUrlTop == null || imageUrlTop.isEmpty())
		{
		row = rows.get(1);//school imagesTop
		row = doc.getElementsByClass("photo-box").get(0);
		Element link1 = row.getElementsByTag("img").get(0);
		
		imageUrlTop = "https://www.schooland.hk" + link1.attr("src");
		String imageTopS3url = imageDownloader.saveImage(imageUrlTop, "kg");
		kGEntity.setImageTop(imageTopS3url);
		}
		
		row = rows.get(1);//schoolCategoury
		//String schoolCategoury = row.getElementsByTag("p").get(0).text();
		String schoolCategouryTitle = row.getElementsByTag("p").get(0).text();
		
		row = rows.get(2);//schoolFacilities
		String schoolFacilities = row.getElementsByTag("p").get(0).text();
		String schoolFacilitiesTitle = row.getElementsByTag("h4").get(0).text();
		
		row = rows.get(3);//schoolHistory
		String schoolHistory = row.getElementsByTag("p").get(0).text();
		String schoolHistoryTitle = row.getElementsByTag("h4").get(0).text();
		
		row = rows.get(5);//School situation
		String teachingSituation = row.getElementsByTag("p").get(0).text();
		String teachingSituationTitle = row.getElementsByTag("h4").get(0).text();
		
		
		
		//kGEntity.setSchoolCategouryTitle(schoolCategouryTitle);
		kGEntity.setSchoolFacilitiesTitle(schoolFacilitiesTitle);
		kGEntity.setSchoolHistoryTitle(schoolHistoryTitle);
		kGEntity.setTeachingSituationTitle(teachingSituationTitle);
		kGEntity.setSchoolDiscription(description);
		//kGEntity.setSchoolCategory(schoolCategoury);
		kGEntity.setSchoolHistory(schoolHistory);
		kGEntity.setSchoolFacilities(schoolFacilities);
		kGEntity.setTeachingSituation(teachingSituation);
		return kGEntity;

	}
}
