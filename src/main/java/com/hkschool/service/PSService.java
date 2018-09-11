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

import com.hkschool.models.PSEntity;
import com.hkschool.repository.PSJpaRepository;

@Component
public class PSService {

	@Value("${crawler.pull.useragent}")
	private String userAgent = "";
	
	@Value("${crawler.pull.timeout}")
	private int timeout = 0;
	
	@Resource
	private PSJpaRepository pSchoolJpaRepository;

	int cnt = 0;
	
	public void pull() throws IOException {
		
		// below district ids are pulled from https://www.chsc.hk/psp2018/sch_list.php?lang_id=2&frmMode=pagebreak&district_id=1
		Map<String, String> districts = new HashMap<String, String>();
		districts.put("1", "中西區");
		districts.put("2", "香港東區");
		districts.put("3", "離島區");
		districts.put("4", "香港南區");
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
				System.out.println("Failed to pull primary schools from district " + districts.get(districtId) + " need to re-run crawler");
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("**********************************");
		System.out.println(cnt + " primery schools need to pull again");
		System.out.println("**********************************");
	}
	
	public void pull(String districtId, String district) throws IOException {
		String crawlUrl = "https://www.chsc.hk/psp2018/sch_list.php?lang_id=2&frmMode=pagebreak&district_id="+districtId;
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		Elements totalTables = doc.getElementsByTag("table");

		Element mainTable = totalTables.get(1); // school list
		Elements schools = mainTable.getElementsByTag("td");
		Pattern pattern = Pattern.compile("sch_detail.php\\?.*sch_id=([0-9]+)");
		
		for (int index = 2; index < schools.size(); index+=15) {
			Element school = schools.get(index);
			Elements anchors = school.getElementsByTag("a");
			if (anchors == null || anchors.size() == 0) {
				continue;
			}
			Element link = anchors.get(0);

			String url = link.attr("href");
			Matcher matcher = pattern.matcher(url);
			if (url != null && matcher.find()) {
				String schoolName = link.toString().replaceAll(".*<br>|</a>", "");
				String schoolId = matcher.group(1);
				if(schoolName.isEmpty()) {
					continue;
				}
				PSEntity psEntity = pSchoolJpaRepository.findBySchoolId(schoolId);
				if(psEntity == null){
					try {
						pSchoolJpaRepository.save(pull(district, schoolName, schoolId));
						System.out.println("PS Added " + schoolName + " to " + district);
						Thread.sleep(timeout);
					} catch (Exception e) {
						cnt++;
						System.out.println("Failed to add PS " + schoolName + " failed count : " + cnt);
						System.out.println("Error : " + e.getMessage());
						e.printStackTrace();
					}
				} else {
					System.out.println("PS Already exists " + schoolName);
				}
			}
		}

	}
	
