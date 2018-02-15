package com.hkschool.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hkschool.models.PSEntity;
import com.hkschool.repository.PSJpaRepository;

@Component
public class MSPSService {

	@Resource
	private PSJpaRepository schoolJpaRepository;

	public void pull() {
		for(int index = 0 ; index < 19 ; index++) {
			try {
				pull(index);
			} catch(Exception e) {
				
			}
		}
		try {
			//pull("", "");
		} catch (Exception e) {
		
		}
	}
	
	public void pull(int pageIndex) {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.myschool.hk/primary-school/Ranking.php").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements trs = doc.getElementsByClass("tbfont").get(0).getElementsByTag("tr");

		int cnt = 0;
		for(int index = 1 ; index < trs.size() ; index++) {
			Element tr = trs.get(index);
			Elements links = tr.getElementsByTag("a");
			if(links.size() > 0) {
				Element link = links.get(0);
				String schoolId = link.attr("href").replace("/primary-school/", "");
				String schoolName = link.text();
				System.out.println(index + " )" + schoolName + " == " + schoolId);
				
				
				if (schoolJpaRepository.findBySchoolId(schoolId) == null) {
					try {
						schoolJpaRepository.save(pull(schoolName, schoolId));
						System.out.println("Added " + schoolId + " " + cnt);
					} catch (Exception e) {
						System.out.println("Failed to add " + schoolId + " " + cnt);
						System.out.println("Error : " + e.getMessage());
					}
				} else {
					System.out.println("Already exists " + schoolId + " " + cnt);
				}
				cnt++;
			}
		}
		
	}
	
	private PSEntity pull(String schoolName, String schoolId) throws IOException {
		Document doc = Jsoup.connect("https://www.myschool.hk/primary-school/" + schoolId).get();
		//Document doc = Jsoup.parse(Html.str + Html.str2);
		
		Elements elements = doc.getElementsByClass("detail-container");
		
		System.out.println(schoolId + " ==> " + elements.get(0).getElementsByTag("link").get(0).text());
		for(int index = 0 ; index < elements.size() ; index++) {
			Elements links = elements.get(index).getElementsByTag("a");
			//System.out.println("###################################");
			for (int index1 = 0; index1 < links.size(); index1++) {
				Element link = links.get(index1);
				System.out.println(index + ") " + index1 + ") " + link);
				
			}
				Element schoolAddress = links.get(0); 
				//System.out.println(schoolAddress);
				Element Tel = links.get(1);
				///System.out.println(Tel);
				
				
			
		}
		
		PSEntity schoolEntity = new PSEntity();
		//schoolEntity.setSchoolName(elements.get(0).getElementsByTag("link").get(25).text());
		schoolEntity.setSchoolId(schoolId);
		return schoolEntity;
	}

	private void index() {
		// TODO Auto-generated method stub
		
	}

}
