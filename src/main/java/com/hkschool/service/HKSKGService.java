package com.hkschool.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

	//@Value(value = "${images.path}")
	//String imagePath = "";

	//@Value(value = "${images.pathTop}")
	//String imagePathTop = "";

	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/kgdt_processing.php?draw=1").asJson()
				.getBody();
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
				KGEntity kGEntity = pull(schoolId, schoolName);
				if (kGEntity != null) {
					try {
						schoolJpaRepository.save(kGEntity);
						System.out.println("updated : " + schoolName + " " + cnt1++);
					} catch (Exception e) {
						System.out.println("Error : " + e.getMessage());
					}
				} else {
					System.out.println("not found to updadte : " + schoolName + " " + cnt2++);
				}
			}
		}
	}

	private KGEntity pull(String schoolId, String schoolName) throws IOException {
		
		KGEntity kGEntity = schoolJpaRepository.findBySchoolName(schoolName);
		
		try {
			
			Document doc = Jsoup.connect("https://www.schooland.hk/kg/" + schoolId).get();
			
			if(kGEntity == null) {
				String regex = "[0-9]{8}";
				Pattern p = Pattern.compile(regex);
				String contact = doc.getElementsByClass("contact").get(0).text();
				Matcher m = p.matcher(contact);
				
				if(m.find()) {
					String tel = m.group(0);
					tel = "%" + tel.substring(0, 4) + " " + tel.substring(4) + "%";
					kGEntity = schoolJpaRepository.findByTel(tel);
				}
			}
			
			if(kGEntity == null) {
				return null;
			}
			
			Elements rows = doc.getElementsByClass("row");

			Element row = null;
			
			try {
				row = rows.get(0);
				String description = row.getElementsByTag("p").get(0).text();
				kGEntity.setSchoolDiscription(description);
			} catch(Exception e) { }

			try {
				row = rows.get(2);// schoolHistory
				String schoolHistory = row.getElementsByTag("p").get(0).text();
				kGEntity.setSchoolHistory(schoolHistory);
				String schoolHistoryTitle = row.getElementsByTag("h4").get(0).text();
				kGEntity.setSchoolHistoryTitle(schoolHistoryTitle);
			} catch(Exception e) { }

			try {
				row = rows.get(3);// schoolFacilities
				String schoolFacilities = row.getElementsByTag("p").get(0).text();
				kGEntity.setSchoolFacilities(schoolFacilities);
				String schoolFacilitiesTitle = row.getElementsByTag("h4").get(0).text();
				kGEntity.setSchoolFacilitiesTitle(schoolFacilitiesTitle);
			} catch(Exception e) { }

			try {
				row = rows.get(4);// School situation
				String teachingSituation = row.getElementsByTag("p").get(0).text();
				kGEntity.setTeachingSituation(teachingSituation);
				String teachingSituationTitle = row.getElementsByTag("h4").get(0).text();
				kGEntity.setTeachingSituationTitle(teachingSituationTitle);
			} catch(Exception e) { }

			try {
				row = rows.get(5);// School fees
				String schoolFees = row.getElementsByTag("p").get(0).text();
				kGEntity.setSchoolFees(schoolFees);
				String schoolFeesTitle = row.getElementsByTag("h4").get(0).text();
				kGEntity.setSchoolFeesTitle(schoolFeesTitle);
			} catch(Exception e) { }

			try {
				row = rows.get(1);// schoolCategoury
				String schoolCategoury = row.getElementsByTag("p").get(0).text();
				kGEntity.setSchoolCategory(schoolCategoury);
				String schoolCategouryTitle = row.getElementsByTag("h4").get(0).text();
				kGEntity.setSchoolCategouryTitle(schoolCategouryTitle);
			} catch(Exception e) { }

			String imageUrl = kGEntity.getImage();

			if (imageUrl == null || imageUrl.isEmpty()) {
				try {
					row = rows.get(5);// school images
					row = doc.getElementsByClass("contact-pic").get(0);
					Element link = row.getElementsByTag("img").get(0);
	
					imageUrl = "https://www.schooland.hk" + link.attr("src");
					String imageBottomS3url = imageDownloader.saveImage(imageUrl, "kg");
					kGEntity.setImage(imageBottomS3url);
				} catch(Exception e) { }
			}

			String imageUrlTop = kGEntity.getImageTop();

			if (imageUrlTop == null || imageUrlTop.isEmpty()) {
				try {
					row = rows.get(1);// school imagesTop
					row = doc.getElementsByClass("photo-box").get(0);
					Element link1 = row.getElementsByTag("img").get(0);
	
					imageUrlTop = "https://www.schooland.hk" + link1.attr("src");
					String imageTopS3url = imageDownloader.saveImage(imageUrlTop, "kg");
					kGEntity.setImageTop(imageTopS3url);
				} catch(Exception e) { }
			}

		} catch (Exception e) {
		}
		return kGEntity;

	}
}
