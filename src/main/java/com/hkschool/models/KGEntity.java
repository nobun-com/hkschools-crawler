package com.hkschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kindergarten")
public class KGEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	String schoolDiscription;
	String ceceorabove;
	String discriptionPtafee;
	String schoolEnglishName;
	String address;
	String approvedChargesforspecificpurposes;
	String degreeHolders;
	String fax;
	String feederSecondarySchool;
	String hastheIncorporatedmanagementcommitteebeenestablished;
	String indoorPlayground;
	String kindergartenOvervie;
	String locationNo;
	String masterDoctorateDegreeOrAbove;
	String mediumOfInstruction;
	String musicRoom;
	String nameofSchoolPrincipal;
	String nameofSchoolSupervisor;
	String nominatedSecondarySchool;
	String nonDegreeHolders;
	String numberOfRegisteredClassrooms;
	String numberofTeachersIntHeapprovedEstablishment;
	String otherCharges;
	String otherSpecialRoom;
	String otherTeacherTrainings;
	String others;
	String outDoorPlayground;
	String parentTeacherAssociation;
	String qualifiedAssistantKgTeachers;
	String qualifiedKgTeachers;
	String qualityReviewResultAndReport;
	String ratioIncludesClassesaged23;
	String religion;
	String schoolAlumniAssociation;
	String schoolBusService;
	String schoolCategory;
	String schoolEmail;
	String schoolFacilities;
	String schoolFee;
	String schoolFoundingyear;
	String schoolHistory;
	String schoolId;
	String schoolMotto;
	String schoolName;
	String schoolNo;
	String schoolSituation;
	String schoolSize;
	String schoolWebsite;
	String source;
	String specialEducationTraining;
	String sponsoringBody;
	String studentGender;
	String teacherCertificateDiplomaInEducation;
	String teacherToPupilratioInAfternoonSession;
	String teacherToPupilratioInMorningSession;
	String tel;
	String throughTrainSecondarySchool;
	String tongfai;
	String totalNoOfPermitteAccommodationOfClassroomsinuse;
	String totalNoOfPrincipalTeachingStaff;
	String workExperience04Years;
	String workExperience10YearsoOrAbove;
	String workExperience59Years;
	String yearOfSchool;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCeceorabove() {
		return ceceorabove;
	}
	public void setCeceorabove(String ceceorabove) {
		this.ceceorabove = ceceorabove;
	}
	public String getDiscriptionPtafee() {
		return discriptionPtafee;
	}
	public void setDiscriptionPtafee(String discriptionPtafee) {
		this.discriptionPtafee = discriptionPtafee;
	}
	public String getSchoolEnglishName() {
		return schoolEnglishName;
	}
	public void setSchoolEnglishName(String schoolEnglishName) {
		this.schoolEnglishName = schoolEnglishName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getApprovedChargesforspecificpurposes() {
		return approvedChargesforspecificpurposes;
	}
	public void setApprovedChargesforspecificpurposes(
			String approvedChargesforspecificpurposes) {
		this.approvedChargesforspecificpurposes = approvedChargesforspecificpurposes;
	}
	public String getDegreeHolders() {
		return degreeHolders;
	}
	public void setDegreeHolders(String degreeHolders) {
		this.degreeHolders = degreeHolders;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFeederSecondarySchool() {
		return feederSecondarySchool;
	}
	public void setFeederSecondarySchool(String feederSecondarySchool) {
		this.feederSecondarySchool = feederSecondarySchool;
	}
	public String getHastheIncorporatedmanagementcommitteebeenestablished() {
		return hastheIncorporatedmanagementcommitteebeenestablished;
	}
	public void setHastheIncorporatedmanagementcommitteebeenestablished(
			String hastheIncorporatedmanagementcommitteebeenestablished) {
		this.hastheIncorporatedmanagementcommitteebeenestablished = hastheIncorporatedmanagementcommitteebeenestablished;
	}
	public String getIndoorPlayground() {
		return indoorPlayground;
	}
	public void setIndoorPlayground(String indoorPlayground) {
		this.indoorPlayground = indoorPlayground;
	}
	public String getKindergartenOvervie() {
		return kindergartenOvervie;
	}
	public void setKindergartenOvervie(String kindergartenOvervie) {
		this.kindergartenOvervie = kindergartenOvervie;
	}
	public String getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(String locationNo) {
		this.locationNo = locationNo;
	}
	public String getMasterDoctorateDegreeOrAbove() {
		return masterDoctorateDegreeOrAbove;
	}
	public void setMasterDoctorateDegreeOrAbove(String masterDoctorateDegreeOrAbove) {
		this.masterDoctorateDegreeOrAbove = masterDoctorateDegreeOrAbove;
	}
	public String getMediumOfInstruction() {
		return mediumOfInstruction;
	}
	public void setMediumOfInstruction(String mediumOfInstruction) {
		this.mediumOfInstruction = mediumOfInstruction;
	}
	public String getMusicRoom() {
		return musicRoom;
	}
	public void setMusicRoom(String musicRoom) {
		this.musicRoom = musicRoom;
	}
	public String getNameofSchoolPrincipal() {
		return nameofSchoolPrincipal;
	}
	public void setNameofSchoolPrincipal(String nameofSchoolPrincipal) {
		this.nameofSchoolPrincipal = nameofSchoolPrincipal;
	}
	public String getNameofSchoolSupervisor() {
		return nameofSchoolSupervisor;
	}
	public void setNameofSchoolSupervisor(String nameofSchoolSupervisor) {
		this.nameofSchoolSupervisor = nameofSchoolSupervisor;
	}
	public String getNominatedSecondarySchool() {
		return nominatedSecondarySchool;
	}
	public void setNominatedSecondarySchool(String nominatedSecondarySchool) {
		this.nominatedSecondarySchool = nominatedSecondarySchool;
	}
	public String getNonDegreeHolders() {
		return nonDegreeHolders;
	}
	public void setNonDegreeHolders(String nonDegreeHolders) {
		this.nonDegreeHolders = nonDegreeHolders;
	}
	public String getNumberOfRegisteredClassrooms() {
		return numberOfRegisteredClassrooms;
	}
	public void setNumberOfRegisteredClassrooms(String numberOfRegisteredClassrooms) {
		this.numberOfRegisteredClassrooms = numberOfRegisteredClassrooms;
	}
	public String getNumberofTeachersIntHeapprovedEstablishment() {
		return numberofTeachersIntHeapprovedEstablishment;
	}
	public void setNumberofTeachersIntHeapprovedEstablishment(
			String numberofTeachersIntHeapprovedEstablishment) {
		this.numberofTeachersIntHeapprovedEstablishment = numberofTeachersIntHeapprovedEstablishment;
	}
	public String getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(String otherCharges) {
		this.otherCharges = otherCharges;
	}
	public String getOtherSpecialRoom() {
		return otherSpecialRoom;
	}
	public void setOtherSpecialRoom(String otherSpecialRoom) {
		this.otherSpecialRoom = otherSpecialRoom;
	}
	public String getOtherTeacherTrainings() {
		return otherTeacherTrainings;
	}
	public void setOtherTeacherTrainings(String otherTeacherTrainings) {
		this.otherTeacherTrainings = otherTeacherTrainings;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getOutDoorPlayground() {
		return outDoorPlayground;
	}
	public void setOutDoorPlayground(String outDoorPlayground) {
		this.outDoorPlayground = outDoorPlayground;
	}
	public String getParentTeacherAssociation() {
		return parentTeacherAssociation;
	}
	public void setParentTeacherAssociation(String parentTeacherAssociation) {
		this.parentTeacherAssociation = parentTeacherAssociation;
	}
	public String getQualifiedAssistantKgTeachers() {
		return qualifiedAssistantKgTeachers;
	}
	public void setQualifiedAssistantKgTeachers(String qualifiedAssistantKgTeachers) {
		this.qualifiedAssistantKgTeachers = qualifiedAssistantKgTeachers;
	}
	public String getQualifiedKgTeachers() {
		return qualifiedKgTeachers;
	}
	public void setQualifiedKgTeachers(String qualifiedKgTeachers) {
		this.qualifiedKgTeachers = qualifiedKgTeachers;
	}
	public String getQualityReviewResultAndReport() {
		return qualityReviewResultAndReport;
	}
	public void setQualityReviewResultAndReport(String qualityReviewResultAndReport) {
		this.qualityReviewResultAndReport = qualityReviewResultAndReport;
	}
	public String getRatioIncludesClassesaged23() {
		return ratioIncludesClassesaged23;
	}
	public void setRatioIncludesClassesaged23(String ratioIncludesClassesaged23) {
		this.ratioIncludesClassesaged23 = ratioIncludesClassesaged23;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getSchoolAlumniAssociation() {
		return schoolAlumniAssociation;
	}
	public void setSchoolAlumniAssociation(String schoolAlumniAssociation) {
		this.schoolAlumniAssociation = schoolAlumniAssociation;
	}
	public String getSchoolBusService() {
		return schoolBusService;
	}
	public void setSchoolBusService(String schoolBusService) {
		this.schoolBusService = schoolBusService;
	}
	public String getSchoolCategory() {
		return schoolCategory;
	}
	public void setSchoolCategory(String schoolCategory) {
		this.schoolCategory = schoolCategory;
	}
	public String getSchoolEmail() {
		return schoolEmail;
	}
	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}
	public String getSchoolFacilities() {
		return schoolFacilities;
	}
	public void setSchoolFacilities(String schoolFacilities) {
		this.schoolFacilities = schoolFacilities;
	}
	public String getSchoolFee() {
		return schoolFee;
	}
	public void setSchoolFee(String schoolFee) {
		this.schoolFee = schoolFee;
	}
	public String getSchoolFoundingyear() {
		return schoolFoundingyear;
	}
	public void setSchoolFoundingyear(String schoolFoundingyear) {
		this.schoolFoundingyear = schoolFoundingyear;
	}
	public String getSchoolHistory() {
		return schoolHistory;
	}
	public void setSchoolHistory(String schoolHistory) {
		this.schoolHistory = schoolHistory;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolMotto() {
		return schoolMotto;
	}
	public void setSchoolMotto(String schoolMotto) {
		this.schoolMotto = schoolMotto;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolNo() {
		return schoolNo;
	}
	public void setSchoolNo(String schoolNo) {
		this.schoolNo = schoolNo;
	}
	public String getSchoolSituation() {
		return schoolSituation;
	}
	public void setSchoolSituation(String schoolSituation) {
		this.schoolSituation = schoolSituation;
	}
	public String getSchoolSize() {
		return schoolSize;
	}
	public void setSchoolSize(String schoolSize) {
		this.schoolSize = schoolSize;
	}
	public String getSchoolWebsite() {
		return schoolWebsite;
	}
	public void setSchoolWebsite(String schoolWebsite) {
		this.schoolWebsite = schoolWebsite;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSpecialEducationTraining() {
		return specialEducationTraining;
	}
	public void setSpecialEducationTraining(String specialEducationTraining) {
		this.specialEducationTraining = specialEducationTraining;
	}
	public String getSponsoringBody() {
		return sponsoringBody;
	}
	public void setSponsoringBody(String sponsoringBody) {
		this.sponsoringBody = sponsoringBody;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public String getTeacherCertificateDiplomaInEducation() {
		return teacherCertificateDiplomaInEducation;
	}
	public void setTeacherCertificateDiplomaInEducation(
			String teacherCertificateDiplomaInEducation) {
		this.teacherCertificateDiplomaInEducation = teacherCertificateDiplomaInEducation;
	}
	public String getTeacherToPupilratioInAfternoonSession() {
		return teacherToPupilratioInAfternoonSession;
	}
	public void setTeacherToPupilratioInAfternoonSession(
			String teacherToPupilratioInAfternoonSession) {
		this.teacherToPupilratioInAfternoonSession = teacherToPupilratioInAfternoonSession;
	}
	public String getTeacherToPupilratioInMorningSession() {
		return teacherToPupilratioInMorningSession;
	}
	public void setTeacherToPupilratioInMorningSession(
			String teacherToPupilratioInMorningSession) {
		this.teacherToPupilratioInMorningSession = teacherToPupilratioInMorningSession;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getThroughTrainSecondarySchool() {
		return throughTrainSecondarySchool;
	}
	public void setThroughTrainSecondarySchool(String throughTrainSecondarySchool) {
		this.throughTrainSecondarySchool = throughTrainSecondarySchool;
	}
	public String getTongfai() {
		return tongfai;
	}
	public void setTongfai(String tongfai) {
		this.tongfai = tongfai;
	}
	public String getTotalNoOfPermitteAccommodationOfClassroomsinuse() {
		return totalNoOfPermitteAccommodationOfClassroomsinuse;
	}
	public void setTotalNoOfPermitteAccommodationOfClassroomsinuse(
			String totalNoOfPermitteAccommodationOfClassroomsinuse) {
		this.totalNoOfPermitteAccommodationOfClassroomsinuse = totalNoOfPermitteAccommodationOfClassroomsinuse;
	}
	public String getTotalNoOfPrincipalTeachingStaff() {
		return totalNoOfPrincipalTeachingStaff;
	}
	public void setTotalNoOfPrincipalTeachingStaff(
			String totalNoOfPrincipalTeachingStaff) {
		this.totalNoOfPrincipalTeachingStaff = totalNoOfPrincipalTeachingStaff;
	}
	public String getWorkExperience04Years() {
		return workExperience04Years;
	}
	public void setWorkExperience04Years(String workExperience04Years) {
		this.workExperience04Years = workExperience04Years;
	}
	public String getWorkExperience10YearsoOrAbove() {
		return workExperience10YearsoOrAbove;
	}
	public void setWorkExperience10YearsoOrAbove(
			String workExperience10YearsoOrAbove) {
		this.workExperience10YearsoOrAbove = workExperience10YearsoOrAbove;
	}
	public String getWorkExperience59Years() {
		return workExperience59Years;
	}
	public void setWorkExperience59Years(String workExperience59Years) {
		this.workExperience59Years = workExperience59Years;
	}
	public String getYearOfSchool() {
		return yearOfSchool;
	}
	public void setYearOfSchool(String yearOfSchool) {
		this.yearOfSchool = yearOfSchool;
	}
	public String getSchoolDiscription() {
		return schoolDiscription;
	}
	public void setSchoolDiscription(String schoolDiscription) {
		this.schoolDiscription = schoolDiscription;
	}
	
	

}
