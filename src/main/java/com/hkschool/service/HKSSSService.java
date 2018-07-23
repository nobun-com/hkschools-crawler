package com.hkschool.service;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hkschool.models.SSEntity;
import com.hkschool.repository.SSJpaRepository;
import com.hkschool.util.ImageDownloader;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Component
public class HKSSSService {

	static int cnt = 0;

	@Resource
	private SSJpaRepository schoolJpaRepository;

	@Resource
	ImageDownloader imageDownloader;

	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/server_processing.php?draw=1").asJson()
				.getBody();
		JSONArray records = (JSONArray) jsonResponse.getObject().get("data");

		for (int index = 0; index < records.length(); index++) {
			JSONObject elements = (JSONObject) records.get(index);
			String element = (String) elements.get("0");
			String[] tokens = element.replace('"', '@').replace('<', '@').replace('>', '@').split("@");

			if (tokens[1] != null) {
				String schoolId = tokens[2];
				String schoolName = tokens[4];
				SSEntity sSEntity = pull(schoolId, schoolName);
				if (sSEntity != null) {
					try {
						sSEntity.setUpdatedOn(new Date());
						schoolJpaRepository.save(sSEntity);
						System.out.println("SS Updated " + schoolName);
					} catch (Exception e) {
						cnt++;
						System.out.println("Failed to update SS " + schoolName + " " + cnt);
					}
				} else {
					System.out.println("SS Not found " + schoolName);
				}
			}
		}
	}

	private SSEntity pull(String schoolId, String schoolName) throws IOException {

		SSEntity sSEntity = schoolJpaRepository.findBySchoolName(schoolName);

		try {
			Document doc = Jsoup.connect("https://www.schooland.hk/ss/" + schoolId).get();
			
			if(sSEntity == null) {
				String regex = "[0-9]{8}";
				Pattern p = Pattern.compile(regex);
				String contact = doc.getElementsByClass("contact").get(0).text();
				Matcher m = p.matcher(contact);
				
				if(m.find()) {
					String tel = m.group(0);
					tel = "%" + tel + "%";
					sSEntity = schoolJpaRepository.findByTel(tel);
				}
			}
			
			if(sSEntity == null) {
				return null;
			}
			
			Elements rows = doc.getElementsByClass("row");

			Element row = rows.get(1);

			try {
				row = rows.get(2);
				String schoolCategoury = row.getElementsByTag("p").get(0).text();
				String schoolCategouryTitle = row.getElementsByTag("p").get(0).text();
				sSEntity.setSchoolCategouryTitle(schoolCategouryTitle);
				sSEntity.setSchoolCategory(schoolCategoury);
			} catch(Exception e) { }

			try {
				row = rows.get(3);
				String SchoolHistory = row.getElementsByTag("p").get(0).text();
				String SchoolHistoryTitle = row.getElementsByTag("p").get(0).text();
				sSEntity.setSchoolHistoryTitle(SchoolHistoryTitle);
				sSEntity.setSchoolHistory(SchoolHistory);
			} catch(Exception e) { }

			try {
				row = rows.get(4);// Situation
				String teachingSituation = row.getElementsByTag("p").get(0).text();
				String teachingSituationTitle = row.getElementsByTag("p").get(0).text();
				sSEntity.setTeachingSituation(teachingSituation);
				sSEntity.setTeachingSituationTitle(teachingSituationTitle);
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
	
	
				sSEntity.setSchoolYear2013(schoolYear2013);
				sSEntity.setSchoolTeachers2013(schoolTeachers2013);
				sSEntity.setApprovalPreparation2013(approvalPreparation2013);
				sSEntity.setTotal2013(total2013);
				sSEntity.setSmallOne2013(smallOne2013);
				sSEntity.setSmallTwo2013(smallTwo2013);
				sSEntity.setSmallThree2013(smallThree2013);
				sSEntity.setSmallFour2015(smallFour2013);
				sSEntity.setSmallFive2013(smallFive2013);
				sSEntity.setLittleSix2013(littleSix2013);
				sSEntity.setSchoolYear2014(schoolYear2014);
				sSEntity.setSchoolTeachers2014(schoolTeachers2014);
				sSEntity.setApprovalPreparation2014(approvalPreparation2014);
				sSEntity.setTotal2014(total2014);
				sSEntity.setSmallOne2014(smallOne2014);
				sSEntity.setSmallTwo2014(smallTwo2014);
				sSEntity.setSmallThree2014(smallThree2014);
				sSEntity.setSmallFour2014(smallFour2014);
				sSEntity.setSmallfive2014(smallfive2014);
				sSEntity.setLittlesix2014(littlesix2014);
				sSEntity.setSchoolyear2015(schoolyear2015);
				sSEntity.setSchoolTeachers2015(schoolTeachers2015);
				sSEntity.setApprovalPreparation2015(approvalPreparation2015);
				sSEntity.setTotal2015(total2015);
				sSEntity.setSmallOne2015(smallOne2015);
				sSEntity.setSmallTwo2015(smallTwo2015);
				sSEntity.setSmallThree2015(smallThree2015);
				sSEntity.setSmallFour2015(smallFour2015);
				sSEntity.setSmallfive2015(smallfive2015);
				sSEntity.setLittlesix2015(littlesix2015);
				sSEntity.setSchoolyear2016(schoolyear2016);
				sSEntity.setSchoolTeachers2016(schoolTeachers2016);
				sSEntity.setApprovalPreparation2016(approvalPreparation2016);
				sSEntity.setTotal2016(total2016);
				sSEntity.setSmallOne2016(smallOne2016);
				sSEntity.setSmallTwo2016(smallTwo2016);
				sSEntity.setSmallThree2016(smallThree2016);
				sSEntity.setSmallFour2016(smallFour2016);
				sSEntity.setSmallfive2016(smallfive2016);
				sSEntity.setLittlesix2016(littlesix2016);
				sSEntity.setSchoolyear2017(schoolyear2017);
				sSEntity.setSchoolTeachers2017(schoolTeachers2017);
				sSEntity.setApprovalPreparation2017(approvalPreparation2017);
				sSEntity.setTotal2017(total2017);
				sSEntity.setSmallOne2017(smallOne2017);
				sSEntity.setSmallTwo2017(smallTwo2017);
				sSEntity.setSmallThree2017(smallThree2017);
				sSEntity.setSmallFour2017(smallFour2017);
				sSEntity.setSmallfive2017(smallfive2017);
				sSEntity.setLittlesix2017(littlesix2017);
			} catch(Exception e) { }

			String imageUrl = sSEntity.getImage();
			if (imageUrl == null || imageUrl.isEmpty()) {
				try {
					row = rows.get(11);// school images
					row = doc.getElementsByClass("contact-pic").get(0);
					Element link = row.getElementsByTag("img").get(0);
					imageUrl = "https://www.schooland.hk" + link.attr("src");
					String imageBottomS3url = imageDownloader.saveImage(imageUrl, "ss");
					sSEntity.setImage(imageBottomS3url);
				} catch(Exception e) {}
			}

			String imageUrlTop = sSEntity.getImageTop();

			if (imageUrlTop == null || imageUrlTop.isEmpty()) {
				try {
					row = rows.get(1);// school imagesTop
					row = doc.getElementsByClass("photo-box").get(0);
					Element link1 = row.getElementsByTag("img").get(0);
					imageUrlTop = "https://www.schooland.hk" + link1.attr("src");
					String imageBottomS3url = imageDownloader.saveImage(imageUrl, "ss");
					sSEntity.setImageTop(imageBottomS3url);
				} catch(Exception e) {}

			}

		} catch (Exception e) { }
		return sSEntity;
	}

}
