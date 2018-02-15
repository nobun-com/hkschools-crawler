package com.hkschool.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hkschool.models.KGEntity;
import com.hkschool.models.KGEntity;
import com.hkschool.repository.KGJpaRepository;
import com.hkschool.repository.KGJpaRepository;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Component
public class HKSKGService {

	@Resource
	private KGJpaRepository schoolJpaRepository;
	private String contact;

	public void pull() throws Exception {
		JsonNode jsonResponse = Unirest.get("https://www.schooland.hk/ajax/kgdt_processing.php?draw=2").asJson().getBody();
		JSONArray records = (JSONArray) jsonResponse.getObject().get("data");

		int cnt = 0;
		for (int index = 0; index < records.length(); index++) {
			JSONArray elements = (JSONArray) records.get(index);
			String element = (String) elements.get(0);
			String[] tokens = element.replace('"', '@').split("@");
			
			if (tokens[1] != null) {
				String schoolName = element.split("<|>")[2];
				String schoolId = tokens[1];
				if (schoolJpaRepository.findBySchoolId(schoolId) == null) {
					try {
						//pull(schoolName, schoolId);
						schoolJpaRepository.save(pull(schoolName, schoolId));
						System.out.println("Added " + schoolName + " " + cnt);
					} catch (Exception e) {
						System.out.println("Failed to add " + schoolName + " " + cnt);
						System.out.println("Error : " + e.getMessage());
					}
				} else {
					System.out.println("Already exists " + schoolName + " " + cnt);
				}
				cnt++;
			}
		}

		// pull("ABERDEEN BAPTIST CHURCH PAK KWONG KINDERGARTEN", "kk");
	}

	private KGEntity pull(String schoolName, String schoolId) throws IOException {

		Document doc = Jsoup.connect("https://www.schooland.hk/kg/" + schoolId).get();
		Elements rows = doc.getElementsByClass("row");

		Element row = rows.get(0);
		Element element = row.getElementsByClass("chinese-name").get(0);
		String schoolName1 = element.text();
		String description = row.getElementsByTag("p").get(0).text();

		row = rows.get(1);
		String schoolCategoury = row.getElementsByTag("p").get(0).text();

		row = rows.get(2);
		String schoolFacilities = row.getElementsByTag("h4").get(0).text();
		
		row = rows.get(3);
		String schoolHistory = row.getElementsByTag("h4").get(0).text();

		row = rows.get(4);
		String schoolSituation = row.getElementsByTag("h4").get(0).text();

		row = rows.get(5);
		String schoolclassrooms = row.getElementsByTag("h4").get(0).text();

		row = rows.get(6);
		element = doc.getElementsByClass("contact").get(0);
		String contact = element.text();
		String tokens[] = contact.split("：");
		String address = tokens[1];
		String telephone = tokens[3];
		String fax = tokens[4];
		String website = tokens[5];
		String supervisor = tokens[6];
		String principal = tokens[7];

	/*System.out.println("#####################");
		System.out.println(schoolName1);
		System.out.println(description);
		System.out.println(schoolCategoury);
		System.out.println(schoolHistory);
		System.out.println(schoolFacilities);
		System.out.println(schoolSituation);
		System.out.println(schoolFees);
		System.out.println(address);
		System.out.println(telephone);
		System.out.println(fax);
		System.out.println(website);
		System.out.println(supervisor);
		System.out.println(principal);*/

		KGEntity kGEntity = new KGEntity();

		kGEntity.setSchoolName(schoolName);
		kGEntity.setSchoolId(schoolId);
		kGEntity.setSchoolDiscription(description);
		kGEntity.setSchoolCategory(schoolCategoury);
		kGEntity.setSchoolHistory(schoolHistory);
		kGEntity.setSchoolFacilities(schoolFacilities);
		kGEntity.setSchoolSituation(schoolSituation);
		kGEntity.setSchoolFee(schoolclassrooms);
		kGEntity.setAddress(address);
		kGEntity.setTel(telephone);
		kGEntity.setFax(fax);
		kGEntity.setSchoolWebsite(website);
		kGEntity.setNameofSchoolSupervisor(supervisor);
		kGEntity.setNameofSchoolPrincipal(principal);

		return kGEntity;
	}

}
