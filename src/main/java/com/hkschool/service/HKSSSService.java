package com.hkschool.service;

import java.io.IOException;

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
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Component
public class HKSSSService {

	@Resource
	private SSJpaRepository schoolJpaRepository;

	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/server_processing.php?draw=1").asJson().getBody();
		JSONArray records = (JSONArray) jsonResponse.getObject().get("data");

		int cnt = 0;
		for (int index = 0; index < records.length(); index++) {
			JSONObject elements = (JSONObject) records.get(index);
			String element = (String) elements.get("0");
			String[] tokens = element.replace('"', '@').split("@");

			if (tokens[1] != null) {

				String schoolId = tokens[1];
				if (schoolJpaRepository.findBySchoolId(schoolId) == null) {
					try {
						// pull(schoolId);
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

	private SSEntity pull(String schoolId) throws IOException {

		Document doc = Jsoup.connect("https://www.schooland.hk/ss/" + schoolId).get();
		Elements rows = doc.getElementsByClass("row");

		Element row = rows.get(1);
		Element element = doc.getElementsByClass("chinese-name").get(0);
		String schoolName = element.text();
		String description = row.getElementsByTag("p").get(0).text();

		row = rows.get(2);
		String schoolCategoury = row.getElementsByTag("h4").get(0).text();
		//element = doc.getElementsByTag("h4").get(0);
		
		
		row = rows.get(3);
		String SchoolHistory = row.getElementsByTag("h4").get(0).text();
		//element = doc.getElementsByTag("h4").get(0);
		
		row = rows.get(4);
		String SchoolTeachingSituation = row.getElementsByTag("h4").get(0).text();
		//element = doc.getElementsByTag("h4").get(0);
		
				
		row = rows.get(8);
		row.getElementsByTag("h4").get(0).text();
		//element = doc.getElementsByTag("h4").get(0);

		row = rows.get(9);
		String SchoolRelatedPrimarySchool = row.getElementsByTag("h4").get(0).text();
		//element = doc.getElementsByTag("h4").get(0);
		
		//row = rows.get(10).text();
		element = doc.getElementsByClass("contact").get(0);
		String contact = element.text();
		String tokens[] = contact.split("：");
		String address = tokens[1];
		String telephone = tokens[2];
		String fax = tokens[3];
		String email = tokens[4];
		String website = tokens[5];
		String supervisor = tokens[6];
		String principal = tokens[7];

		//System.out.println("");
		/*System.out.println(schoolId);
		System.out.println(schoolName);
		System.out.println(description);
		System.out.println(schoolCategoury);
		System.out.println(SchoolHistory);
		System.out.println(SchoolTeachingSituation);
		System.out.println(SchoolRelatedPrimarySchool);
		System.out.println(schoolTeachingLanguage);
		System.out.println(address);
		System.out.println(telephone);
		System.out.println(fax);
		System.out.println(website);
		System.out.println(supervisor);
		System.out.println(principal);*/

		SSEntity sSEntity = new SSEntity();

		sSEntity.setSchoolId(schoolId);
		sSEntity.setSchoolName(schoolName);
		sSEntity.setSchoolDiscritpion(description);
		sSEntity.setSchoolCategory(schoolCategoury);
		sSEntity.setSchoolHistory(SchoolHistory);
		sSEntity.setSchoolSituation(SchoolTeachingSituation);
		sSEntity.setRelatedPrimarySchool(SchoolRelatedPrimarySchool);
		//sSEntity.setSchoolTeachingLanguage(schoolTeachingLanguage);
		sSEntity.setAddress(address);
		sSEntity.setTel(telephone);
		sSEntity.setFax(fax);
		sSEntity.setSchoolWebsite(website);
		sSEntity.setSchoolEmail(email);
		sSEntity.setNameofSchoolSupervisor(supervisor);
		sSEntity.setNameofSchoolPrincipal(principal);

		return sSEntity;
	}

}
