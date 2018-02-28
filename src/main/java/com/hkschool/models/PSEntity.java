package com.hkschool.models;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "primary_school")
public class PSEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	String schoolCategouryTitle;
	String schoolFacilitiesTitle;
	String schoolHistoryTitle;
	String teachingSituationTitle;
	
	String image;
	String imageTop;
	String schoolYear2013;
	String schoolTeachers2013;
	String approvalPreparation2013;
	String total2013;
	String smallOne2013;
	String smallTwo2013;
	String smallThree2013;
	String smallFour2013;
	String smallFive2013;
	String littleSix2013;
	String schoolYear2014;
	String schoolTeachers2014;
	String approvalPreparation2014;
	String total2014;
	String smallOne2014;
	String smallTwo2014;
	String smallThree2014;
	String smallFour2014;
	String smallfive2014;
	String littlesix2014;
	String schoolyear2015;
	String schoolTeachers2015;
	String approvalPreparation2015;
	String total2015;
	String smallOne2015;
	String smallTwo2015;
	String smallThree2015;
	String smallFour2015;
	String smallfive2015;
	String littlesix2015;
	String schoolyear2016;
	String schoolTeachers2016;
	String approvalPreparation2016;
	String total2016;
	String smallOne2016;
	String smallTwo2016;
	String smallThree2016;
	String smallFour2016;
	String smallfive2016;
	String littlesix2016;
	String schoolyear2017;
	String schoolTeachers2017;
	String approvalPreparation2017;
	String total2017;
	String smallOne2017;
	String smallTwo2017;
	String smallThree2017;
	String smallFour2017;
	String smallfive2017;
	String littlesix2017;
	String schoolDiscritpion;
	String schoolHistory;
	String schoolFacilities;
	String teachingSituation;
	
	
	@Column(name="time")
	@Lob
	String time;
	
	@Column(name="lattitude")
	@Lob
	String lattitude;
	
	@Column(name="longitude")
	@Lob
	String longitude;
	
	@Column(name="district")
	@Lob
	String district;
	
	@Column(name="address")
	@Lob
	String address;
	
	@Column(name="approvedChargesforspecificpurposes")
	@Lob
	String approvedChargesforspecificpurposes;
	
	@Column(name="fax")
	@Lob
	String fax;
	
	@Column(name="feederSecondarySchool")
	@Lob
	String feederSecondarySchool;
	
	@Column(name="hastheIncorporatedmanagementcommitteebeenestablished")
	@Lob
	String hastheIncorporatedmanagementcommitteebeenestablished;
	
	@Column(name="indoorPlayground")
	@Lob
	String indoorPlayground;
	
	@Column(name="masterDoctorateDegreeOrAbove")
	@Lob
	String masterDoctorateDegreeOrAbove;
	
	@Column(name="mediumOfInstruction")
	@Lob
	String mediumOfInstruction;
	
	@Column(name="nameofSchoolPrincipal")
	@Lob
	String nameofSchoolPrincipal;
	
	@Column(name="nominatedSecondarySchool")
	@Lob
	String nominatedSecondarySchool;
	
	@Column(name="numberofTeachersIntHeapprovedEstablishment")
	@Lob
	String numberofTeachersIntHeapprovedEstablishment;
	
	@Column(name="otherCharges")
	@Lob
	String otherCharges;
	
	@Column(name="parentTeacherAssociation")
	@Lob
	String parentTeacherAssociation;
	
	@Column(name="religion")
	@Lob
	String religion;
	
	@Column(name="schoolAlumniAssociation")
	@Lob
	String schoolAlumniAssociation;
	
	@Column(name="schoolBusService")
	@Lob
	String schoolBusService;
	
	@Column(name="schoolCategory")
	@Lob
	String schoolCategory;
	
	@Column(name="schoolEmail")
	@Lob
	String schoolEmail;
	
	@Column(name="schoolFee")
	@Lob
	String schoolFee;
	
	@Column(name="schoolId")
	@Lob
	String schoolId;
	
	@Column(name="schoolMotto")
	@Lob
	String schoolMotto;
	
	@Column(name="schoolName")
	@Lob
	String schoolName;
	
	@Column(name="schoolSize")
	@Lob
	String schoolSize;
	
	@Column(name="schoolWebsite")
	@Lob
	String schoolWebsite;
	
	@Column(name="source")
	@Lob
	String source;
	
	@Column(name="specialEducationTraining")
	@Lob
	String specialEducationTraining;
	
	@Column(name="sponsoringBody")
	@Lob
	String sponsoringBody;
	
	@Column(name="studentGender")
	@Lob
	String studentGender;
	
	@Column(name="teacherCertificateDiplomaInEducation")
	@Lob
	String teacherCertificateDiplomaInEducation;
	
	@Column(name="tel")
	@Lob
	String tel;
	
	@Column(name="throughTrainSecondarySchool")
	@Lob
	String throughTrainSecondarySchool;
	
	@Column(name="tongfai")
	@Lob
	String tongfai;
	
	@Column(name="totalNoOfPermitteAccommodationOfClassroomsinuse")
	@Lob
	String totalNoOfPermitteAccommodationOfClassroomsinuse;	
	
	@Column(name="workExperience0_4Years")
	@Lob
	String workExperience0_4Years;
	
	@Column(name="workExperience10YearsoOrAbove")
	@Lob
	String workExperience10YearsoOrAbove;
	
	@Column(name="workExperience5_9Years")
	@Lob
	String workExperience5_9Years;	
	
	@Column(name="yearofCommencementofOperation")
	@Lob
	String yearofCommencementofOperation;

	@Column(name="numberOfLibrary")
	@Lob
	String numberOfLibrary;
	
	@Column(name="numberOfSchoolHall")
	@Lob
	String numberOfSchoolHall;
	
	@Column(name="totalnumberOfteachersintheschool")
	@Lob
	String totalnumberOfteachersintheschool;
	
	@Column(name="bachelorDegree")
	@Lob
	String bachelorDegree;
	
	@Column(name="supervisorChairmanofManagementCommittee")
	@Lob
	String supervisorChairmanofManagementCommittee;
	
	
	@Column(name="SchoolManagementOrganisation")
	@Lob
	String SchoolManagementOrganisation;
	
	@Column(name="IncorporatedCommittee")
	@Lob
	String IncorporatedCommittee;
	
	@Column(name="SchoolGreenPolicy")
	@Lob
	String SchoolGreenPolicy;
	
	@Column(name="SchoolsMajorConcerns")
	@Lob
	String SchoolsMajorConcerns;
	
	@Column(name="LearningAndTeachingStrategies")
	@Lob
	String LearningAndTeachingStrategies;
	
	@Column(name="DevelopmentofKeyTasks")
	@Lob
	String DevelopmentofKeyTasks;
	
	@Column(name="DevelopmentofGenericSkills")
	@Lob
	String DevelopmentofGenericSkills;
	
	@Column(name="WholeSchoolApproachtoCaterforStudentDiversity")
	@Lob
	String WholeSchoolApproachtoCaterforStudentDiversity;
	
	@Column(name="CurriculumTailoringandAdaptation")
	@Lob
	String CurriculumTailoringandAdaptation;
	
	@Column(name="Home_SchoolCo_operation")
	@Lob
	String Home_SchoolCo_operation;
	
	@Column(name="SchoolEthos")
	@Lob
	String SchoolEthos;
	
	@Column(name="SchoolDevelopmentPlan")
	@Lob
	String SchoolDevelopmentPlan;
	
	@Column(name="TeacherProfessionalTrainingAndDevelopment")
	@Lob
	String TeacherProfessionalTrainingAndDevelopment;
	
	@Column(name="FeeRemissionScheme")
	@Lob
	String FeeRemissionScheme;
	
	@Column(name="Others")
	@Lob
	String Others;
	
	@Column(name="NumberofSchoolDaysperweek")
	@Lob
	String NumberofSchoolDaysperweek;
	
	@Column(name="Numberofperiodsperday")
	@Lob
	String Numberofperiodsperday;
	
	@Column(name="Durationofeachnormalperiod")
	@Lob
	String Durationofeachnormalperiod;
	
	@Column(name="Schoolstartsat")
	@Lob
	String Schoolstartsat;
	
	@Column(name="Schoolendsat")
	@Lob
	String Schoolendsat;
	
	@Column(name="Lunchtime")
	@Lob
	String Lunchtime;
	
	@Column(name="Luncharrangement")
	@Lob
	String Luncharrangement;
	
	@Column(name="Healthyschoollife")
	@Lob
	String Healthyschoollife;
	
	@Column(name="Remarks")
	@Lob
	String Remarks;

	
	@Column(name="numberOfTestPerYear")
	@Lob
	String numberOfTestPerYear;
	
	@Column(name="numberOfExamPerYear")
	@Lob
	String numberOfExamPerYear;
	
	@Column(name="streamingArrangement")
	@Lob
	String streamingArrangement;
	
	@Column(name="diversifiedAssessmentForLearning")
	@Lob
	String diversifiedAssessmentForLearning;
	
	@Column(name="numberOfClassroom")
	@Lob
	String numberOfClassroom;
	

	@Column(name="facilitySupportforStudentswithSpecialEducationalNeeds")
	@Lob
	String facilitySupportforStudentswithSpecialEducationalNeeds;
	
	public String getWorkExperience0_4Years() {
		return workExperience0_4Years;
	}
	public void setWorkExperience0_4Years(String workExperience0_4Years) {
		this.workExperience0_4Years = workExperience0_4Years;
	}
	public String getWorkExperience5_9Years() {
		return workExperience5_9Years;
	}
	public void setWorkExperience5_9Years(String workExperience5_9Years) {
		this.workExperience5_9Years = workExperience5_9Years;
	}
	public String getNumberOfLibrary() {
		return numberOfLibrary;
	}
	public void setNumberOfLibrary(String numberOfLibrary) {
		this.numberOfLibrary = numberOfLibrary;
	}
	
	public String getNumberOfSchoolHall() {
		return numberOfSchoolHall;
	}
	public void setNumberOfSchoolHall(String numberOfSchoolHall) {
		this.numberOfSchoolHall = numberOfSchoolHall;
	}
	public String getTotalnumberOfteachersintheschool() {
		return totalnumberOfteachersintheschool;
	}
	public void setTotalnumberOfteachersintheschool(
			String totalnumberOfteachersintheschool) {
		this.totalnumberOfteachersintheschool = totalnumberOfteachersintheschool;
	}
	public String getBachelorDegree() {
		return bachelorDegree;
	}
	public void setBachelorDegree(String bachelorDegree) {
		this.bachelorDegree = bachelorDegree;
	}
	public String getYearofCommencementofOperation() {
		return yearofCommencementofOperation;
	}
	public void setYearofCommencementofOperation(
			String yearofCommencementofOperation) {
		this.yearofCommencementofOperation = yearofCommencementofOperation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getNameofSchoolPrincipal() {
		return nameofSchoolPrincipal;
	}
	public void setNameofSchoolPrincipal(String nameofSchoolPrincipal) {
		this.nameofSchoolPrincipal = nameofSchoolPrincipal;
	}
	
	public String getNominatedSecondarySchool() {
		return nominatedSecondarySchool;
	}
	public void setNominatedSecondarySchool(String nominatedSecondarySchool) {
		this.nominatedSecondarySchool = nominatedSecondarySchool;
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
	public String getParentTeacherAssociation() {
		return parentTeacherAssociation;
	}
	public void setParentTeacherAssociation(String parentTeacherAssociation) {
		this.parentTeacherAssociation = parentTeacherAssociation;
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
	public String getSchoolFee() {
		return schoolFee;
	}
	public void setSchoolFee(String schoolFee) {
		this.schoolFee = schoolFee;
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
	
	public String getWorkExperience04Years() {
		return workExperience0_4Years;
	}
	public void setWorkExperience04Years(String workExperience04Years) {
		this.workExperience0_4Years = workExperience04Years;
	}
	public String getWorkExperience10YearsoOrAbove() {
		return workExperience10YearsoOrAbove;
	}
	public void setWorkExperience10YearsoOrAbove(
			String workExperience10YearsoOrAbove) {
		this.workExperience10YearsoOrAbove = workExperience10YearsoOrAbove;
	}
	public String getWorkExperience59Years() {
		return workExperience5_9Years;
	}
	public void setWorkExperience59Years(String workExperience59Years) {
		this.workExperience5_9Years = workExperience59Years;
	}
	
	public String getNumberOfTestPerYear() {
		return numberOfTestPerYear;
	}
	public void setNumberOfTestPerYear(String numberOfTestPerYear) {
		this.numberOfTestPerYear = numberOfTestPerYear;
	}
	public String getNumberOfExamPerYear() {
		return numberOfExamPerYear;
	}
	public void setNumberOfExamPerYear(String numberOfExamPerYear) {
		this.numberOfExamPerYear = numberOfExamPerYear;
	}
	public String getStreamingArrangement() {
		return streamingArrangement;
	}
	public void setStreamingArrangement(String streamingArrangement) {
		this.streamingArrangement = streamingArrangement;
	}
	public String getDiversifiedAssessmentForLearning() {
		return diversifiedAssessmentForLearning;
	}
	public void setDiversifiedAssessmentForLearning(
			String diversifiedAssessmentForLearning) {
		this.diversifiedAssessmentForLearning = diversifiedAssessmentForLearning;
	}
	public String getNumberofSchoolDaysperweek() {
		return NumberofSchoolDaysperweek;
	}
	public void setNumberofSchoolDaysperweek(String numberofSchoolDaysperweek) {
		NumberofSchoolDaysperweek = numberofSchoolDaysperweek;
	}
	public String getNumberofperiodsperday() {
		return Numberofperiodsperday;
	}
	public void setNumberofperiodsperday(String numberofperiodsperday) {
		Numberofperiodsperday = numberofperiodsperday;
	}
	public String getDurationofeachnormalperiod() {
		return Durationofeachnormalperiod;
	}
	public void setDurationofeachnormalperiod(String durationofeachnormalperiod) {
		Durationofeachnormalperiod = durationofeachnormalperiod;
	}
	public String getSchoolstartsat() {
		return Schoolstartsat;
	}
	public void setSchoolstartsat(String schoolstartsat) {
		Schoolstartsat = schoolstartsat;
	}
	public String getSchoolendsat() {
		return Schoolendsat;
	}
	public void setSchoolendsat(String schoolendsat) {
		Schoolendsat = schoolendsat;
	}
	public String getLunchtime() {
		return Lunchtime;
	}
	public void setLunchtime(String lunchtime) {
		Lunchtime = lunchtime;
	}
	public String getLuncharrangement() {
		return Luncharrangement;
	}
	public void setLuncharrangement(String luncharrangement) {
		Luncharrangement = luncharrangement;
	}
	public String getHealthyschoollife() {
		return Healthyschoollife;
	}
	public void setHealthyschoollife(String healthyschoollife) {
		Healthyschoollife = healthyschoollife;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getSchoolManagementOrganisation() {
		return SchoolManagementOrganisation;
	}
	public void setSchoolManagementOrganisation(String schoolManagementOrganisation) {
		SchoolManagementOrganisation = schoolManagementOrganisation;
	}
	public String getIncorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee() {
		return IncorporatedCommittee;
	}
	public void setIncorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee(
			String incorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee) {
		IncorporatedCommittee = incorporatedManagementCommittee_SchoolManagementCommittee_ManagementCommittee;
	}
	public String getSchoolGreenPolicy() {
		return SchoolGreenPolicy;
	}
	public void setSchoolGreenPolicy(String schoolGreenPolicy) {
		SchoolGreenPolicy = schoolGreenPolicy;
	}
	public String getSchoolsMajorConcerns() {
		return SchoolsMajorConcerns;
	}
	public void setSchoolsMajorConcerns(String schoolsMajorConcerns) {
		SchoolsMajorConcerns = schoolsMajorConcerns;
	}
	public String getLearningAndTeachingStrategies() {
		return LearningAndTeachingStrategies;
	}
	public void setLearningAndTeachingStrategies(
			String learningAndTeachingStrategies) {
		LearningAndTeachingStrategies = learningAndTeachingStrategies;
	}
	public String getDevelopmentofKeyTasks() {
		return DevelopmentofKeyTasks;
	}
	public void setDevelopmentofKeyTasks(String developmentofKeyTasks) {
		DevelopmentofKeyTasks = developmentofKeyTasks;
	}
	public String getDevelopmentofGenericSkills() {
		return DevelopmentofGenericSkills;
	}
	public void setDevelopmentofGenericSkills(String developmentofGenericSkills) {
		DevelopmentofGenericSkills = developmentofGenericSkills;
	}
	public String getWholeSchoolApproachtoCaterforStudentDiversity() {
		return WholeSchoolApproachtoCaterforStudentDiversity;
	}
	public void setWholeSchoolApproachtoCaterforStudentDiversity(
			String wholeSchoolApproachtoCaterforStudentDiversity) {
		WholeSchoolApproachtoCaterforStudentDiversity = wholeSchoolApproachtoCaterforStudentDiversity;
	}
	public String getCurriculumTailoringandAdaptation() {
		return CurriculumTailoringandAdaptation;
	}
	public void setCurriculumTailoringandAdaptation(
			String curriculumTailoringandAdaptation) {
		CurriculumTailoringandAdaptation = curriculumTailoringandAdaptation;
	}
	public String getHome_SchoolCo_operation() {
		return Home_SchoolCo_operation;
	}
	public void setHome_SchoolCo_operation(String home_SchoolCo_operation) {
		Home_SchoolCo_operation = home_SchoolCo_operation;
	}
	public String getSchoolEthos() {
		return SchoolEthos;
	}
	public void setSchoolEthos(String schoolEthos) {
		SchoolEthos = schoolEthos;
	}
	public String getSchoolDevelopmentPlan() {
		return SchoolDevelopmentPlan;
	}
	public void setSchoolDevelopmentPlan(String schoolDevelopmentPlan) {
		SchoolDevelopmentPlan = schoolDevelopmentPlan;
	}
	public String getTeacherProfessionalTrainingAndDevelopment() {
		return TeacherProfessionalTrainingAndDevelopment;
	}
	public void setTeacherProfessionalTrainingAndDevelopment(
			String teacherProfessionalTrainingAndDevelopment) {
		TeacherProfessionalTrainingAndDevelopment = teacherProfessionalTrainingAndDevelopment;
	}
	public String getFeeRemissionScheme() {
		return FeeRemissionScheme;
	}
	public void setFeeRemissionScheme(String feeRemissionScheme) {
		FeeRemissionScheme = feeRemissionScheme;
	}
	public String getOthers() {
		return Others;
	}
	public void setOthers(String others) {
		Others = others;
	}
	public String getSupervisorChairmanofManagementCommittee() {
		return supervisorChairmanofManagementCommittee;
	}
	public void setSupervisorChairmanofManagementCommittee(
			String supervisorChairmanofManagementCommittee) {
		this.supervisorChairmanofManagementCommittee = supervisorChairmanofManagementCommittee;
	}
	public String getIncorporatedCommittee() {
		return IncorporatedCommittee;
	}
	public void setIncorporatedCommittee(String incorporatedCommittee) {
		IncorporatedCommittee = incorporatedCommittee;
	}
	public String getNumberOfClassroom() {
		return numberOfClassroom;
	}
	public void setNumberOfClassroom(String numberOfClassroom) {
		this.numberOfClassroom = numberOfClassroom;
	}
	public String getFacilitySupportforStudentswithSpecialEducationalNeeds() {
		return facilitySupportforStudentswithSpecialEducationalNeeds;
	}
	public void setFacilitySupportforStudentswithSpecialEducationalNeeds(
			String facilitySupportforStudentswithSpecialEducationalNeeds) {
		this.facilitySupportforStudentswithSpecialEducationalNeeds = facilitySupportforStudentswithSpecialEducationalNeeds;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSchoolYear2013() {
		return schoolYear2013;
	}
	public void setSchoolYear2013(String schoolYear2013) {
		this.schoolYear2013 = schoolYear2013;
	}
	public String getSchoolTeachers2013() {
		return schoolTeachers2013;
	}
	public void setSchoolTeachers2013(String schoolTeachers2013) {
		this.schoolTeachers2013 = schoolTeachers2013;
	}
	public String getApprovalPreparation2013() {
		return approvalPreparation2013;
	}
	public void setApprovalPreparation2013(String approvalPreparation2013) {
		this.approvalPreparation2013 = approvalPreparation2013;
	}
	public String getTotal2013() {
		return total2013;
	}
	public void setTotal2013(String total2013) {
		this.total2013 = total2013;
	}
	public String getSmallOne2013() {
		return smallOne2013;
	}
	public void setSmallOne2013(String smallOne2013) {
		this.smallOne2013 = smallOne2013;
	}
	public String getSmallTwo2013() {
		return smallTwo2013;
	}
	public void setSmallTwo2013(String smallTwo2013) {
		this.smallTwo2013 = smallTwo2013;
	}
	public String getSmallThree2013() {
		return smallThree2013;
	}
	public void setSmallThree2013(String smallThree2013) {
		this.smallThree2013 = smallThree2013;
	}
	public String getSmallFour2013() {
		return smallFour2013;
	}
	public void setSmallFour2013(String smallFour2013) {
		this.smallFour2013 = smallFour2013;
	}
	public String getSmallFive2013() {
		return smallFive2013;
	}
	public void setSmallFive2013(String smallFive2013) {
		this.smallFive2013 = smallFive2013;
	}
	public String getLittleSix2013() {
		return littleSix2013;
	}
	public void setLittleSix2013(String littleSix2013) {
		this.littleSix2013 = littleSix2013;
	}
	public String getSchoolYear2014() {
		return schoolYear2014;
	}
	public void setSchoolYear2014(String schoolYear2014) {
		this.schoolYear2014 = schoolYear2014;
	}
	public String getSchoolTeachers2014() {
		return schoolTeachers2014;
	}
	public void setSchoolTeachers2014(String schoolTeachers2014) {
		this.schoolTeachers2014 = schoolTeachers2014;
	}
	public String getApprovalPreparation2014() {
		return approvalPreparation2014;
	}
	public void setApprovalPreparation2014(String approvalPreparation2014) {
		this.approvalPreparation2014 = approvalPreparation2014;
	}
	public String getTotal2014() {
		return total2014;
	}
	public void setTotal2014(String total2014) {
		this.total2014 = total2014;
	}
	public String getSmallOne2014() {
		return smallOne2014;
	}
	public void setSmallOne2014(String smallOne2014) {
		this.smallOne2014 = smallOne2014;
	}
	public String getSmallTwo2014() {
		return smallTwo2014;
	}
	public void setSmallTwo2014(String smallTwo2014) {
		this.smallTwo2014 = smallTwo2014;
	}
	public String getSmallThree2014() {
		return smallThree2014;
	}
	public void setSmallThree2014(String smallThree2014) {
		this.smallThree2014 = smallThree2014;
	}
	public String getSmallFour2014() {
		return smallFour2014;
	}
	public void setSmallFour2014(String smallFour2014) {
		this.smallFour2014 = smallFour2014;
	}
	public String getSmallfive2014() {
		return smallfive2014;
	}
	public void setSmallfive2014(String smallfive2014) {
		this.smallfive2014 = smallfive2014;
	}
	public String getLittlesix2014() {
		return littlesix2014;
	}
	public void setLittlesix2014(String littlesix2014) {
		this.littlesix2014 = littlesix2014;
	}
	public String getSchoolyear2015() {
		return schoolyear2015;
	}
	public void setSchoolyear2015(String schoolyear2015) {
		this.schoolyear2015 = schoolyear2015;
	}
	public String getSchoolTeachers2015() {
		return schoolTeachers2015;
	}
	public void setSchoolTeachers2015(String schoolTeachers2015) {
		this.schoolTeachers2015 = schoolTeachers2015;
	}
	public String getApprovalPreparation2015() {
		return approvalPreparation2015;
	}
	public void setApprovalPreparation2015(String approvalPreparation2015) {
		this.approvalPreparation2015 = approvalPreparation2015;
	}
	public String getTotal2015() {
		return total2015;
	}
	public void setTotal2015(String total2015) {
		this.total2015 = total2015;
	}
	public String getSmallOne2015() {
		return smallOne2015;
	}
	public void setSmallOne2015(String smallOne2015) {
		this.smallOne2015 = smallOne2015;
	}
	public String getSmallTwo2015() {
		return smallTwo2015;
	}
	public void setSmallTwo2015(String smallTwo2015) {
		this.smallTwo2015 = smallTwo2015;
	}
	public String getSmallThree2015() {
		return smallThree2015;
	}
	public void setSmallThree2015(String smallThree2015) {
		this.smallThree2015 = smallThree2015;
	}
	public String getSmallFour2015() {
		return smallFour2015;
	}
	public void setSmallFour2015(String smallFour2015) {
		this.smallFour2015 = smallFour2015;
	}
	public String getSmallfive2015() {
		return smallfive2015;
	}
	public void setSmallfive2015(String smallfive2015) {
		this.smallfive2015 = smallfive2015;
	}
	public String getLittlesix2015() {
		return littlesix2015;
	}
	public void setLittlesix2015(String littlesix2015) {
		this.littlesix2015 = littlesix2015;
	}
	public String getSchoolyear2016() {
		return schoolyear2016;
	}
	public void setSchoolyear2016(String schoolyear2016) {
		this.schoolyear2016 = schoolyear2016;
	}
	public String getSchoolTeachers2016() {
		return schoolTeachers2016;
	}
	public void setSchoolTeachers2016(String schoolTeachers2016) {
		this.schoolTeachers2016 = schoolTeachers2016;
	}
	public String getApprovalPreparation2016() {
		return approvalPreparation2016;
	}
	public void setApprovalPreparation2016(String approvalPreparation2016) {
		this.approvalPreparation2016 = approvalPreparation2016;
	}
	public String getTotal2016() {
		return total2016;
	}
	public void setTotal2016(String total2016) {
		this.total2016 = total2016;
	}
	public String getSmallOne2016() {
		return smallOne2016;
	}
	public void setSmallOne2016(String smallOne2016) {
		this.smallOne2016 = smallOne2016;
	}
	public String getSmallTwo2016() {
		return smallTwo2016;
	}
	public void setSmallTwo2016(String smallTwo2016) {
		this.smallTwo2016 = smallTwo2016;
	}
	public String getSmallThree2016() {
		return smallThree2016;
	}
	public void setSmallThree2016(String smallThree2016) {
		this.smallThree2016 = smallThree2016;
	}
	public String getSmallFour2016() {
		return smallFour2016;
	}
	public void setSmallFour2016(String smallFour2016) {
		this.smallFour2016 = smallFour2016;
	}
	public String getSmallfive2016() {
		return smallfive2016;
	}
	public void setSmallfive2016(String smallfive2016) {
		this.smallfive2016 = smallfive2016;
	}
	public String getLittlesix2016() {
		return littlesix2016;
	}
	public void setLittlesix2016(String littlesix2016) {
		this.littlesix2016 = littlesix2016;
	}
	public String getSchoolyear2017() {
		return schoolyear2017;
	}
	public void setSchoolyear2017(String schoolyear2017) {
		this.schoolyear2017 = schoolyear2017;
	}
	public String getSchoolTeachers2017() {
		return schoolTeachers2017;
	}
	public void setSchoolTeachers2017(String schoolTeachers2017) {
		this.schoolTeachers2017 = schoolTeachers2017;
	}
	public String getApprovalPreparation2017() {
		return approvalPreparation2017;
	}
	public void setApprovalPreparation2017(String approvalPreparation2017) {
		this.approvalPreparation2017 = approvalPreparation2017;
	}
	public String getTotal2017() {
		return total2017;
	}
	public void setTotal2017(String total2017) {
		this.total2017 = total2017;
	}
	public String getSmallOne2017() {
		return smallOne2017;
	}
	public void setSmallOne2017(String smallOne2017) {
		this.smallOne2017 = smallOne2017;
	}
	public String getSmallTwo2017() {
		return smallTwo2017;
	}
	public void setSmallTwo2017(String smallTwo2017) {
		this.smallTwo2017 = smallTwo2017;
	}
	public String getSmallThree2017() {
		return smallThree2017;
	}
	public void setSmallThree2017(String smallThree2017) {
		this.smallThree2017 = smallThree2017;
	}
	public String getSmallFour2017() {
		return smallFour2017;
	}
	public void setSmallFour2017(String smallFour2017) {
		this.smallFour2017 = smallFour2017;
	}
	public String getSmallfive2017() {
		return smallfive2017;
	}
	public void setSmallfive2017(String smallfive2017) {
		this.smallfive2017 = smallfive2017;
	}
	public String getLittlesix2017() {
		return littlesix2017;
	}
	public void setLittlesix2017(String littlesix2017) {
		this.littlesix2017 = littlesix2017;
	}
	public String getSchoolDiscritpion() {
		return schoolDiscritpion;
	}
	public void setSchoolDiscritpion(String schoolDiscritpion) {
		this.schoolDiscritpion = schoolDiscritpion;
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
		
	
}
