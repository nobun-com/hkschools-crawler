package com.hkschool.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hkschool.models.KGEntity;
import com.hkschool.repository.KGJpaRepository;

@Component
public class KGService {

	@Value("${crawler.pull.useragent}")
	private String userAgent = "";
	
	@Value("${crawler.pull.timeout}")
	private int timeout = 0;
	
	@Resource
	private KGJpaRepository schoolJpaRepository;

	int cnt = 0;

	public void pull() throws IOException {
		
		// below districts are pulled from view-source:http://kgp2017.highlight.hk/edb/school.php
		Map<String, String> districts = new HashMap<String, String>();
		districts.put("central", "中西區");
		districts.put("hkeast", "港島東區");
		districts.put("islands", "離島區");
		districts.put("southern", "南區");
		districts.put("wanchai", "灣仔區");
		districts.put("kwaichung", "葵青區");
		districts.put("tsuenwan", "荃灣區");
		districts.put("tuenmun", "屯門區");
		districts.put("yuenlong", "元朗區");
		districts.put("north", "北區");
		districts.put("shatin", "沙田區");
		districts.put("taipo", "大埔區");
		districts.put("kowlooncity", "九龍城區");
		districts.put("kwuntong", "觀塘區");
		districts.put("saikung", "西貢區");
		districts.put("shamshuipo", "深水埗區");
		districts.put("wongtaisin", "黃大仙區");
		districts.put("yautsimmongkok", "油尖旺區");
		for (String district : districts.keySet()) {
			try {
				pull(district, districts.get(district));
			} catch (Exception e) {
				System.out.println("Failed to pull kindergartens from district " + districts.get(district) + " need to re-run crawler");
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		System.out.println("**********************************");
		System.out.println(cnt + " kindergarten need to pull again");
		System.out.println("**********************************");
	}

	public void pull(String district, String displayTextDistrict) throws IOException {
		String crawlUrl = "http://kgp2017.highlight.hk/edb/school.php?lang=tc&district="+district;
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		Elements totalTables = doc.getElementsByClass("font_content");

		Element mainTable = totalTables.get(8); // school list
		Element tableBody = mainTable.getElementsByTag("tbody").get(0);
		Elements schools = tableBody.getElementsByTag("td");

		Pattern pattern = Pattern.compile("[0-9]+");

		for (int index = 0; index < schools.size(); index++) {
			Element school = schools.get(index);
			String onClick = school.attr("onclick");
			Matcher matcher = pattern.matcher(onClick);
			if (onClick != null && matcher.find()) {
				String schoolName = school.text();
				String schoolId = matcher.group();
				if(schoolName.isEmpty()) {
					continue;
				}
				KGEntity kgEntity = schoolJpaRepository.findBySchoolId(schoolId);
				if (kgEntity == null) {
					try {
						schoolJpaRepository.save(pull(displayTextDistrict, schoolName, schoolId));
						System.out.println("KG Added " + schoolName + " to " + district);
						Thread.sleep(timeout);
					} catch (Exception e) {
						cnt++;
						System.out.println("Failed to add KG " + schoolName + " failed count : " + cnt);
						System.out.println("Error : " + e.getMessage());
						e.printStackTrace();
					}
				} else {
					System.out.println("KG Already exists " + schoolName);
				}
			}
		}
	}

	// pull("ABERDEEN BAPTIST CHURCH PAK KWONG KINDERGARTEN", "6355");

	private KGEntity pull(String district, String schoolName, String schoolId) throws IOException {
		String crawlUrl = "http://kgp2017.highlight.hk/edb/schoolinfo.php?schid=" + schoolId + "&lang=tc&district=&category=&voucher=&schoolname=";
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		Elements totalTables = doc.getElementsByClass("font_content");

		Element mainTable = totalTables.get(8); // school address
		Element tableBody = mainTable.getElementsByTag("tbody").get(0);
		Elements tds = tableBody.getElementsByTag("td");
		String address = tds.get(1).text();
		String tel = tds.get(5).text();
		String fax = tds.get(9).text();

		mainTable = totalTables.get(34); // Other Approved Fees
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String Applicationfee = tds.get(2).text();
		String registrationsHalfApplicationfee = tds.get(5).text();
		String registrationfeeWholeApplicationfee = tds.get(7).text();

		mainTable = totalTables.get(28); // School Characteristics
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String Schoolvisionandmission = tds.get(2).text();
		String Supporttostudents = tds.get(4).text();
		String Parent_teacherassociation = tds.get(6).text();
		String Otheractivities_communicationwithparents = tds.get(8).text();

		mainTable = totalTables.get(33); // Admission Application
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String Applicationformdownload = tds.get(2).text();
		String Applicationperiod = tds.get(4).text();

		mainTable = totalTables.get(29); // Major Paid Items Reference Price
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String Summeruniform = tds.get(2).text();
		String Winteruniform = tds.get(4).text();
		String Schoolbag = tds.get(6).text();
		String Teaandsnacks = tds.get(8).text();
		String Textbooks = tds.get(10).text();
		String Exercisebooks_workbooks = tds.get(12).text();

		mainTable = totalTables.get(27); // ciruculum
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String CurriculumDetails = tds.get(0).text();
		String Curriculumtype = tds.get(2).text();
		String Curriculumplanning = tds.get(4).text();
		String Learning_Teachingapproachandactivities = tds.get(6).text();
		String Assessmentofchildrenslearningexperiences = tds.get(8).text();

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
		String schoolWebsite = tds.get(25).text();

		mainTable = totalTables.get(15); // Academic Qualification
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

		mainTable = totalTables.get(20); // No of enrollment
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");
		
		int scale = 0;
		String time = "";
		String nurseryAMSession = tds.get(6).text();
		String lowerKGAMSession = tds.get(7).text();
		String upperKGAMSession = tds.get(8).text();
		String totalAMSession = tds.get(9).text();
		String nurseryPMSession = tds.get(11).text();
		String lowerKGPMSession = tds.get(12).text();
		String upperKGPMSession = tds.get(13).text();
		String totalPMSession = tds.get(14).text();
		String nurseryWDSession = tds.get(16).text();
		String lowerKGWDSession = tds.get(17).text();
		String upperKGWDSession = tds.get(18).text();
		String totalWDSession = tds.get(19).text();
		
		if(! "0".equals(totalAMSession)) {
			time = time + "AM ";
		}
		if(! "0".equals(totalPMSession)) {
			time = time + "PM ";
		}
		if(! "0".equals(totalWDSession)) {
			time = time + "WD";
		}
		
		try {
			if(! "0".equals(totalAMSession)) {
				scale = scale + Integer.parseInt(totalAMSession);
			}
			if(! "0".equals(totalPMSession)) {
				scale = scale + Integer.parseInt(totalPMSession);
			}
			if(! "0".equals(totalWDSession)) {
				scale = scale + Integer.parseInt(totalWDSession);
			}
		} catch (Exception e) {
		}

		mainTable = totalTables.get(22); // Schoolfees
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String nurseryAMSessionfees = tds.get(7).text();
		String lowerKGAMSessionfees = tds.get(8).text();
		String upperKGAMSessionfees = tds.get(9).text();
		String nurseryPMSessionfess = tds.get(11).text();
		String lowerKGPMSessionfees = tds.get(12).text();
		String upperKGPMSessionfees = tds.get(13).text();
		String nurseryWDSessionfees = tds.get(15).text();
		String lowerKGWDSessionfees = tds.get(16).text();
		String upperKGWDSessionfees = tds.get(17).text();

		mainTable = totalTables.get(25); // fees
		tableBody = mainTable.getElementsByTag("tbody").get(0);
		tds = tableBody.getElementsByTag("td");

		String WithChildCareServicesForChildrenAged2_3 = tds.get(1).text();
		String FeeLevelHalf_dayperannum = tds.get(5).text();
		String Feelevelfull_dayperannum = tds.get(6).text();
		String Withchildcareservicesforchildrenagedunder2 = tds.get(8).text();
		String Noofenrolmentaged2_3 = tds.get(10).text();
		String JoiningChildCareCentreSubsidyScheme = tds.get(12).text();
		String Providingoccasionalchildcareservices = tds.get(14).text();
		String Providingextendedhoursservices = tds.get(15).text();

		KGEntity schoolEntity = new KGEntity();
		
		schoolEntity.setDistrict(district);
		schoolEntity.setScale(scale);
		schoolEntity.setTime(time);
		schoolEntity.setWithchildcareservicesforchildrenagedunder2(WithChildCareServicesForChildrenAged2_3);
		schoolEntity.setFeelevelhalfday(FeeLevelHalf_dayperannum);
		schoolEntity.setFeelevelfullday(Feelevelfull_dayperannum);
		schoolEntity.setWithchildcareservicesforchildrenagedunder2(Withchildcareservicesforchildrenagedunder2);
		schoolEntity.setNoofenrolmentaged2_3(Noofenrolmentaged2_3);
		schoolEntity.setJoiningChildCareCentreSubsidyScheme(JoiningChildCareCentreSubsidyScheme);
		schoolEntity.setProvidingoccasionalchildcareservices(Providingoccasionalchildcareservices);
		schoolEntity.setProvidingextendedhoursservices(Providingextendedhoursservices);

		schoolEntity.setNurseryAMSessionfees(nurseryAMSessionfees);
		schoolEntity.setLowerKGAMSessionfees(lowerKGAMSessionfees);
		schoolEntity.setUpperKGAMSessionfees(upperKGAMSessionfees);
		schoolEntity.setNurseryPMSessionfees(nurseryPMSessionfess);
		schoolEntity.setLowerKGPMSessionfees(lowerKGPMSessionfees);
		schoolEntity.setUpperKGPMSessionfees(upperKGPMSessionfees);
		schoolEntity.setNurseryWDSessionfees(nurseryWDSessionfees);
		schoolEntity.setLowerKGWDSessionfees(lowerKGWDSessionfees);
		schoolEntity.setUpperKGWDSessionfees(upperKGWDSessionfees);

		schoolEntity.setNurseryAMSession(nurseryAMSession);
		schoolEntity.setLowerKGAMSession(lowerKGAMSession);
		schoolEntity.setUpperKGAMSession(upperKGAMSession);
		schoolEntity.setTotalAMSession(totalAMSession);
		schoolEntity.setNurseryPMSession(nurseryPMSession);
		schoolEntity.setLowerKGPMSession(lowerKGPMSession);
		schoolEntity.setUpperKGPMSession(upperKGPMSession);
		schoolEntity.setTotalPMSession(totalPMSession);
		schoolEntity.setNurseryWDSession(nurseryWDSession);
		schoolEntity.setLowerKGWDSession(lowerKGWDSession);
		schoolEntity.setUpperKGWDSession(upperKGWDSession);
		schoolEntity.setTotalWDSession(totalWDSession);

		schoolEntity.setSchoolName(schoolName);
		schoolEntity.setSchoolId(schoolId);
		schoolEntity.setSource("Goverment");
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
		schoolEntity.setSchoolWebsite(schoolWebsite);
		schoolEntity.setStudentCategory(studentCategory);
		schoolEntity.setDegreeHolders(degreeHolders);
		schoolEntity.setNonDegreeHolders(nonDegreeHolders);
		schoolEntity.setCeceorabove(CECEorAbove);
		schoolEntity.setQualifiedAssistantKgTeachers(qualifiedKGTeachers);
		schoolEntity.setOtherTeacherTrainings(otherTeacherTrainings);
		schoolEntity.setQualifiedAssistantKgTeachers(qualifiedAssistantKGTeachers);
		schoolEntity.setOthers(others);
		schoolEntity.setTeacherToPupilratioInMorningSession(teacherToPupilRatioInMorningSession);
		schoolEntity.setTeacherToPupilratioInAfternoonSession(teacherToPupilRatioInAfternoonSession);
		schoolEntity.setRatioIncludesClassesaged23(ratioIncludesClassesAged2_3);

		schoolEntity.setCurriculumDetails(CurriculumDetails);
		schoolEntity.setCurriculumtype(Curriculumtype);
		schoolEntity.setCurriculumplanning(Curriculumplanning);
		schoolEntity.setLearningTeachingapproachandactivities(Learning_Teachingapproachandactivities);
		schoolEntity.setAssessmentofchildrenslearningexperiences(Assessmentofchildrenslearningexperiences);

		schoolEntity.setSummerUniform(Summeruniform);
		schoolEntity.setWinterUniform(Winteruniform);
		schoolEntity.setSchoolBag(Schoolbag);
		schoolEntity.setTeaAndSnacks(Teaandsnacks);
		schoolEntity.setTextBoo0ks(Textbooks);
		schoolEntity.setExerciseBook_workbooks(Exercisebooks_workbooks);

		schoolEntity.setApplicationFormDownload(Applicationformdownload);
		schoolEntity.setApplicationPeriod(Applicationperiod);

		schoolEntity.setSchoolVisionAndMission(Schoolvisionandmission);
		schoolEntity.setSchoolDiscription(Schoolvisionandmission);
		schoolEntity.setSupportToStudents(Supporttostudents);
		schoolEntity.setParent_Teacherassociation(Parent_teacherassociation);
		schoolEntity.setOtherActivities_communicationWithParents(Otheractivities_communicationwithparents);

		schoolEntity.setApplicationFee(Applicationfee);
		schoolEntity.setRegistrationFeeHalf_Daysession(registrationsHalfApplicationfee);
		schoolEntity.setRegistrationFeeWhole_Daysession(registrationfeeWholeApplicationfee);
		schoolEntity.setCreatedOn(new Date());		

		return schoolEntity;
	}

	public KGJpaRepository getSchoolJpaRepository() {
		return schoolJpaRepository;
	}

	public void setSchoolJpaRepository(KGJpaRepository schoolJpaRepository) {
		this.schoolJpaRepository = schoolJpaRepository;
	}

}
