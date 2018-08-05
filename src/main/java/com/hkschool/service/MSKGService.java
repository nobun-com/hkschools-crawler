package com.hkschool.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hkschool.models.KGEntity;
import com.hkschool.repository.KGJpaRepository;

import java.io.IOException;

import javax.annotation.Resource;

@Component
public class MSKGService {

	@Value("${crawler.pull.useragent}")
	private String userAgent = "";
	
	@Value("${crawler.pull.timeout}")
	private int timeout = 0;
	
	@Resource
	private KGJpaRepository schoolJpaRepository;
	
	public void pull() {
		for (int pageIndex = 0; pageIndex < 19; pageIndex++) {
			pull(pageIndex);
		}
	}
	
	int cnt1 = 0;
	int cnt2 = 0;
	public void pull(int pageIndex) {
		Document doc = null;
		try {
			String crawlUrl = "https://www.myschool.hk/kindergarten/Ranking.php";
			System.out.println("Crawling: " + crawlUrl);
			doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements trs = doc.getElementsByClass("tbfont").get(0).getElementsByTag("tr");
		for (int index = 1; index < trs.size(); index++) {
			Element tr = trs.get(index);
			Elements links = tr.getElementsByTag("a");
			if (links.size() > 0) {
				Element link = links.get(0);
				String schoolId = link.attr("href").replace("https://www.myschool.hk/school.php?sid=", "");
				String schoolName = link.text();
				KGEntity schoolEntity = schoolJpaRepository.findBySchoolName(schoolName);
				if(schoolEntity != null){
					try {
						pull(schoolId, schoolEntity);
						System.out.println("Found " + schoolName + " " + cnt1++);
					} catch (Exception e) {
						//System.out.println("Failed to add " + schoolName + " " + schoolId);
						System.out.println("Error : " + e.getMessage());
					}
					//System.out.println("Added " + schoolName + " " + schoolId);
				} else {
					//System.out.println("Already exists " + schoolName + " " + schoolId);
					System.out.println("not found " + schoolName + " " + cnt2++);
				}
			}
		}
	}


	private KGEntity pull(String schoolId,KGEntity schoolEntity) throws IOException {
		String crawlUrl = "https://www.myschool.hk/school.php?sid="+ schoolId;
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		//Document doc = Jsoup.parse(MSKGHtml.str);
		Elements elements = doc.getElementsByClass("detail-container");
		Elements item = elements.get(6).getElementsByClass("detail-item");//School-other-chrges
		
		String Summeruniform = item.get(0).text();
		String Winteruniform = item.get(1).text();
		String Schoolbag = item.get(2).text();
		String Teaandsnacks = item.get(3).text();
		String Textbooks = item.get(4).text();
		String Exercisebooks_workbooks = item.get(5).text();
		
		Elements items = elements.get(0).getElementsByClass("detail-item");//School-detail
		
		String SchoolName = items.get(0).text();
		String schoolPartition = items.get(1).text();
		String schoolArea = items.get(2).text();
		String Category = items.get(3).text();
		String studentGender = items.get(4).text();
		String religion = items.get(5).text();
		String schoolAddress = items.get(6).text();
		String schoolTel = items.get(7).text();
		String Fax=items.get(8).text();
		String schoolEmail = items.get(9).text();
		String schoolWebsite = items.get(10).text();
		
		items = elements.get(1).getElementsByClass("detail-item");//teacher-info
		
		String nameOfSchoolPrincipal = items.get(0).text();
		String otherSpecialRoomArea = items.get(6).text();
		String schoolFoundingYear = items.get(1).text();
		String numberOfRegisteredClassrooms=items.get(2).text();
		String indoorPlayground=items.get(3).text().toString().contains("tick.svg") ? "Yes" : "No";
		String outdoorPlayground=items.get(4).toString().contains("tick.svg") ? "Yes" : "No";
		String musicRoom=items.get(5).text().toString().contains("tick.svg") ? "Yes" : "No";
		
		items = elements.get(3).getElementsByClass("detail-item"); //enrollments
		
		String nurseryAMSession = items.get(2).text();
		String lowerKGAMSession = items.get(3 ).text();
		String upperKGAMSession = items.get(4 ).text();
		String nurseryPMSession = items.get(5).text();
		String lowerKGPMSession = items.get(6).text();
		String upperKGPMSession = items.get(7).text();
		String nurseryWDSession = items.get(8).text();
		String lowerKGWDSession = items.get(9).text();
		String upperKGWDSession = items.get(10).text();
		
		items = elements.get(5).getElementsByClass("detail-item"); //Charge-Detail
		
		String nurseryAMSessionfees = items.get(2).text();
		String lowerKGAMSessionfees = items.get(4).text();
		String upperKGAMSessionfees = items.get(5 ).text();
		String nurseryPMSessionfess = items.get(6).text();
		String lowerKGPMSessionfees = items.get(7).text();
		String upperKGPMSessionfees = items.get(8).text();
		String nurseryWDSessionfees = items.get(9).text();
		String lowerKGWDSessionfees = items.get(10).text();
		String upperKGWDSessionfees = items.get(11).text();
		
		//System.out.println("##############################################");
		//System.out.println(Fax + " : " + schoolEntity.getFax());
		//System.out.println(schoolTel + " : " + schoolEntity.getTel());
		//System.out.println("##############################################");
		
		schoolEntity.setSchoolId(schoolId);
		schoolEntity.setSchoolName(SchoolName);
		schoolEntity.setSource("Myschool-hk");
		schoolEntity.setSchoolDiscription(schoolPartition);
		schoolEntity.setSchoolCategory(Category);
		schoolEntity.setAddress(schoolAddress);
		schoolEntity.setTel(schoolTel);
		schoolEntity.setFax(Fax);
		//schoolEntity.setSchoolEmail(schoolEmail);
		schoolEntity.setSchoolWebsite(schoolWebsite);
		schoolEntity.setNameofSchoolPrincipal(nameOfSchoolPrincipal);
		schoolEntity.setOtherSpecialRoom(otherSpecialRoomArea);
		schoolEntity.setSchoolFoundingyear(schoolFoundingYear);
		schoolEntity.setNumberOfRegisteredClassrooms(numberOfRegisteredClassrooms);
		schoolEntity.setOutDoorPlayground(outdoorPlayground);
		schoolEntity.setIndoorPlayground(indoorPlayground);
		schoolEntity.setMusicRoom(musicRoom);
		
		schoolEntity.setSummerUniform(Summeruniform);
		schoolEntity.setWinterUniform(Winteruniform);
		schoolEntity.setSchoolBag(Schoolbag);
		schoolEntity.setTeaAndSnacks(Teaandsnacks);
		schoolEntity.setTextBoo0ks(Textbooks);
		schoolEntity.setExerciseBook_workbooks(Exercisebooks_workbooks);
		
		schoolEntity.setNurseryAMSession(nurseryAMSession);
		schoolEntity.setLowerKGAMSession(lowerKGAMSession);
		schoolEntity.setUpperKGAMSession(upperKGAMSession);
		schoolEntity.setNurseryPMSession(nurseryPMSession);
		schoolEntity.setLowerKGPMSession(lowerKGPMSession);
		schoolEntity.setUpperKGPMSession(upperKGPMSession);
		schoolEntity.setNurseryWDSession(nurseryWDSession);
		schoolEntity.setLowerKGWDSession(lowerKGWDSession);
		schoolEntity.setUpperKGWDSession(upperKGWDSession);
		
		schoolEntity.setNurseryAMSessionfees(nurseryAMSessionfees);
		schoolEntity.setLowerKGAMSessionfees(lowerKGAMSessionfees);
		//schoolEntity.setUpperKGAMSessionfees(upperKGAMSessionfees);
		schoolEntity.setNurseryPMSessionfees(nurseryPMSessionfess);
		schoolEntity.setLowerKGPMSessionfees(lowerKGPMSessionfees);
		schoolEntity.setUpperKGPMSessionfees(upperKGPMSessionfees);
		schoolEntity.setNurseryWDSessionfees(nurseryWDSessionfees);
		schoolEntity.setLowerKGWDSessionfees(lowerKGWDSessionfees);
		schoolEntity.setUpperKGWDSessionfees(upperKGWDSessionfees);
		return schoolEntity;
	}
}
