package com.hkschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "kindergarten_school")
public class KGEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	
	String schoolCategouryTitle;
	String schoolFacilitiesTitle;
	String schoolHistoryTitle;
	String teachingSituationTitle;
	int scale;
	
	@Column(name="imageTop")
	@Lob
	String imageTop;
	
	
	@Column(name="schoolHistory")
	@Lob
	String schoolHistory;
	
	@Column(name="schoolFacilities")
	@Lob
	String schoolFacilities;
	
	@Column(name="teachingSituation")
	@Lob
	String teachingSituation;
	
	@Column(name="schoolFees")
	@Lob
	String schoolFees;

	@Column(name="schoolFeesTitle")
	@Lob
	String schoolFeesTitle;

	@Column(name="time")
	@Lob
	String time;
	
	@Column(name="lattitude")
	@Lob
	String lattitude;
	
	@Column(name="longitude")
	@Lob
	String longitude;
	
	@Column(name="schoolDiscription")
	@Lob
	String schoolDiscription;
	
	@Column(name="ceceorabove")
	@Lob
	String ceceorabove;
	
	@Column(name="studentCategory")
	@Lob
	String studentCategory;
	
	@Column(name="district")
	@Lob
	String district;
	
	@Column(name="address")
	@Lob
	String address;
		
	@Column(name="degreeHolders")
	@Lob
	String degreeHolders;
	
	@Column(name="fax")
	@Lob
	String fax;
	
	@Column(name="indoorPlayground")
	@Lob
	String indoorPlayground;
	
	@Column(name="locationNo")
	@Lob
	String locationNo;
	
	@Column(name="musicRoom")
	@Lob
	String musicRoom;
	
	@Column(name="nameofSchoolPrincipal")
	@Lob
	String nameofSchoolPrincipal;
	
	@Column(name="nameofSchoolSupervisor")
	@Lob
	String nameofSchoolSupervisor;
	
	@Column(name="nonDegreeHolders")
	@Lob
	String nonDegreeHolders;
	
	@Column(name="numberOfRegisteredClassrooms")
	@Lob
	String numberOfRegisteredClassrooms;
	
	@Column(name="otherSpecialRoom")
	@Lob
	String otherSpecialRoom;
	
	@Column(name="otherTeacherTrainings")
	@Lob
	String otherTeacherTrainings;
	
	@Column(name="others")
	@Lob
	String others;
	
	@Column(name="outDoorPlayground")
	@Lob
	String outDoorPlayground;
	
	
	@Column(name="qualifiedAssistantKgTeachers")
	@Lob
	String qualifiedAssistantKgTeachers;
	
	@Column(name="ratioIncludesClassesaged23")
	@Lob
	String ratioIncludesClassesaged23;
	
	@Column(name="schoolCategory")
	@Lob
	String schoolCategory;
	
	@Column(name="schoolFoundingyear")
	@Lob
	String schoolFoundingyear;
	
	@Column(name="schoolId")
	@Lob
	String schoolId;
	
	
	@Column(name="schoolName")
	@Lob
	String schoolName;
	
	@Column(name="schoolNo")
	@Lob
	String schoolNo;
	
	@Column(name="schoolWebsite")
	@Lob
	String schoolWebsite;
	
	@Column(name="source")
	@Lob
	String source;
	
	@Column(name="teacherToPupilratioInAfternoonSession")
	@Lob
	String teacherToPupilratioInAfternoonSession;
	
	@Column(name="teacherToPupilratioInMorningSession")
	@Lob
	String teacherToPupilratioInMorningSession;
	
	@Column(name="tel")
	@Lob
	String tel;
	
	@Column(name="totalNoOfPermitteAccommodationOfClassroomsinuse")
	@Lob
	String totalNoOfPermitteAccommodationOfClassroomsinuse;
	
	@Column(name="nurseryAMSession")
	@Lob
	String nurseryAMSession ;
	
	@Column(name="lowerKGAMSession")
	@Lob
	String lowerKGAMSession ;
	
	@Column(name="upperKGAMSession")
	@Lob
	String upperKGAMSession ;
	
	@Column(name="totalAMSession")
	@Lob
	String totalAMSession ;
	
	@Column(name="nurseryPMSession")
	@Lob
	String nurseryPMSession ;
	
	@Column(name="lowerKGPMSession")
	@Lob
	String lowerKGPMSession ;
	
	@Column(name="upperKGPMSession")
	@Lob
	String upperKGPMSession ;
	
	@Column(name="totalPMSession")
	@Lob
	String totalPMSession ;
	
	@Column(name="nurseryWDSession")
	@Lob
	String nurseryWDSession ;
	
	@Column(name="lowerKGWDSession")
	@Lob
	String lowerKGWDSession ;
	
	@Column(name="upperKGWDSession")
	@Lob
	String upperKGWDSession ;
	
	@Column(name="totalWDSession")
	@Lob
	String totalWDSession ;
	
	@Column(name="Feelevelfullday")
	@Lob
    String Feelevelfullday; 
    
    @Column(name="Feelevelhalfday")
	@Lob
	String Feelevelhalfday;
	
	
	@Column(name="withchildcareservicesforchildrenagedunder2")
	@Lob
	String withchildcareservicesforchildrenagedunder2 ; 
	
	@Column(name="Noofenrolmentaged2_3")
	@Lob
	String Noofenrolmentaged2_3;
	
	@Column(name="JoiningChildCareCentreSubsidyScheme")
	@Lob
	String JoiningChildCareCentreSubsidyScheme ; 
	
	@Column(name="Providingoccasionalchildcareservices")
	@Lob
	String Providingoccasionalchildcareservices ; 
	
	@Column(name="nurseryAMSessionfees")
	@Lob
	String nurseryAMSessionfees;
	
	@Column(name="lowerKGAMSessionfees")
	@Lob
	String lowerKGAMSessionfees;
	
	@Column(name="upperKGAMSessionfees")
	@Lob
	String upperKGAMSessionfees;
	
	@Column(name="nurseryPMSessionfees")
	@Lob
	String nurseryPMSessionfees;
	
	@Column(name="lowerKGPMSessionfees")
	@Lob
	String lowerKGPMSessionfees;
	
	@Column(name="upperKGPMSessionfees")
	@Lob
	String upperKGPMSessionfees;
	
	@Column(name="nurseryWDSessionfees")
	@Lob
	String nurseryWDSessionfees;
	
	@Column(name="lowerKGWDSessionfees")
	@Lob
	String lowerKGWDSessionfees;
	
	@Column(name="upperKGWDSessionfees")
	@Lob
	String upperKGWDSessionfees;
	
	@Column(name="applicationFormDownload")
	@Lob
	String applicationFormDownload;
	
	@Column(name="applicationPeriod")
	@Lob
	String applicationPeriod; 

	
	@Column(name="summerUniform")
	@Lob
	String summerUniform;
	
	@Column(name="winterUniform")
	@Lob
	String winterUniform;
	
	@Column(name="schoolBag")
	@Lob
	String schoolBag;
	
	@Column(name="teaAndSnacks")
	@Lob
	String teaAndSnacks;
	
	@Column(name="textBoo0ks")
	@Lob
	String textBoo0ks;
	
	@Column(name="ExerciseBook_workbooks")
	@Lob
	String ExerciseBook_workbooks;

	@Column(name="Providingextendedhoursservices")
	@Lob
	String Providingextendedhoursservices ;
	
	@Column(name="CurriculumDetails")
	@Lob
	String CurriculumDetails;
	
	@Column(name="Curriculumtype")
	@Lob
	String Curriculumtype; 
	
	@Column(name="Curriculumplanning")
	@Lob
	String Curriculumplanning;
	
	@Column(name="LearningTeachingapproachandactivities")
	@Lob
	String LearningTeachingapproachandactivities; 
	
	@Column(name="Assessmentofchildrenslearningexperiences")
	@Lob
	String Assessmentofchildrenslearningexperiences; 
	
	@Column(name="schoolVisionAndMission")
	@Lob
	String schoolVisionAndMission;
	
	@Column(name="supportToStudents")
	@Lob
	String supportToStudents;
	
	@Column(name="parent_Teacherassociation")
	@Lob
	String parent_Teacherassociation;
	
	@Column(name="otherActivities_communicationWithParents")
	@Lob
	String otherActivities_communicationWithParents;
	
	@Column(name="applicationFee")
	@Lob
	String applicationFee;
	
	@Column(name="registrationFeeHalf_Daysession")
	@Lob
	String registrationFeeHalf_Daysession;
	
	@Column(name="registrationFeeWhole_Daysession")
	@Lob
	String registrationFeeWhole_Daysession;

	String image;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getIndoorPlayground() {
		return indoorPlayground;
	}
	public void setIndoorPlayground(String indoorPlayground) {
		this.indoorPlayground = indoorPlayground;
	}
	public String getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(String locationNo) {
		this.locationNo = locationNo;
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
	public String getQualifiedAssistantKgTeachers() {
		return qualifiedAssistantKgTeachers;
	}
	public void setQualifiedAssistantKgTeachers(String qualifiedAssistantKgTeachers) {
		this.qualifiedAssistantKgTeachers = qualifiedAssistantKgTeachers;
	}
	public String getRatioIncludesClassesaged23() {
		return ratioIncludesClassesaged23;
	}
	public void setRatioIncludesClassesaged23(String ratioIncludesClassesaged23) {
		this.ratioIncludesClassesaged23 = ratioIncludesClassesaged23;
	}
	public String getSchoolCategory() {
		return schoolCategory;
	}
	public void setSchoolCategory(String schoolCategory) {
		this.schoolCategory = schoolCategory;
	}
	public String getSchoolFoundingyear() {
		return schoolFoundingyear;
	}
	public void setSchoolFoundingyear(String schoolFoundingyear) {
		this.schoolFoundingyear = schoolFoundingyear;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
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
	
	public String getTotalNoOfPermitteAccommodationOfClassroomsinuse() {
		return totalNoOfPermitteAccommodationOfClassroomsinuse;
	}
	public void setTotalNoOfPermitteAccommodationOfClassroomsinuse(
			String totalNoOfPermitteAccommodationOfClassroomsinuse) {
		this.totalNoOfPermitteAccommodationOfClassroomsinuse = totalNoOfPermitteAccommodationOfClassroomsinuse;
	}
	public String getSchoolDiscription() {
		return schoolDiscription;
	}
	public void setSchoolDiscription(String schoolDiscription) {
		this.schoolDiscription = schoolDiscription;
	}
	public String getNurseryAMSession() {
		return nurseryAMSession;
	}
	public void setNurseryAMSession(String nurseryAMSession) {
		this.nurseryAMSession = nurseryAMSession;
	}
	public String getLowerKGAMSession() {
		return lowerKGAMSession;
	}
	public void setLowerKGAMSession(String lowerKGAMSession) {
		this.lowerKGAMSession = lowerKGAMSession;
	}
	public String getUpperKGAMSession() {
		return upperKGAMSession;
	}
	public void setUpperKGAMSession(String upperKGAMSession) {
		this.upperKGAMSession = upperKGAMSession;
	}
	public String getTotalAMSession() {
		return totalAMSession;
	}
	public void setTotalAMSession(String totalAMSession) {
		this.totalAMSession = totalAMSession;
	}
	public String getNurseryPMSession() {
		return nurseryPMSession;
	}
	public void setNurseryPMSession(String nurseryPMSession) {
		this.nurseryPMSession = nurseryPMSession;
	}
	public String getLowerKGPMSession() {
		return lowerKGPMSession;
	}
	public void setLowerKGPMSession(String lowerKGPMSession) {
		this.lowerKGPMSession = lowerKGPMSession;
	}
	public String getUpperKGPMSession() {
		return upperKGPMSession;
	}
	public void setUpperKGPMSession(String upperKGPMSession) {
		this.upperKGPMSession = upperKGPMSession;
	}
	public String getTotalPMSession() {
		return totalPMSession;
	}
	public void setTotalPMSession(String totalPMSession) {
		this.totalPMSession = totalPMSession;
	}
	public String getNurseryWDSession() {
		return nurseryWDSession;
	}
	public void setNurseryWDSession(String nurseryWDSession) {
		this.nurseryWDSession = nurseryWDSession;
	}
	public String getLowerKGWDSession() {
		return lowerKGWDSession;
	}
	public void setLowerKGWDSession(String lowerKGWDSession) {
		this.lowerKGWDSession = lowerKGWDSession;
	}
	public String getUpperKGWDSession() {
		return upperKGWDSession;
	}
	public void setUpperKGWDSession(String upperKGWDSession) {
		this.upperKGWDSession = upperKGWDSession;
	}
	public String getTotalWDSession() {
		return totalWDSession;
	}
	public void setTotalWDSession(String totalWDSession) {
		this.totalWDSession = totalWDSession;
	}
	
	public String getFeelevelhalfday() {
		return Feelevelhalfday;
	}
	public void setFeelevelhalfday(String feelevelhalfday) {
		Feelevelhalfday = feelevelhalfday;
	}
	public String getFeelevelfullday() {
		return Feelevelfullday;
	}
	public void setFeelevelfullday(String feelevelfullday) {
		Feelevelfullday = feelevelfullday;
	}
	
	public String getWithchildcareservicesforchildrenagedunder2() {
		return withchildcareservicesforchildrenagedunder2;
	}
	public void setWithchildcareservicesforchildrenagedunder2(
			String withchildcareservicesforchildrenagedunder2) {
		this.withchildcareservicesforchildrenagedunder2 = withchildcareservicesforchildrenagedunder2;
	}
	public String getNoofenrolmentaged2_3() {
		return Noofenrolmentaged2_3;
	}
	public void setNoofenrolmentaged2_3(String noofenrolmentaged2_3) {
		Noofenrolmentaged2_3 = noofenrolmentaged2_3;
	}
	public String getJoiningChildCareCentreSubsidyScheme() {
		return JoiningChildCareCentreSubsidyScheme;
	}
	public void setJoiningChildCareCentreSubsidyScheme(
			String joiningChildCareCentreSubsidyScheme) {
		JoiningChildCareCentreSubsidyScheme = joiningChildCareCentreSubsidyScheme;
	}
	public String getProvidingoccasionalchildcareservices() {
		return Providingoccasionalchildcareservices;
	}
	public void setProvidingoccasionalchildcareservices(
			String providingoccasionalchildcareservices) {
		Providingoccasionalchildcareservices = providingoccasionalchildcareservices;
	}
	public String getProvidingextendedhoursservices() {
		return Providingextendedhoursservices;
	}
	public void setProvidingextendedhoursservices(
			String providingextendedhoursservices) {
		Providingextendedhoursservices = providingextendedhoursservices;
	}
	public String getCurriculumDetails() {
		return CurriculumDetails;
	}
	public void setCurriculumDetails(String curriculumDetails) {
		CurriculumDetails = curriculumDetails;
	}
		
	public String getCurriculumtype() {
		return Curriculumtype;
	}
	public void setCurriculumtype(String curriculumtype) {
		Curriculumtype = curriculumtype;
	}
	public String getCurriculumplanning() {
		return Curriculumplanning;
	}
	public void setCurriculumplanning(String curriculumplanning) {
		Curriculumplanning = curriculumplanning;
	}
	public String getLearningTeachingapproachandactivities() {
		return LearningTeachingapproachandactivities;
	}
	public void setLearningTeachingapproachandactivities(
			String learningTeachingapproachandactivities) {
		LearningTeachingapproachandactivities = learningTeachingapproachandactivities;
	}
	public String getAssessmentofchildrenslearningexperiences() {
		return Assessmentofchildrenslearningexperiences;
	}
	public void setAssessmentofchildrenslearningexperiences(
			String assessmentofchildrenslearningexperiences) {
		Assessmentofchildrenslearningexperiences = assessmentofchildrenslearningexperiences;
	}
	public String getSummerUniform() {
		return summerUniform;
	}
	public void setSummerUniform(String summerUniform) {
		this.summerUniform = summerUniform;
	}
	public String getWinterUniform() {
		return winterUniform;
	}
	public void setWinterUniform(String winterUniform) {
		this.winterUniform = winterUniform;
	}
	public String getSchoolBag() {
		return schoolBag;
	}
	public void setSchoolBag(String schoolBag) {
		this.schoolBag = schoolBag;
	}
	public String getTeaAndSnacks() {
		return teaAndSnacks;
	}
	public void setTeaAndSnacks(String teaAndSnacks) {
		this.teaAndSnacks = teaAndSnacks;
	}
	public String getTextBoo0ks() {
		return textBoo0ks;
	}
	public void setTextBoo0ks(String textBoo0ks) {
		this.textBoo0ks = textBoo0ks;
	}
	public String getExerciseBook_workbooks() {
		return ExerciseBook_workbooks;
	}
	public void setExerciseBook_workbooks(String exerciseBook_workbooks) {
		ExerciseBook_workbooks = exerciseBook_workbooks;
	}
	public String getApplicationFormDownload() {
		return applicationFormDownload;
	}
	public void setApplicationFormDownload(String applicationFormDownload) {
		this.applicationFormDownload = applicationFormDownload;
	}
	public String getApplicationPeriod() {
		return applicationPeriod;
	}
	public void setApplicationPeriod(String applicationPeriod) {
		this.applicationPeriod = applicationPeriod;
	}
	public String getSchoolVisionAndMission() {
		return schoolVisionAndMission;
	}
	public void setSchoolVisionAndMission(String schoolVisionAndMission) {
		this.schoolVisionAndMission = schoolVisionAndMission;
	}
	public String getSupportToStudents() {
		return supportToStudents;
	}
	public void setSupportToStudents(String supportToStudents) {
		this.supportToStudents = supportToStudents;
	}
	public String getParent_Teacherassociation() {
		return parent_Teacherassociation;
	}
	public void setParent_Teacherassociation(String parent_Teacherassociation) {
		this.parent_Teacherassociation = parent_Teacherassociation;
	}
	public String getOtherActivities_communicationWithParents() {
		return otherActivities_communicationWithParents;
	}
	public void setOtherActivities_communicationWithParents(
			String otherActivities_communicationWithParents) {
		this.otherActivities_communicationWithParents = otherActivities_communicationWithParents;
	}
	public String getApplicationFee() {
		return applicationFee;
	}
	public void setApplicationFee(String applicationFee) {
		this.applicationFee = applicationFee;
	}
	public String getRegistrationFeeHalf_Daysession() {
		return registrationFeeHalf_Daysession;
	}
	public void setRegistrationFeeHalf_Daysession(
			String registrationFeeHalf_Daysession) {
		this.registrationFeeHalf_Daysession = registrationFeeHalf_Daysession;
	}
	public String getRegistrationFeeWhole_Daysession() {
		return registrationFeeWhole_Daysession;
	}
	public void setRegistrationFeeWhole_Daysession(
			String registrationFeeWhole_Daysession) {
		this.registrationFeeWhole_Daysession = registrationFeeWhole_Daysession;
	}
	public String getNurseryAMSessionfees() {
		return nurseryAMSessionfees;
	}
	public void setNurseryAMSessionfees(String nurseryAMSessionfees) {
		this.nurseryAMSessionfees = nurseryAMSessionfees;
	}
	public String getLowerKGWDSessionfees() {
		return lowerKGWDSessionfees;
	}
	public void setLowerKGWDSessionfees(String lowerKGWDSessionfees) {
		this.lowerKGWDSessionfees = lowerKGWDSessionfees;
	}
	public String getUpperKGAMSessionfees() {
		return upperKGAMSessionfees;
	}
	public void setUpperKGAMSessionfees(String upperKGAMSessionfees) {
		this.upperKGAMSessionfees = upperKGAMSessionfees;
	}
	public String getLowerKGAMSessionfees() {
		return lowerKGAMSessionfees;
	}
	public void setLowerKGAMSessionfees(String lowerKGAMSessionfees) {
		this.lowerKGAMSessionfees = lowerKGAMSessionfees;
	}
	public String getNurseryPMSessionfees() {
		return nurseryPMSessionfees;
	}
	public void setNurseryPMSessionfees(String nurseryPMSessionfees) {
		this.nurseryPMSessionfees = nurseryPMSessionfees;
	}
	public String getLowerKGPMSessionfees() {
		return lowerKGPMSessionfees;
	}
	public void setLowerKGPMSessionfees(String lowerKGPMSessionfees) {
		this.lowerKGPMSessionfees = lowerKGPMSessionfees;
	}
	public String getUpperKGPMSessionfees() {
		return upperKGPMSessionfees;
	}
	public void setUpperKGPMSessionfees(String upperKGPMSessionfees) {
		this.upperKGPMSessionfees = upperKGPMSessionfees;
	}
	public String getNurseryWDSessionfees() {
		return nurseryWDSessionfees;
	}
	public void setNurseryWDSessionfees(String nurseryWDSessionfees) {
		this.nurseryWDSessionfees = nurseryWDSessionfees;
	}
	public String getUpperKGWDSessionfees() {
		return upperKGWDSessionfees;
	}
	public void setUpperKGWDSessionfees(String upperKGWDSessionfees) {
		this.upperKGWDSessionfees = upperKGWDSessionfees;
	}
	public String getStudentCategory() {
		return studentCategory;
	}
	public void setStudentCategory(String studentCategory) {
		this.studentCategory = studentCategory;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSchoolHistory() {
		return schoolHistory;
	}
	public void setSchoolHistory(String schoolHistory) {
		this.schoolHistory = schoolHistory;
	}
	public String getSchoolFacilities() {
		return schoolFacilities;
	}
	public void setSchoolFacilities(String schoolFacilities) {
		this.schoolFacilities = schoolFacilities;
	}
	public String getTeachingSituation() {
		return teachingSituation;
	}
	public void setTeachingSituation(String teachingSituation) {
		this.teachingSituation = teachingSituation;
	}
	public String getSchoolCategouryTitle() {
		return schoolCategouryTitle;
	}
	public void setSchoolCategouryTitle(String schoolCategouryTitle) {
		this.schoolCategouryTitle = schoolCategouryTitle;
	}
	public String getSchoolFacilitiesTitle() {
		return schoolFacilitiesTitle;
	}
	public void setSchoolFacilitiesTitle(String schoolFacilitiesTitle) {
		this.schoolFacilitiesTitle = schoolFacilitiesTitle;
	}
	public String getSchoolHistoryTitle() {
		return schoolHistoryTitle;
	}
	public void setSchoolHistoryTitle(String schoolHistoryTitle) {
		this.schoolHistoryTitle = schoolHistoryTitle;
	}
	public String getTeachingSituationTitle() {
		return teachingSituationTitle;
	}
	public void setTeachingSituationTitle(String teachingSituationTitle) {
		this.teachingSituationTitle = teachingSituationTitle;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageTop() {
		return imageTop;
	}
	public void setImageTop(String imageTop) {
		this.imageTop = imageTop;
	}
	public String getSchoolFees() {
		return schoolFees;
	}
	public void setSchoolFees(String schoolFees) {
		this.schoolFees = schoolFees;
	}
	public String getSchoolFeesTitle() {
		return schoolFeesTitle;
	}
	public void setSchoolFeesTitle(String schoolFeesTitle) {
		this.schoolFeesTitle = schoolFeesTitle;
	}
	
}
