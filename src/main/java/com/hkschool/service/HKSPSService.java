package com.hkschool.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hkschool.models.PSEntity;
import com.hkschool.repository.PSJpaRepository;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Component
public class HKSPSService {

	@Resource
	private PSJpaRepository schoolJpaRepository;

	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/psdt_processing.php?draw=1").asJson().getBody();
		JSONArray records = (JSONArray) jsonResponse.getObject().get("data");

		int cnt = 0;
		for (int index = 0; index < records.length(); index++) {
			JSONArray elements = (JSONArray) records.get(index);
			String element = (String) elements.get(0);
			String[] tokens = element.replace('"', '@').split("@");

			if (tokens[1] != null) {
				String schoolId = tokens[1];
				if (schoolJpaRepository.findBySchoolId(schoolId) == null) {
					try {
						//pull(schoolId);
						schoolJpaRepository.save(pull(schoolId));
						System.out.println("Added " + schoolId + " " + cnt);
					} catch (Exception e) {
						System.out.println("Failed to add " + schoolId + " " + cnt);
						System.out.println("Error : " + e.getMessage());
						e.printStackTrace();
					}
				} else {
					System.out.println("Already exists " + schoolId + " " + cnt);
				}
				cnt++;
			}
		}
	}

	private PSEntity pull(String schoolId) throws IOException {

		Document doc = Jsoup.connect("https://www.schooland.hk/ps/" + schoolId).get();
		//Document doc = Jsoup.parse(Html2.str);
		Elements rows = doc.getElementsByClass("row");

		Element row = rows.get(0);
		Element element = row.getElementsByClass("chinese-name").get(0);
		String schoolName = element.text();
		String description = row.getElementsByTag("p").get(0).text();

		row = rows.get(1);
		String schoolCategoury = row.getElementsByTag("h4").get(0).text();

		row = rows.get(2);
		String schoolHistory = row.getElementsByTag("h4").get(0).text();

		row = rows.get(3);
		String schoolFacilities = row.getElementsByTag("h4").get(0).text();

		row = rows.get(4);
		String teachingSituation = row.getElementsByTag("h4").get(0).text();

		row = rows.get(6);
		String schoolFees = row.getElementsByTag("h4").get(0).text();
		
		//row = rows.get(9);
		element = doc.getElementsByClass("contact").get(0);
		String contact = element.text();
		String tokens[] = contact.split("：");
		String address = tokens[1];
		String telephone = tokens[2];
		String fax = tokens[3];
		String email = tokens[4];
		String website = tokens[5];
		String principal = tokens[6];
		String supervisor = tokens[7];
		
		/*System.out.println(schoolId);
		System.out.println(schoolName);
		System.out.println(description);
		System.out.println(schoolCategoury);
		System.out.println(schoolHistory);
		System.out.println(schoolFacilities);
		System.out.println(teachingSituation);
		System.out.println(schoolFees);
		System.out.println(address);
		System.out.println(telephone);
		System.out.println(fax);
		System.out.println(email);
		System.out.println(website);
		System.out.println(principal);
		System.out.println(supervisor);*/

		PSEntity PSEntity = new PSEntity();
		
		PSEntity.setSchoolId(schoolId);
		PSEntity.setSchoolName(schoolName);
		PSEntity.setSchoolDiscritpion(description);
		PSEntity.setSchoolCategory(schoolCategoury);
		PSEntity.setSchoolHistory(schoolHistory);
		PSEntity.setSchoolFacilities(schoolFacilities);
		PSEntity.setSchoolSituation(teachingSituation);
		PSEntity.setSchoolFee(schoolFees);
		PSEntity.setAddress(address);
		PSEntity.setTel(telephone);
		PSEntity.setFax(fax);
		PSEntity.setSchoolEmail(email);
		PSEntity.setSchoolWebsite(website);
		PSEntity.setNameofSchoolPrincipal(principal);
		PSEntity.setNameofSchoolSupervisor(supervisor);
		return PSEntity;
	}

}