	private PSEntity pull(String district, String schoolName, String schoolId) throws IOException {
		String crawlUrl = "https://www.chsc.hk/psp2018/sch_detail.php?lang_id=2&sch_id=" + schoolId;
		System.out.println("Crawling: " + crawlUrl);
		
		Document doc = Jsoup.connect(crawlUrl).userAgent(userAgent).get();
		
		String schoolNetwork = "0";
		try{
			Element schoolNetworkEle = doc.getElementsByClass("xxzl-info-bh").get(0);
			schoolNetwork = schoolNetworkEle.text().split("校網編號 : ")[1];
		} catch(Exception e) {}
		
		Elements totalTables = doc.getElementsByTag("table");
		
		Element mainTable = totalTables.get(0); // school address
		Elements tds = mainTable.getElementsByTag("td");
		String address = tds.get(1).text();
		String phone = tds.get(3).text();
		String email = tds.get(6).text();
		String fax = tds.get(8).text();
		String website = tds.get(11).text();
		
		mainTable = totalTables.get(10);//School Characteristics
		tds = mainTable.getElementsByTag("td");
		
		String SchoolManagementOrganisation = tds.get(3).text();
		String IncorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee = tds.get(6).text();
		String SchoolGreenPolicy = tds.get(9).text();
		String SchoolsMajorConcerns = tds.get(12).text();
		String LearningAndTeachingStrategies = tds.get(16).text();
		String DevelopmentofKeyTasks = tds.get(19).text();
		String DevelopmentofGenericSkills = tds.get(22).text();
		String WholeSchoolApproachtoCaterforStudentDiversity = tds.get(26).text();
		String CurriculumTailoringandAdaptation = tds.get(29).text();
		String Home_SchoolCooperation = tds.get(33).text();
		String SchoolEthos = tds.get(36).text();
		String SchoolDevelopmentPlan = tds.get(40).text();
		String TeacherProfessionalTrainingAndDevelopment = tds.get(43).text();
		String FeeRemissionScheme = tds.get(46).text();
		String Others = tds.get(49).text();
		
		mainTable = totalTables.get(7);//School Life
		tds = mainTable.getElementsByTag("td");
		
		String time = "";
		String NumberofSchoolDaysperweek = tds.get(2).text();
		String Numberofperiodsperday = tds.get(5).text();
		String Durationofeachnormalperiod = tds.get(8).text();
		String Schoolstartsat = tds.get(11).text();
		String Schoolendsat = tds.get(14).text();
		String Lunchtime = tds.get(17).text();
		String Luncharrangement = tds.get(20).text();
		String Healthyschoollife = tds.get(23).text();
		String Remarks = tds.get(26).text();
		if(! "0".equals(Schoolstartsat)) {
			time = time + "AM ";
		}
		if(! "0".equals(Schoolendsat)) {
			time = time + "PM ";
		}
		
		mainTable = totalTables.get(6);//Performance Assessment
		tds = mainTable.getElementsByTag("td");
		
		String NumberofTestperyear = tds.get(2).text();
		String NumberofExamperyear = tds.get(5).text();
		String Streamingarrangement = tds.get(8).text();
		String DiversifiedAssessmentforLearning = tds.get(11).text();
		
		mainTable = totalTables.get(1); // school address
		tds = mainTable.getElementsByTag("td");
		
		String supervisorChairmanofManagementCommittee = tds.get(2).text();
		String schoolHead = tds.get(5).text();
		String hastheIncorporatedManagementCommitteebeenestablished = tds.get(8).text();
		String schoolType = tds.get(11).text();
		String studentGender = tds.get(14).text();
		String sponsoringBody = tds.get(17).text();
		String religion = tds.get(20).text();
		String yearofCommencementofOperation = tds.get(23).text();
		String schoolMotto = tds.get(26).text();
		String schoolSize = tds.get(29).text();
		String throughTrainSecondarySchool = tds.get(32).text();
		String feederSecondarySchool = tds.get(35).text();
		String nominatedSecondarySchool = tds.get(38).text();
		String mediumofInstruction = tds.get(41).text();
		String schoolBusService = tds.get(44).text();
		String parentTeacherAssociation = tds.get(47).text();
		String schoolAlumniAssociation = tds.get(50).text();

		mainTable = totalTables.get(2);//Fees
		tds = mainTable.getElementsByTag("td");
	
		String schoolFee = tds.get(2).text();
		String tongFai = tds.get(5).text();
		String PTAFee = tds.get(8).text();
		String approvedChargesforSpecificPurposes = tds.get(11).text();
		String otherCharges = tds.get(14).text();
		
		mainTable = totalTables.get(3);//Class structure
		tds = mainTable.getElementsByTag("td");

		String numberOfClassroom = tds.get(2).text();
		String numberOfSchoolHall = tds.get(5).text();
		String numberOfPlayground = tds.get(8).text();
		String numberOfLibrary = tds.get(11).text();
		String specialRooms = tds.get(14).text();
		String facilitySupportforStudentswithSpecialEducationalNeeds = tds.get(17).text();
		String others = tds.get(20).text();

		mainTable = totalTables.get(4);//teacher
		tds = mainTable.getElementsByTag("td");

		String numberOfteachersintheapprovedestablishment = tds.get(2).text();
		String totalnumberOfteachersintheschool = tds.get(5).text();
		String teacherCertificateDiplomainEducation = tds.get(9).text();
		String bachelorDegree = tds.get(12).text();
		String masterDoctorateDegreeorabove = tds.get(15).text();
		String specialEducationTraining = tds.get(18).text();
		String workExperience0_4years = tds.get(22).text();
		String workExperience5_9years = tds.get(25).text();
		String workExperience10yearsorabove = tds.get(28).text();
	
		PSEntity schoolEntity = new PSEntity();
		
		schoolEntity.setSchoolName(schoolName);
		schoolEntity.setSchoolId(schoolId);
		schoolEntity.setSchoolNetwork(schoolNetwork);
		
		schoolEntity.setSource("Goverment");
		schoolEntity.setAddress(address);
		schoolEntity.setDistrict(district);
		schoolEntity.setTel(phone);
		schoolEntity.setSchoolEmail(email);
		schoolEntity.setFax(fax);
		schoolEntity.setSchoolWebsite(website);
		schoolEntity.setNumberOfClassroom(numberOfClassroom);
		
		schoolEntity.setSupervisorChairmanofManagementCommittee(supervisorChairmanofManagementCommittee);
		schoolEntity.setNameofSchoolPrincipal(schoolHead);
		schoolEntity.setHastheIncorporatedmanagementcommitteebeenestablished(hastheIncorporatedManagementCommitteebeenestablished);
		schoolEntity.setSchoolCategory(schoolType);
		schoolEntity.setStudentGender(studentGender);
		schoolEntity.setSponsoringBody(sponsoringBody);
		schoolEntity.setReligion(religion);
		schoolEntity.setYearofCommencementofOperation(yearofCommencementofOperation);
		schoolEntity.setSchoolMotto(schoolMotto);
		schoolEntity.setSchoolSize(schoolSize);
		schoolEntity.setThroughTrainSecondarySchool(throughTrainSecondarySchool);
		schoolEntity.setFeederSecondarySchool(feederSecondarySchool);
		schoolEntity.setNominatedSecondarySchool(nominatedSecondarySchool);
		schoolEntity.setMediumOfInstruction(mediumofInstruction);
		schoolEntity.setSchoolBusService(schoolBusService);
		schoolEntity.setParentTeacherAssociation(parentTeacherAssociation);
		schoolEntity.setSchoolAlumniAssociation(schoolAlumniAssociation);
		schoolEntity.setFacilitySupportforStudentswithSpecialEducationalNeeds(facilitySupportforStudentswithSpecialEducationalNeeds);
		schoolEntity.setTime(time);
		
		schoolEntity.setSchoolFee(schoolFee);
		schoolEntity.setTongfai(tongFai);
		schoolEntity.setSchoolFee(PTAFee);
		schoolEntity.setApprovedChargesforspecificpurposes(approvedChargesforSpecificPurposes);
		schoolEntity.setOtherCharges(otherCharges);

		schoolEntity.setNumberOfSchoolHall(numberOfSchoolHall);
		schoolEntity.setIndoorPlayground(numberOfPlayground);
		schoolEntity.setNumberOfLibrary(numberOfLibrary);
		schoolEntity.setTotalNoOfPermitteAccommodationOfClassroomsinuse(specialRooms);
		schoolEntity.setOthers(others);

		schoolEntity.setNumberofTeachersIntHeapprovedEstablishment(numberOfteachersintheapprovedestablishment);
		schoolEntity.setTotalnumberOfteachersintheschool(totalnumberOfteachersintheschool);
		schoolEntity.setTeacherCertificateDiplomaInEducation(teacherCertificateDiplomainEducation);
		schoolEntity.setBachelorDegree(bachelorDegree);
		schoolEntity.setMasterDoctorateDegreeOrAbove(masterDoctorateDegreeorabove);
		schoolEntity.setSpecialEducationTraining(specialEducationTraining);
		schoolEntity.setWorkExperience0_4Years(workExperience0_4years);
		schoolEntity.setWorkExperience5_9Years(workExperience5_9years);
		schoolEntity.setWorkExperience10YearsoOrAbove(workExperience10yearsorabove);
		
		schoolEntity.setSchoolManagementOrganisation(SchoolManagementOrganisation);
		schoolEntity.setIncorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee(IncorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee);
		schoolEntity.setSchoolGreenPolicy(SchoolGreenPolicy);
		schoolEntity.setSchoolsMajorConcerns(SchoolsMajorConcerns);
		schoolEntity.setLearningAndTeachingStrategies(LearningAndTeachingStrategies);
		schoolEntity.setDevelopmentofKeyTasks(DevelopmentofKeyTasks);
		schoolEntity.setDevelopmentofGenericSkills(DevelopmentofGenericSkills);
		schoolEntity.setWholeSchoolApproachtoCaterforStudentDiversity(WholeSchoolApproachtoCaterforStudentDiversity);
		schoolEntity.setCurriculumTailoringandAdaptation(CurriculumTailoringandAdaptation);
		schoolEntity.setHome_SchoolCo_operation(Home_SchoolCooperation);
		schoolEntity.setSchoolEthos(SchoolEthos);
		schoolEntity.setSchoolDevelopmentPlan(SchoolDevelopmentPlan);
		schoolEntity.setTeacherProfessionalTrainingAndDevelopment(TeacherProfessionalTrainingAndDevelopment);
		schoolEntity.setFeeRemissionScheme(FeeRemissionScheme);
		schoolEntity.setOthers(Others);
		schoolEntity.setNumberofSchoolDaysperweek(NumberofSchoolDaysperweek);
		schoolEntity.setNumberofperiodsperday(Numberofperiodsperday);
		schoolEntity.setDurationofeachnormalperiod(Durationofeachnormalperiod);
		schoolEntity.setSchoolstartsat(Schoolstartsat);
		schoolEntity.setSchoolendsat(Schoolendsat);
		schoolEntity.setLunchtime(Lunchtime);
		schoolEntity.setLuncharrangement(Luncharrangement);
		schoolEntity.setHealthyschoollife(Healthyschoollife);
		schoolEntity.setRemarks(Remarks);
		schoolEntity.setNumberOfTestPerYear(NumberofTestperyear); 
		schoolEntity.setNumberOfExamPerYear(NumberofExamperyear); 
		schoolEntity.setStreamingArrangement(Streamingarrangement);   
		schoolEntity.setDiversifiedAssessmentForLearning(DiversifiedAssessmentforLearning);
		schoolEntity.setCreatedOn(new Date());

		return schoolEntity;
	}

}
	

