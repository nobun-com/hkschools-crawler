package com.hkschool.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hkschool.models.SSEntity;
import com.hkschool.repository.SSJpaRepository;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Component
public class SSService {

	@Resource
	private SSJpaRepository pSchoolJpaRepository;

	public void pull() {
		String schoolTypes[] = {"Gov", "Aided", "Private", "DSS", "CAPUT"};
		for(String schoolType : schoolTypes) {
			try {
				pull(schoolType);
			} catch(Exception e) {
				
			}
		}
	}
	
	public void pull(String schoolType) throws IOException {
		Document doc = Jsoup.connect("http://www.chsc.hk/ssp2017/sch_list.php?lang_id=1&frmMode=pagebreak&district_id=0&sch_type=" + schoolType + "&sch_name=").get();
		//Document doc = Jsoup.connect("https://www.schooland.hk/kg/").get();
		Elements totalTables = doc.getElementsByTag("table");

		Element mainTable = totalTables.get(0); // school list
		Elements schools = mainTable.getElementsByTag("tr");
		int cnt = 0;

		Pattern pattern = Pattern.compile("sch_detail.php\\?.*sch_id=([0-9]+)");
		
		for (int index = 2; index < schools.size(); index++) {
			Element school = schools.get(index);
			Element link = school.getElementsByTag("a").get(0);

			String url = link.attr("href");
			Matcher matcher = pattern.matcher(url);
			if (url != null && matcher.find()) {
				String schoolName = link.text();
				String schoolId = matcher.group(1);
				if(pSchoolJpaRepository.findBySchoolId(schoolId) == null){
					try {
						pSchoolJpaRepository.save(pull(schoolName, schoolId));
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

	}
	
	private SSEntity pull(String schoolName, String schoolId) throws IOException {
		Document doc = Jsoup.connect("http://www.chsc.hk/psp2017/sch_detail.php?lang_id=1&sch_id=" + schoolId).get();
		Elements totalTables = doc.getElementsByTag("table");
		
		Element mainTable = totalTables.get(0); // school address
		Elements tds = mainTable.getElementsByTag("td");
		String address = tds.get(1).text();
		String phone = tds.get(3).text();
		String email = tds.get(6).text();
		String fax = tds.get(8).text();
		String website = tds.get(11).text();
		
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

		mainTable = totalTables.get(2);
		tds = mainTable.getElementsByTag("td");
	
		String schoolFee = tds.get(2).text();
		String tongFai = tds.get(5).text();
		String PTAFee = tds.get(8).text();
		String approvedChargesforSpecificPurposes = tds.get(11).text();
		String otherCharges = tds.get(14).text();
		
		mainTable = totalTables.get(3);
		tds = mainTable.getElementsByTag("td");

		String numberOfClassroom = tds.get(2).text();
		String numberOfSchoolHall = tds.get(5).text();
		String numberOfPlayground = tds.get(8).text();
		String numberOfLibrary = tds.get(11).text();
		String specialRooms = tds.get(14).text();
		String facilitySupportforStudentswithSpecialEducationalNeeds = tds.get(17).text();
		String others = tds.get(20).text();

		mainTable = totalTables.get(4);
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

		/*System.out.println(schoolFee);
		System.out.println(tongFai);
		System.out.println(PTAFee);
		System.out.println(approvedChargesforSpecificPurposes);
		System.out.println(otherCharges);
		System.out.println(address);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(fax);
		System.out.println(website);
		System.out.println(supervisorChairmanofManagementCommittee);
		System.out.println(schoolHead);
		System.out.println(hastheIncorporatedManagementCommitteebeenestablished);
		System.out.println(schoolType);
		System.out.println(studentGender);
		System.out.println(sponsoringBody);
		System.out.println(religion);
		System.out.println(yearofCommencementofOperation);
		System.out.println(schoolMotto);
		System.out.println(schoolSize);
		System.out.println(throughTrainSecondarySchool);
		System.out.println(feederSecondarySchool);
		System.out.println(nominatedSecondarySchool);
		System.out.println(mediumofInstruction);
		System.out.println(schoolBusService);
		System.out.println(parentTeacherAssociation);
		System.out.println(schoolAlumniAssociation);
		System.out.println(numberOfClassroom);
		System.out.println(numberOfSchoolHall);
		System.out.println(numberOfPlayground);
		System.out.println(numberOfLibrary);
		System.out.println(specialRooms);
		System.out.println(facilitySupportforStudentswithSpecialEducationalNeeds);
		System.out.println(others);
		System.out.println(numberOfteachersintheapprovedestablishment);
		System.out.println(totalnumberOfteachersintheschool);
		System.out.println(teacherCertificateDiplomainEducation);
		System.out.println(bachelorDegree);
		System.out.println(masterDoctorateDegreeorabove);
		System.out.println(specialEducationTraining);
		System.out.println(workExperience0_4years);
		System.out.println(workExperience5_9years);
		System.out.println(workExperience10yearsorabove);*/
	
		SSEntity schoolEntity = new SSEntity();
		schoolEntity.setSchoolName(schoolName);
		schoolEntity.setSchoolId(schoolId);
		schoolEntity.setAddress(address);
		schoolEntity.setTel(phone);
		schoolEntity.setSchoolEmail(email);
		schoolEntity.setFax(fax);
		schoolEntity.setSchoolWebsite(website);
		
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

		schoolEntity.setSchoolFee(schoolFee);
		schoolEntity.setTongfai(tongFai);
		schoolEntity.setSchoolFee(PTAFee);
		schoolEntity.setApprovedChargesforspecificpurposes(approvedChargesforSpecificPurposes);
		schoolEntity.setOtherCharges(otherCharges);

		schoolEntity.setTotalNoOfPermitteAccommodationOfClassroomsinuse(numberOfClassroom);
		schoolEntity.setNumberOfSchoolHall(numberOfSchoolHall);
		schoolEntity.setIndoorPlayground(numberOfPlayground);
		schoolEntity.setLibrary(numberOfLibrary);
		schoolEntity.setSpecialRooms(specialRooms);
		schoolEntity.setFacilitySupportforStudentswithSpecialEducationalNeeds(facilitySupportforStudentswithSpecialEducationalNeeds);
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

		return schoolEntity;
	}

}
