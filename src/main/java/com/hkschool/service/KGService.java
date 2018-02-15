package com.hkschool.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hkschool.models.KGEntity;
import com.hkschool.repository.KGJpaRepository;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Component
public class KGService {

	@Resource
	private KGJpaRepository schoolJpaRepository;

	public void pull() throws IOException {
		Document doc = Jsoup.connect("http://kgp2017.highlight.hk/edb/school.php?lang=en").get();
		Elements totalTables = doc.getElementsByClass("font_content");

		Element mainTable = totalTables.get(8); // school list
		Element tableBody = mainTable.getElementsByTag("tbody").get(0);
		Elements schools = tableBody.getElementsByTag("td");
		int cnt = 0;

		Pattern pattern = Pattern.compile("[0-9]+");
		
		for (int index = 0; index < schools.size(); index++) {
			Element school = schools.get(index);
			String onClick = school.attr("onclick");
			Matcher matcher = pattern.matcher(onClick);
			if (onClick != null && matcher.find()) {
				String schoolName = school.text();
				String schoolId = matcher.group();
				if(schoolJpaRepository.findBySchoolId(schoolId) == null){
					try {
						schoolJpaRepository.save(pull(schoolName, schoolId));
					} catch (Exception e) {
						System.out.println("Failed to add " + schoolName + " " + cnt);
						System.out.println("Error : " + e.getMessage());
					}
					System.out.println("Added " + schoolName + " " + cnt);
				} else {
					System.out.println("Already exists " + schoolName + " " + cnt);
				}
				cnt++;
			}
		}

		//pull("ABERDEEN BAPTIST CHURCH PAK KWONG KINDERGARTEN", "6355");
	}
	
	private KGEntity pull(String schoolName, String schoolId) throws IOException {
		Document doc = Jsoup.connect("http://kgp2017.highlight.hk/edb/schoolinfo.php?schid=" + schoolId+ "&lang=en&district=&category=&voucher=&schoolname=").get();
		Elements totalTables = doc.getElementsByClass("font_content");

		Element mainTable = totalTables.get(8); // school address
		Element tableBody = mainTable.getElementsByTag("tbody").get(0);
		Elements tds = tableBody.getElementsByTag("td");		
		String address = tds.get(1).text();
		String tel = tds.get(5).text();
		String fax = tds.get(9).text();

		mainTable = totalTables.get(9); // school number
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");
		String schoolNo = tds.get(1).text();

		mainTable = totalTables.get(10); // location number
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");
		String locationNo = tds.get(1).text();

		mainTable = totalTables.get(13); // school information
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");
		String schoolCategory = tds.get(1).text();
		String studentCategory = tds.get(3).text();
		String nameOfSchoolSupervisor = tds.get(5).text();
		String nameOfSchoolPrincipal = tds.get(7).text();
		String schoolFoundingYear = tds.get(9).text();
		String totalNoOfPermittedAccommodationOfClassroomsInUse = tds.get(11).text();
		String numberOfRegisteredClassrooms = tds.get(13).text();
		String outdoorPlayground = tds.get(15).text();
		String indoorPlayground = tds.get(17).text();
		String musicRoom = tds.get(19).text();
		String otherSpecialRoomArea = tds.get(21).text();
		String totalNoOfPrincipalTeachingStaff = tds.get(23).text();
		String schoolWebsite = tds.get(25).text();
		// String qualityReviewResultAndReport = tds.get(27).text();

		mainTable  = totalTables.get(15); // Academic Qualification
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");
		String degreeHolders = tds.get(2).text();
		String nonDegreeHolders = tds.get(4).text();
		String CECEorAbove = tds.get(7).text();
		String qualifiedKGTeachers = tds.get(9).text();
		String otherTeacherTrainings = tds.get(11).text();
		String qualifiedAssistantKGTeachers = tds.get(13).text();
		String others = tds.get(15).text();

		mainTable = totalTables.get(18); // Teacher to Pupil Ratio
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");
		String teacherToPupilRatioInMorningSession = tds.get(1).text();
		String teacherToPupilRatioInAfternoonSession = tds.get(3).text();
		String ratioIncludesClassesAged2_3 = tds.get(5).text();

		KGEntity schoolEntity = new KGEntity();
		schoolEntity.setSchoolName(schoolName);
		schoolEntity.setSchoolId(schoolId);
		schoolEntity.setAddress(address);
		schoolEntity.setTel(tel);
		schoolEntity.setFax(fax);
		schoolEntity.setSchoolNo(schoolNo);
		schoolEntity.setLocationNo(locationNo);
		schoolEntity.setSchoolCategory(schoolCategory);
		schoolEntity.setNameofSchoolSupervisor(nameOfSchoolSupervisor);
		schoolEntity.setNameofSchoolPrincipal(nameOfSchoolPrincipal);
		schoolEntity.setSchoolFoundingyear(schoolFoundingYear);
		schoolEntity.setTotalNoOfPermitteAccommodationOfClassroomsinuse(totalNoOfPermittedAccommodationOfClassroomsInUse);
		schoolEntity.setNumberOfRegisteredClassrooms(numberOfRegisteredClassrooms);
		schoolEntity.setOutDoorPlayground(outdoorPlayground);
		schoolEntity.setIndoorPlayground(indoorPlayground);
		schoolEntity.setMusicRoom(musicRoom);
		schoolEntity.setOtherSpecialRoom(otherSpecialRoomArea);
		schoolEntity.setTotalNoOfPrincipalTeachingStaff(totalNoOfPrincipalTeachingStaff);
		schoolEntity.setSchoolWebsite(schoolWebsite);
		schoolEntity.setDegreeHolders(degreeHolders);;
		schoolEntity.setNonDegreeHolders(nonDegreeHolders);
		schoolEntity.setCeceorabove(CECEorAbove);
		schoolEntity.setQualifiedAssistantKgTeachers(qualifiedKGTeachers);
		schoolEntity.setOtherTeacherTrainings(otherTeacherTrainings);
		schoolEntity.setQualifiedAssistantKgTeachers(qualifiedAssistantKGTeachers);
		schoolEntity.setOthers(others);
		schoolEntity.setTeacherToPupilratioInMorningSession(teacherToPupilRatioInMorningSession);
		schoolEntity.setTeacherToPupilratioInAfternoonSession(teacherToPupilRatioInAfternoonSession);
		schoolEntity.setRatioIncludesClassesaged23(ratioIncludesClassesAged2_3);
		return schoolEntity;
	}

	public KGJpaRepository getSchoolJpaRepository() {
		return schoolJpaRepository;
	}

	public void setSchoolJpaRepository(KGJpaRepository schoolJpaRepository) {
		this.schoolJpaRepository = schoolJpaRepository;
	}

}
