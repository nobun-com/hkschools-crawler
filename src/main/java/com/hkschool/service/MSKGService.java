package com.hkschool.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;







import com.hkschool.models.KGEntity;
import com.hkschool.repository.KGJpaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Component
public class MSKGService {

	 private static final char[] area = null;
	@Resource
	private KGJpaRepository schoolJpaRepository;
	private Object document;
	private Document doc;
	private KGJpaRepository SchoolJpaRepository;

	public void pull() {
		for (int pageIndex = 0; pageIndex < 19; pageIndex++) {
			pull(pageIndex);
		}
		try {
			 //pull("", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public void pull(int pageIndex) {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.myschool.hk/kindergarten/Ranking.php").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements trs = doc.getElementsByClass("tbfont").get(0).getElementsByTag("tr");
		for (int index = 1; index < trs.size(); index++) {
			Element tr = trs.get(index);
			Elements links = tr.getElementsByTag("a");
			if (links.size() > 0) {
				Element link = links.get(0);
				String schoolId = link.attr("href").replace("http://www.myschool.hk/school.php?sid=", "");
				String schoolName = link.text();
				try {
					pull(schoolName, schoolId);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private KGEntity pull(String schoolName, String schoolId) throws IOException {
		Document doc = Jsoup.connect("http://www.myschool.hk/school.php?sid="+ schoolId).get();
		Elements elements = doc.getElementsByClass("detail-container");
		
		Elements items = elements.get(0).getElementsByClass("detail-item");
			String schoolEnglishName = items.get(0).text();
			String schoolPartition = items.get(1).text();
			String schoolArea = items.get(2).text();
			String Category = items.get(3).text();
			String studentGender = items.get(4).text();
			String religion = items.get(5).text();
			String schoolAddress = items.get(6).text();
			String schoolTel = items.get(8).text();
			String schoolEmail = items.get(10).text();
			String schoolWebsite = items.get(9).text();
			String Fees = items.get(13).text();
			
			/*System.out.println(schoolEnglishName);
			System.out.println(schoolPartition);
			System.out.println(schoolArea);
			System.out.println(Category);
			System.out.println(studentGender);
			System.out.println(religion);
			System.out.println(schoolAddress);
			System.out.println(schoolTel);
			System.out.println(schoolFax);
			System.out.println(schoolEmail);
			System.out.println(schoolWebsite);
			System.out.println(principalName);
			System.out.println( yearOfSchool);
			System.out.println(numberOfClassrooms);*/
		KGEntity schoolEntity = new KGEntity();
		schoolEntity.setSchoolId(schoolId);
		
		schoolEntity.setSchoolEnglishName(schoolEnglishName);
		schoolEntity.setSchoolDiscription(schoolPartition);
		schoolEntity.setSchoolSize(schoolArea);
		schoolEntity.setSchoolCategory(Category);
		schoolEntity.setStudentGender(studentGender);
		schoolEntity.setReligion(religion);
		schoolEntity.setAddress(schoolAddress);
		schoolEntity.setTel(schoolTel);
		schoolEntity.setSchoolEmail(schoolEmail);
		schoolEntity.setSchoolWebsite(schoolWebsite);
		
		return schoolEntity;

	}
}
