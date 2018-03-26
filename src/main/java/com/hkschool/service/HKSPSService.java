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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hkschool.models.PSEntity;
import com.hkschool.repository.PSJpaRepository;
import com.hkschool.util.ImageDownloader;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Component
public class HKSPSService {

	static int cnt1 = 0;
	static int cnt2 = 0;

	@Resource
	private PSJpaRepository schoolJpaRepository;

	@Resource
	ImageDownloader imageDownloader;

	@Value(value = "${images.path}")
	String imagePath = "";

	@Value(value = "${images.pathTop}")
	String imagePathTop = "";

	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/psdt_processing.php?draw=1").asJson()
				.getBody();
		JSONArray records = (JSONArray) jsonResponse.getObject().get("data");

		for (int index = 0; index < records.length(); index++) {
			JSONArray elements = (JSONArray) records.get(index);
			String element = (String) elements.get(0);
			String[] tokens = element.replace('"', '@').replace('<', '@').replace('>', '@').split("@");

			if (tokens[1] != null) {
				String schoolId = tokens[2];
				String schoolName = tokens[4];
				PSEntity pSEntity = pull(schoolId, schoolName);
				if (pSEntity != null) {
					try {
						schoolJpaRepository.save(pSEntity);
						System.out.println("Updated " + schoolName + " " + cnt1++);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Failed to update " + schoolName + " " + cnt1);
					}
				} else {
					System.out.println("Not found " + schoolName + " " + cnt2++);
				}
			}
		}
	}

	private PSEntity pull(String schoolId, String schoolName) throws IOException {

		PSEntity  pSEntity  = schoolJpaRepository.findBySchoolName(schoolName);

		try {
			Document doc = Jsoup.connect("https://www.schooland.hk/ps/" + schoolId).get();
			
			if(pSEntity == null) {
				String regex = "[0-9]{8}";
				Pattern p = Pattern.compile(regex);
				String contact = doc.getElementsByClass("contact").get(0).text();
				Matcher m = p.matcher(contact);
				
				if(m.find()) {
					String tel = m.group(0);
					tel = "%" + tel + "%";
					pSEntity = schoolJpaRepository.findByTel(tel);
				}
			}
			
			if(pSEntity == null) {
				return null;
			}
			
			Elements rows = doc.getElementsByClass("row");

			Element row = rows.get(0);
			String description = row.getElementsByTag("p").get(0).text();

			row = rows.get(1);
			// String schoolCategoury = row.getElementsByTag("h4").get(0).text();
			String schoolCategouryTitle = row.getElementsByTag("p").get(0).text();

			row = rows.get(2);
			String schoolHistory = row.getElementsByTag("p").get(0).text();
			String schoolHistoryTitle = row.getElementsByTag("h4").get(0).text();

			row = rows.get(3);
			String schoolFacilities = row.getElementsByTag("p").get(0).text();
			String schoolFacilitiesTitle = row.getElementsByTag("h4").get(0).text();

			row = rows.get(4);// Situation
			String teachingSituation = row.getElementsByTag("p").get(0).text();
			String teachingSituationTitle = row.getElementsByTag("h4").get(0).text();

			Element table = row.getElementsByClass("education-state").get(0);
			Elements tds = table.getElementsByTag("td");

			String schoolYear2013 = tds.get(0).text();
			String schoolTeachers2013 = tds.get(1).text();
			String approvalPreparation2013 = tds.get(2).text();
			String total2013 = tds.get(3).text();
			String smallOne2013 = tds.get(4).text();
			String smallTwo2013 = tds.get(5).text();
			String smallThree2013 = tds.get(6).text();
			String smallFour2013 = tds.get(7).text();
			String smallFive2013 = tds.get(8).text();
			String littleSix2013 = tds.get(9).text();
			String schoolYear2014 = tds.get(10).text();
			String schoolTeachers2014 = tds.get(11).text();
			String approvalPreparation2014 = tds.get(12).text();
			String total2014 = tds.get(13).text();
			String smallOne2014 = tds.get(14).text();
			String smallTwo2014 = tds.get(15).text();
			String smallThree2014 = tds.get(16).text();
			String smallFour2014 = tds.get(17).text();
			String smallfive2014 = tds.get(18).text();
			String littlesix2014 = tds.get(19).text();
			String schoolyear2015 = tds.get(20).text();
			String schoolTeachers2015 = tds.get(21).text();
			String approvalPreparation2015 = tds.get(22).text();
			String total2015 = tds.get(23).text();
			String smallOne2015 = tds.get(24).text();
			String smallTwo2015 = tds.get(25).text();
			String smallThree2015 = tds.get(26).text();
			String smallFour2015 = tds.get(27).text();
			String smallfive2015 = tds.get(28).text();
			String littlesix2015 = tds.get(29).text();
			String schoolyear2016 = tds.get(30).text();
			String schoolTeachers2016 = tds.get(31).text();
			String approvalPreparation2016 = tds.get(32).text();
			String total2016 = tds.get(33).text();
			String smallOne2016 = tds.get(34).text();
			String smallTwo2016 = tds.get(35).text();
			String smallThree2016 = tds.get(36).text();
			String smallFour2016 = tds.get(37).text();
			String smallfive2016 = tds.get(38).text();
			String littlesix2016 = tds.get(39).text();
			String schoolyear2017 = tds.get(40).text();
			String schoolTeachers2017 = tds.get(41).text();
			String approvalPreparation2017 = tds.get(42).text();
			String total2017 = tds.get(43).text();
			String smallOne2017 = tds.get(44).text();
			String smallTwo2017 = tds.get(45).text();
			String smallThree2017 = tds.get(46).text();
			String smallFour2017 = tds.get(47).text();
			String smallfive2017 = tds.get(48).text();
			String littlesix2017 = tds.get(49).text();

			pSEntity.setSchoolCategouryTitle(schoolCategouryTitle);
			pSEntity.setSchoolFacilitiesTitle(schoolFacilitiesTitle);
			pSEntity.setSchoolHistoryTitle(schoolHistoryTitle);
			pSEntity.setTeachingSituationTitle(teachingSituationTitle);

			pSEntity.setSchoolDiscritpion(description);
			// pSEntity.setSchoolCategory(schoolCategoury);
			pSEntity.setSchoolHistory(schoolHistory);
			pSEntity.setSchoolFacilities(schoolFacilities);
			pSEntity.setTeachingSituation(teachingSituation);

			pSEntity.setSchoolYear2013(schoolYear2013);
			pSEntity.setSchoolTeachers2013(schoolTeachers2013);
			pSEntity.setApprovalPreparation2013(approvalPreparation2013);
			pSEntity.setTotal2013(total2013);
			pSEntity.setSmallOne2013(smallOne2013);
			pSEntity.setSmallTwo2013(smallTwo2013);
			pSEntity.setSmallThree2013(smallThree2013);
			pSEntity.setSmallFour2015(smallFour2013);
			pSEntity.setSmallFive2013(smallFive2013);
			pSEntity.setLittleSix2013(littleSix2013);
			pSEntity.setSchoolYear2014(schoolYear2014);
			pSEntity.setSchoolTeachers2014(schoolTeachers2014);
			pSEntity.setApprovalPreparation2014(approvalPreparation2014);
			pSEntity.setTotal2014(total2014);
			pSEntity.setSmallOne2014(smallOne2014);
			pSEntity.setSmallTwo2014(smallTwo2014);
			pSEntity.setSmallThree2014(smallThree2014);
			pSEntity.setSmallFour2014(smallFour2014);
			pSEntity.setSmallfive2014(smallfive2014);
			pSEntity.setLittlesix2014(littlesix2014);
			pSEntity.setSchoolyear2015(schoolyear2015);
			pSEntity.setSchoolTeachers2015(schoolTeachers2015);
			pSEntity.setApprovalPreparation2015(approvalPreparation2015);
			pSEntity.setTotal2015(total2015);
			pSEntity.setSmallOne2015(smallOne2015);
			pSEntity.setSmallTwo2015(smallTwo2015);
			pSEntity.setSmallThree2015(smallThree2015);
			pSEntity.setSmallFour2015(smallFour2015);
			pSEntity.setSmallfive2015(smallfive2015);
			pSEntity.setLittlesix2015(littlesix2015);
			pSEntity.setSchoolyear2016(schoolyear2016);
			pSEntity.setSchoolTeachers2016(schoolTeachers2016);
			pSEntity.setApprovalPreparation2016(approvalPreparation2016);
			pSEntity.setTotal2016(total2016);
			pSEntity.setSmallOne2016(smallOne2016);
			pSEntity.setSmallTwo2016(smallTwo2016);
			pSEntity.setSmallThree2016(smallThree2016);
			pSEntity.setSmallFour2016(smallFour2016);
			pSEntity.setSmallfive2016(smallfive2016);
			pSEntity.setLittlesix2016(littlesix2016);
			pSEntity.setSchoolyear2017(schoolyear2017);
			pSEntity.setSchoolTeachers2017(schoolTeachers2017);
			pSEntity.setApprovalPreparation2017(approvalPreparation2017);
			pSEntity.setTotal2017(total2017);
			pSEntity.setSmallOne2017(smallOne2017);
			pSEntity.setSmallTwo2017(smallTwo2017);
			pSEntity.setSmallThree2017(smallThree2017);
			pSEntity.setSmallFour2017(smallFour2017);
			pSEntity.setSmallfive2017(smallfive2017);
			pSEntity.setLittlesix2017(littlesix2017);
			
			String imageUrl = pSEntity.getImage();

			if (imageUrl == null || imageUrl.isEmpty()) {
				row = rows.get(9);// school images
				row = doc.getElementsByClass("contact-pic").get(0);
				Element link = row.getElementsByTag("img").get(0);

				imageUrl = "https://www.schooland.hk" + link.attr("src");
				String imageBottomS3url = imageDownloader.saveImage(imageUrl, "ps");
				pSEntity.setImage(imageBottomS3url);
			}

			String imageUrlTop = pSEntity.getImageTop();

			if (imageUrlTop == null || imageUrlTop.isEmpty()) {
				row = rows.get(0);// school imagesTop
				row = doc.getElementsByClass("photo-box").get(0);
				Element link1 = row.getElementsByTag("img").get(0);

				imageUrlTop = "https://www.schooland.hk" + link1.attr("src");
				String imageBottomS3url = imageDownloader.saveImage(imageUrl, "ps");
				pSEntity.setImageTop(imageBottomS3url);
			}
		} catch (Exception e) {}
		
		return pSEntity;
	}

}