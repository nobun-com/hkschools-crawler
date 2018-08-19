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

import com.hkschool.models.SSEntity;
import com.hkschool.repository.SSJpaRepository;

@Component
public class SSService {

	@Value("${crawler.pull.useragent}")
	private String userAgent = "";
	
	@Value("${crawler.pull.timeout}")
	private int timeout = 0;
	
	@Resource
	private SSJpaRepository sSchoolJpaRepository;

	int cnt = 0;

	public void pull() throws IOException {

		// below district ids are pulled from https://www.chsc.hk/ssp2017/sch_list.php?lang_id=2&frmMode=pagebreak&district_id=1
		Map<String, String> districts = new HashMap<String, String>();
		districts.put("1", "中西區");
		districts.put("2", "港島東區");
		districts.put("3", "離島區");
		districts.put("4", "南區");
		districts.put("5", "灣仔區");
		districts.put("6", "九龍城區");
		districts.put("7", "觀塘區");
		districts.put("8", "西貢區");
		districts.put("9", "深水埗區");
		districts.put("10", "黃大仙區");
		districts.put("11", "油尖旺區");
		districts.put("12", "北區");
		districts.put("13", "沙田區");
		districts.put("14", "大埔區");
		districts.put("15", "葵青區");
		districts.put("16", "荃灣區");
		districts.put("17", "屯門區");
		districts.put("18", "元朗區");
		for (String districtId : districts.keySet()) {
			try {
				pull(districtId, districts.get(districtId));
			} catch (Exception e) {
				System.out.println("Failed to pull secondary schools from district " + districts.get(districtId) + " need to re-run crawler");
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("**********************************");
		System.out.println(cnt + " secondary schools need to pull again");
		System.out.println("**********************************");
	}

	public void pull(String districtId, String district) throws IOException {
		String crawlUrl = "https://www.chsc.hk/ssp2017/sch_list.php?lang_id=2&frmMode=pagebreak&district_id=" + districtId;
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		Elements totalTables = doc.getElementsByTag("table");

		Element mainTable = totalTables.get(0); // school list
		Elements schools = mainTable.getElementsByTag("tr");
	
		Pattern pattern = Pattern.compile("sch_detail.php\\?.*sch_id=([0-9]+)");

		for (int index = 2; index < schools.size(); index++) {
			try{
				Element school = schools.get(index);
				Element link = school.getElementsByTag("a").get(0);

				String url = link.attr("href");
				Matcher matcher = pattern.matcher(url);
				if (url != null && matcher.find()) {
					String schoolName = link.toString().replaceAll(".*<br>|</a>", "");
					String schoolId = matcher.group(1);
					if(schoolName.isEmpty()) {
						continue;
					}
					SSEntity sSEntity = sSchoolJpaRepository.findBySchoolId(schoolId);
					if (sSEntity == null) {
						try {
							sSchoolJpaRepository.save(pull(district, schoolName, schoolId));
							System.out.println("SS Added " + schoolName);
							Thread.sleep(timeout);
						} catch (Exception e) {
							cnt++;
							System.out.println("Failed to add SS " + schoolName + " failed count : " + cnt);
							System.out.println("Error : " + e.getMessage());
							e.printStackTrace();
						}
					} else {
						System.out.println("SS Already exists " + schoolName);
					}
				}
			} catch(Exception e) { }
		}

	}

	private SSEntity pull(String district, String schoolName, String schoolId) throws IOException {
		String crawlUrl = "https://www.chsc.hk/ssp2017/sch_detail.php?lang_id=2&sch_id="+ schoolId;
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		Elements totalTables = doc.getElementsByTag("table");

		Element mainTable = totalTables.get(0); // school address
		Elements tds = mainTable.getElementsByTag("td");
		String address = tds.get(1).text();
		String phone = tds.get(3).text();
		String email = tds.get(6).text();
		String fax = tds.get(8).text();
		String website = tds.get(11).text();
		
		
		mainTable = totalTables.get(8);// School Char
		tds = mainTable.getElementsByTag("td");

		String SchoolsKeyConcerns = tds.get(2).text();
		//String SchoolManagementOrganisation = tds.get(8).text();
		//String IncorporatedManagementCommittee_SchoolManagement = tds.get(11).text();
		//String SchoolGreenPolicy = tds.get(14).text();
		//String Whole_schoolLanguagePolicy = tds.get(20).text();
		//String LearningAndTeachingStrategies = tds.get(23).text();
		//String School_basedcurriculum = tds.get(26).text();
		//String CareerandLifePlanning = tds.get(29).text();
		//String KeyLearningAreas = tds.get(32).text();
		//String WholeSchoolApproachtoCaterforStudentDiversity = tds.get(38).text();
		//String LearningandAssessment = tds.get(41).text();
		//String SchoolFeeRemission = tds.get(44).text();
		//String Home_SchoolCo_operation = tds.get(50).text();
		//String SchoolEthos = tds.get(53).text();
		//String SchoolDevelopmentPlan = tds.get(59).text();
		//String TeacherProfessionalTrainingAndDevelopment = tds.get(62).text();
		//String Extra_curricular_Co_curricularActivities = tds.get(65).text();
		String Others = tds.get(68).text();
		String DirectpublictransportationtoSchool = tds.get(71).text();
		String Remarks = tds.get(74).text();

		mainTable = totalTables.get(4); // Teacher info
		tds = mainTable.getElementsByTag("td");

		String Numberofteachingpostsintheapprovedestablishment = tds.get(2).text();
		String Totalnumberofteachersintheschool = tds.get(5).text();
		String QualificationsandProfessionalTraining = tds.get(8).text();
		String TeacherCertificate_DiplomainEducation = tds.get(11).text();
		String BachelorDegree = tds.get(14).text();
		String Master_DoctorateDegreeorabove = tds.get(17).text();
		String SpecialEducationTraining = tds.get(20).text();
		String WorkingExperiences = tds.get(23).text();
		String WorkingExperiences0_4years = tds.get(26).text();
		String WorkingExperiences5_9years = tds.get(29).text();
		String WorkingExperiences10yearsorabove = tds.get(32).text();

		mainTable = totalTables.get(6); // Subjects Offered
		tds = mainTable.getElementsByTag("td");

		String SubjectsOfferedin2017_2018SchoolYear = tds.get(2).text();
		//String Chineseasthemediumofinstruction = tds.get(5).text();
		//String Englishasthemediumofinstruction = tds.get(8).text();
		//String UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup = tds.get(11).text();
		//String SubjectsOfferedin2017_2018SchoolYear0 = tds.get(14).text();
		//String Chineseasthemediumofinstruction0 = tds.get(17).text();
		//String Englishasthemediumofinstruction0 = tds.get(20).text();
		//String UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup0 = tds.get(23).text();
		//String SubjectstobeOfferedin2018_2019SchoolYear = tds.get(26).text();
		//String Chineseasthemediumofinstruction1 = tds.get(29).text();
		//String Englishasthemediumofinstruction1 = tds.get(32).text();
		//String UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup1 = tds.get(35).text();
		//String SubjectstobeOferedin2018_2019SchoolYear1 = tds.get(38).text();
		//String Chineseasthemediumofinstruction2 = tds.get(41).text();
		//String Englishasthemediumofinstruction2 = tds.get(44).text();
		//String UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup2 = tds.get(47).text();

		mainTable = totalTables.get(7); // Secondary One Admission, Orientation
										// Activities & Healthy School Life
		tds = mainTable.getElementsByTag("td");

		//String SecondaryOneAdmission = tds.get(2).text();
		//String OrientationActivitiesandHealthyLife = tds.get(5).text();

		mainTable = totalTables.get(3); // SchoolFacilities
		tds = mainTable.getElementsByTag("td");

		String SchoolFacilities = tds.get(2).text();
		//String FacilityforSupportingStudentswithSpecialEducationalNeeds = tds.get(5).text();

		mainTable = totalTables.get(1); // School Info
		tds = mainTable.getElementsByTag("td");
		String OtherDistrict = tds.get(5).text();
		String Supervisor_ChairmanofSchoolManagementCommittee = tds.get(8).text();
		String Principal = tds.get(11).text();
		String SchoolType = tds.get(14).text();
		String StudentGender = tds.get(17).text();
		String SchoolSize = tds.get(20).text();
		String SponsoringBody = tds.get(23).text();
		String IncorporatedManagementCommittee = tds.get(26).text();
		String Religion = tds.get(29).text();
		String YearofCommencementofOperation = tds.get(32).text();
		String SchoolMotto = tds.get(35).text();
		String Parent_TeacherAssociation = tds.get(38).text();
		String StudentUnion_Association = tds.get(41).text();
		String PastStudentsAssociation_SchoolAlumniAssociation = tds.get(44).text();
		
		mainTable = totalTables.get(2);// Fees
		tds = mainTable.getElementsByTag("td");

		String SchoolFeeS1 = tds.get(5).text();
		String TongFaiS1 = tds.get(6).text();
		String SchoolFeeS2 = tds.get(9).text();
		String TongFaiS2 = tds.get(10).text();
		String SchoolFeeS3 = tds.get(13).text();
		String TongFaiS3 = tds.get(14).text();
		String SchoolFeeS4 = tds.get(17).text();
		String TongFaiS4 = tds.get(18).text();
		String SchoolFeeS5 = tds.get(21).text();
		String TongFaiS5 = tds.get(22).text();
		String SchoolFeeS6 = tds.get(25).text();
		String TongFaiS6 = tds.get(26).text();
		String Parent_TeacherAssociationFee = tds.get(29).text();
		String Incidentals = tds.get(32).text();
		String StudentsAssociationMembershipFee = tds.get(35).text();
		String ChargesforSpecificPurposes = tds.get(38).text();
		String OtherCharges = tds.get(42).text();

		SSEntity schoolEntity = new SSEntity();

		schoolEntity.setSchoolName(schoolName);
		schoolEntity.setSchoolId(schoolId);
		schoolEntity.setSource("Goverment");
		schoolEntity.setAddress(address);
		schoolEntity.setDistrict(district);
		schoolEntity.setTel(phone);
		schoolEntity.setSchoolEmail(email);
		schoolEntity.setFax(fax);
		schoolEntity.setSchoolWebsite(website);
		schoolEntity.setSchoolFeeS1(SchoolFeeS1);
		schoolEntity.setTongFaiS1(TongFaiS1);
		schoolEntity.setSchoolFeeS2(SchoolFeeS2);
		schoolEntity.setTongFaiS2(TongFaiS2);
		schoolEntity.setSchoolFeeS3(SchoolFeeS3);
		schoolEntity.setTongFaiS3(TongFaiS3);
		schoolEntity.setSchoolFeeS4(SchoolFeeS4);
		schoolEntity.setTongFaiS4(TongFaiS4);
		schoolEntity.setSchoolFeeS5(SchoolFeeS5);
		schoolEntity.setTongFaiS5(TongFaiS5);
		schoolEntity.setSchoolFeeS6(SchoolFeeS6);
		schoolEntity.setTongFaiS6(TongFaiS6);
		schoolEntity.setParent_TeacherAssociationFee(Parent_TeacherAssociationFee);
		schoolEntity.setIncidentals(Incidentals);
		schoolEntity.setStudentsAssociationMembershipFee(StudentsAssociationMembershipFee);
		schoolEntity.setChargesforSpecificPurposes(ChargesforSpecificPurposes);
		schoolEntity.setOtherCharges(OtherCharges);
		schoolEntity.setWorkingExperiences(WorkingExperiences);
		schoolEntity.setWorkingExperiences0_4years(WorkingExperiences0_4years);
		schoolEntity.setWorkingExperiences5_9years(WorkingExperiences5_9years);
		schoolEntity.setWorkingExperiences10yearsorabove(WorkingExperiences10yearsorabove);

		schoolEntity.setSchoolsKeyConcerns(SchoolsKeyConcerns);
		/*schoolEntity.setSchoolManagementOrganisation(SchoolManagementOrganisation);
		schoolEntity.setIncorporatedManagementCommittee_SchoolManagement(IncorporatedManagementCommittee_SchoolManagement);
		schoolEntity.setSchoolGreenPolicy(SchoolGreenPolicy);
		schoolEntity.setWhole_schoolLanguagePolicy(Whole_schoolLanguagePolicy);
		//schoolEntity.setLearningAndTeachingStrategies(LearningAndTeachingStrategies);
		schoolEntity.setSchool_basedcurriculum(School_basedcurriculum);
		schoolEntity.setCareerandLifePlanning(CareerandLifePlanning);
		schoolEntity.setKeyLearningAreas(KeyLearningAreas);
		schoolEntity.setWholeSchoolApproachtoCaterforStudentDiversity(WholeSchoolApproachtoCaterforStudentDiversity);
		schoolEntity.setLearningandAssessment(LearningandAssessment);
		schoolEntity.setSchoolFeeRemission(SchoolFeeRemission);
		schoolEntity.setHome_SchoolCo_operation(Home_SchoolCo_operation);
		schoolEntity.setSchoolEthos(SchoolEthos);
		schoolEntity.setSchoolDevelopmentPlan(SchoolDevelopmentPlan);
		schoolEntity.setTeacherProfessionalTrainingAndDevelopment(TeacherProfessionalTrainingAndDevelopment);
		schoolEntity.setExtra_curricular_Co_curricularActivities(Extra_curricular_Co_curricularActivities);*/
		schoolEntity.setOthers(Others);
		schoolEntity.setDirectpublictransportationtoSchool(DirectpublictransportationtoSchool);
		schoolEntity.setRemarks(Remarks);

		schoolEntity.setSubjectsOfferedin2017_2018SchoolYear(SubjectsOfferedin2017_2018SchoolYear);
		//schoolEntity.setChineseasthemediumofinstruction(Chineseasthemediumofinstruction);
		//schoolEntity.setEnglishasthemediumofinstruction(Englishasthemediumofinstruction);
		//schoolEntity.setChineseasthemediumofinstruction0(Chineseasthemediumofinstruction0);
		//schoolEntity.setEnglishasthemediumofinstruction0(Englishasthemediumofinstruction0);

		schoolEntity.setSchoolFacilities(SchoolFacilities);

		schoolEntity
				.setNumberofteachingpostsintheapprovedestablishment(Numberofteachingpostsintheapprovedestablishment);
		schoolEntity
				.setTotalnumberofteachersintheschool(Totalnumberofteachersintheschool);
/*		schoolEntity.setUsebygroup(UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup);
		schoolEntity.setSubjectsOfferedin2017_2018SchoolYear(SubjectsOfferedin2017_2018SchoolYear0);
		schoolEntity.setUsebygroup0(UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup0);
		schoolEntity.setSubjectstobeOfferedin2018_2019SchoolYear1(SubjectstobeOfferedin2018_2019SchoolYear);
		//schoolEntity.setChineseasthemediumofinstruction1(Chineseasthemediumofinstruction1);
		//schoolEntity.setEnglishasthemediumofinstruction1(Englishasthemediumofinstruction1);
		schoolEntity.setUsebygroup1(UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup1);
		schoolEntity.setSubjectstobeOfferedin2018_2019SchoolYear1(SubjectstobeOferedin2018_2019SchoolYear1);
		//schoolEntity.setChineseasthemediumofinstruction2(Chineseasthemediumofinstruction2);
		schoolEntity.setEnglishasthemediumofinstruction2(Englishasthemediumofinstruction2);
		schoolEntity.setUsebygroup2(UseeitherChineseorEnglishasthemediumofinstructionbyclassorbygroup2);
		
		schoolEntity.setSecondaryOneAdmission(SecondaryOneAdmission);
		schoolEntity.setOrientationActivitiesandHealthyLife(OrientationActivitiesandHealthyLife);
		schoolEntity.setFacilityforSupportingStudentswithSpecialEducationalNeeds(FacilityforSupportingStudentswithSpecialEducationalNeeds);*/
		schoolEntity.setQualificationsandProfessionalTraining(QualificationsandProfessionalTraining);
		schoolEntity.setTeacherCertificate_DiplomainEducation(TeacherCertificate_DiplomainEducation);
		schoolEntity.setBachelorDegree(BachelorDegree);
		schoolEntity.setMaster_DoctorateDegreeorabove(Master_DoctorateDegreeorabove);
		schoolEntity.setSpecialEducationTraining(SpecialEducationTraining);

		schoolEntity.setOtherDistrict(OtherDistrict);
		schoolEntity.setSupervisor_ChairmanofSchoolManagementCommittee(Supervisor_ChairmanofSchoolManagementCommittee);
		schoolEntity.setPrincipal(Principal);
		schoolEntity.setSchoolType(SchoolType);
		schoolEntity.setStudentGender(StudentGender);
		schoolEntity.setSchoolSize(SchoolSize);
		schoolEntity.setSponsoringBody(SponsoringBody);
		schoolEntity.setIncorporatedManagementCommittee(IncorporatedManagementCommittee);
		schoolEntity.setReligion(Religion);
		schoolEntity.setYearofCommencementofOperation(YearofCommencementofOperation);
		schoolEntity.setSchoolMotto(SchoolMotto);
		schoolEntity.setParent_TeacherAssociation(Parent_TeacherAssociation);
		schoolEntity.setStudentUnion_Association(StudentUnion_Association);
		schoolEntity.setPastStudentsAssociation_SchoolAlumniAssociation(PastStudentsAssociation_SchoolAlumniAssociation);
		schoolEntity.setCreatedOn(new Date());
		return schoolEntity;
	}

}
