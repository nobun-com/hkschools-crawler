
package com.hkschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="secondary_School")
public class SSEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long id;
    
    @Column(name="imageTop")
	@Lob
	String imageTop;

    @Column(name="image")
	@Lob
    String image;
    
    @Column(name="schoolCategouryTitle")
	@Lob
    String schoolCategouryTitle;

    @Column(name="schoolHistoryTitle")
	@Lob
    String schoolHistoryTitle;
	
    @Column(name="teachingSituationTitle")
	@Lob
    String teachingSituationTitle;
    
    @Column(name="schoolYear2013")
	@Lob
    String schoolYear2013;
	
    @Column(name="schoolTeachers2013")
	@Lob
    String schoolTeachers2013;
	
    @Column(name="approvalPreparation2013")
	@Lob
    String approvalPreparation2013;
	
    @Column(name="total2013")
	@Lob
    String total2013;
	
    @Column(name="smallOne2013")
	@Lob
    String smallOne2013;
	
    @Column(name="smallTwo2013")
	@Lob
    String smallTwo2013;
	
    @Column(name="smallThree2013")
	@Lob
    String smallThree2013;
	
    @Column(name="smallFour2013")
	@Lob
    String smallFour2013;
	
    @Column(name="smallFive2013")
	@Lob
    String smallFive2013;
	
    @Column(name="littleSix2013")
	@Lob
    String littleSix2013;
	
    @Column(name="schoolYear2014")
	@Lob
    String schoolYear2014;
	
    @Column(name="schoolTeachers2014")
	@Lob
    String schoolTeachers2014;
	
    @Column(name="approvalPreparation2014")
	@Lob
    String approvalPreparation2014;

    @Column(name="total2014")
	@Lob
    String total2014;
	
    @Column(name="smallOne2014")
	@Lob
    String smallOne2014;
	
    @Column(name="smallTwo2014")
	@Lob
    String smallTwo2014;
	
    @Column(name="smallThree2014")
	@Lob
    String smallThree2014;
	
    @Column(name="smallFour2014")
	@Lob
    String smallFour2014;
	
    @Column(name="smallfive2014")
	@Lob
    String smallfive2014;
	
    @Column(name="littlesix2014")
	@Lob
    String littlesix2014;
	
    @Column(name="schoolyear2015")
	@Lob
    String schoolyear2015;
	
    @Column(name="schoolTeachers2015")
	@Lob
    String schoolTeachers2015;
	
    @Column(name="approvalPreparation2015")
	@Lob
    String approvalPreparation2015;
	
    @Column(name="total2015")
	@Lob
    String total2015;
	
    @Column(name="smallOne2015")
	@Lob
    String smallOne2015;
	
    @Column(name="smallTwo2015")
	@Lob
    String smallTwo2015;
	
    @Column(name="smallThree2015")
	@Lob
    String smallThree2015;
	
    @Column(name="smallFour2015")
	@Lob
    String smallFour2015;
	
    @Column(name="smallfive2015")
	@Lob
    String smallfive2015;
	
    @Column(name="littlesix2015")
	@Lob
    String littlesix2015;
	
    @Column(name="schoolyear2016")
	@Lob
    String schoolyear2016;
	
    @Column(name="schoolTeachers2016")
	@Lob
    String schoolTeachers2016;
	
    @Column(name="approvalPreparation2016")
	@Lob
    String approvalPreparation2016;
	
    @Column(name="total2016")
	@Lob
	String total2016;
	
    @Column(name="smallOne2016")
	@Lob
    String smallOne2016;
	
    @Column(name="smallTwo2016")
	@Lob
    String smallTwo2016;
	
    @Column(name="smallThree2016")
	@Lob
    String smallThree2016;
	
    @Column(name="smallFour2016")
	@Lob
    String smallFour2016;
	
    @Column(name="smallfive2016")
	@Lob
    String smallfive2016;
	
    @Column(name="littlesix2016")
	@Lob
    String littlesix2016;
	
    @Column(name="schoolyear2017")
	@Lob
    String schoolyear2017;
	
    @Column(name="schoolTeachers2017")
	@Lob
    String schoolTeachers2017;
	
    @Column(name="approvalPreparation2017")
	@Lob
    String approvalPreparation2017;
	
    @Column(name="total2017")
	@Lob
    String total2017;

    @Column(name="smallOne2017")
	@Lob
    String smallOne2017;
	
    @Column(name="smallTwo2017")
	@Lob
    String smallTwo2017;
	
    @Column(name="smallThree2017")
	@Lob
    String smallThree2017;
	
    @Column(name="smallFour2017")
	@Lob
    String smallFour2017;
	
    @Column(name="smallfive2017")
	@Lob
    String smallfive2017;

    @Column(name="littlesix2017")
	@Lob
    String littlesix2017;
	
    @Column(name="schoolDiscritpion")
	@Lob
    String schoolDiscritpion;
	
    @Column(name="schoolHistory")
	@Lob
    String schoolHistory;
	
    @Column(name="teachingSituation")
	@Lob
    String teachingSituation;
    
    @Column(name="schoolCategory")
	@Lob
    String schoolCategory;
    
    
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
	
	@Column(name="fax")
	@Lob
	String fax;
	
	@Column(name="schoolEmail")
	@Lob
	String schoolEmail;
	
	@Column(name="schoolId")
	@Lob
	String schoolId;
	
	@Column(name="schoolName")
	@Lob
	String schoolName;
	
	@Column(name="schoolWebsite")
	@Lob
	String schoolWebsite;

	@Column(name="source")
	@Lob
	String source;
	
	@Column(name="tel")
	@Lob
	String tel;
	
	@Column(name="Numberofteachingpostsintheapprovedestablishment")
	@Lob
    String Numberofteachingpostsintheapprovedestablishment;
	
	@Column(name="Totalnumberofteachersintheschool")
	@Lob
	String Totalnumberofteachersintheschool;
	
	@Column(name="QualificationsandProfessionalTraining")
	@Lob
	String QualificationsandProfessionalTraining;
	
	@Column(name="TeacherCertificate_DiplomainEducation")
	@Lob
	String TeacherCertificate_DiplomainEducation ;
	
	@Column(name="BachelorDegree")
	@Lob
	String BachelorDegree;
	
	@Column(name="Master_DoctorateDegreeorabove")
	@Lob
	String Master_DoctorateDegreeorabove;
	
	@Column(name="SpecialEducationTraining")
	@Lob
	String SpecialEducationTraining;
	
	@Column(name="WorkingExperiences")
	@Lob
	String WorkingExperiences ;
	
	@Column(name="WorkingExperiences0_4years")
	@Lob
	String WorkingExperiences0_4years ;
	
	@Column(name="WorkingExperiences5_9years")
	@Lob
	String WorkingExperiences5_9years;
	
	@Column(name="WorkingExperiences10yearsorabove")
	@Lob
	String WorkingExperiences10yearsorabove;
	
	@Column(name="SchoolFeeS1")
	@Lob
	String SchoolFeeS1;
	
	@Column(name="TongFaiS1")
	@Lob
	String TongFaiS1;
	
	@Column(name="SchoolFeeS2")
	@Lob
	String SchoolFeeS2;
	
	@Column(name="TongFaiS2")
	@Lob
	String TongFaiS2;
	
	@Column(name="SchoolFeeS3")
	@Lob
	String SchoolFeeS3;
	
	@Column(name="TongFaiS3")
	@Lob
	String TongFaiS3;
	
	@Column(name="SchoolFeeS4")
	@Lob
	String SchoolFeeS4	;
	
	@Column(name="TongFaiS4")
	@Lob
	String TongFaiS4;
	
	@Column(name="SchoolFeeS5")
	@Lob
	String SchoolFeeS5;
	
	@Column(name="TongFaiS5")
	@Lob
	String TongFaiS5;
	
	@Column(name="SchoolFeeS6")
	@Lob
	String SchoolFeeS6;
	
	@Column(name="TongFaiS6")
	@Lob
	String TongFaiS6;
	
	@Column(name="Parent_TeacherAssociationFee")
	@Lob
	String Parent_TeacherAssociationFee;
	
	@Column(name="Incidentals")
	@Lob
	String Incidentals;
	
	@Column(name="StudentsAssociationMembershipFee")
	@Lob
	String StudentsAssociationMembershipFee;
	
	@Column(name="ChargesforSpecificPurposes")
	@Lob
	String ChargesforSpecificPurposes;
	
	@Column(name="OtherCharges")
	@Lob
	String OtherCharges;

	@Column(name="OtherDistrict")
	@Lob
	String OtherDistrict;
	
	@Column(name="Supervisor_ChairmanofSchoolManagementCommittee")
	@Lob
	String Supervisor_ChairmanofSchoolManagementCommittee;
	
	@Column(name="Principal")
	@Lob
	String Principal;
	
	@Column(name="SchoolType")
	@Lob
	String SchoolType;
	
	@Column(name="StudentGender")
	@Lob
	String StudentGender;
	
	@Column(name="SchoolSize")
	@Lob
	String SchoolSize;
	
	@Column(name="SponsoringBody")
	@Lob
	String SponsoringBody;
	
	@Column(name="IncorporatedManagementCommittee")
	@Lob
	String IncorporatedManagementCommittee;
	
	@Column(name="Religion")
	@Lob
	String Religion;
	
	@Column(name="YearofCommencementofOperation")
	@Lob
	String YearofCommencementofOperation;
	
	@Column(name="SchoolMotto")
	@Lob
	String SchoolMotto;
	
	@Column(name="Parent_TeacherAssociation")
	@Lob
	String Parent_TeacherAssociation;
	
	@Column(name="StudentUnion_Association")
	@Lob
	String StudentUnion_Association;
	
	@Column(name="PastStudentsAssociation_SchoolAlumniAssociation")
	@Lob
	String PastStudentsAssociation_SchoolAlumniAssociation;
	
	@Column(name="SchoolFacilities")
	@Lob
	String SchoolFacilities;
	
	@Column(name="FacilityforSupportingStudentswithSpecialEducationalNeeds")
	@Lob
	String FacilityforSupportingStudentswithSpecialEducationalNeeds;
	
	@Column(name="SecondaryOneAdmission")
	@Lob
	String SecondaryOneAdmission;
	
	@Column(name="OrientationActivitiesandHealthyLife")
	@Lob
	String OrientationActivitiesandHealthyLife;
	
	@Column(name="SubjectsOfferedin2017_2018SchoolYear")
	@Lob
	String SubjectsOfferedin2017_2018SchoolYear;
	
	@Column(name="Chineseasthemediumofinstruction")
	@Lob
	String Chineseasthemediumofinstruction;
	
	@Column(name="Englishasthemediumofinstruction")
	@Lob
	String Englishasthemediumofinstruction;
	
	@Column(name="Usebygroup")
	@Lob
	String Usebygroup;
	
	@Column(name="SubjectsOfferedin2017And2018SchoolYear")
	@Lob
	String SubjectsOfferedin2017And2018SchoolYear;
	
	@Column(name="Chineseasthemediumofinstruction0")
	@Lob
	String Chineseasthemediumofinstruction0;
	
	@Column(name="Englishasthemediumofinstruction0")
	@Lob
	String Englishasthemediumofinstruction0;
	
	@Column(name="Usebygroup0")
	@Lob
	String Usebygroup0;
	
	@Column(name="SubjectstobeOfferedin2018_2019SchoolYear")
	@Lob
	String SubjectstobeOfferedin2018_2019SchoolYear;
	
	@Column(name="Chineseasthemediumofinstruction1")
	@Lob
	String Chineseasthemediumofinstruction1;
	
	@Column(name="Englishasthemediumofinstruction1")
	@Lob
	String Englishasthemediumofinstruction1;
	
	@Column(name="Usebygroup1")
	@Lob
	String Usebygroup1;
	
	@Column(name="SubjectstobeOfferedin2018And2019SchoolYear")
	@Lob
	String SubjectstobeOfferedin2018And2019SchoolYear;
	
	@Column(name="Chineseasthemediumofinstruction2")
	@Lob
	String Chineseasthemediumofinstruction2;
	
	@Column(name="Englishasthemediumofinstruction2")
	@Lob
	String Englishasthemediumofinstruction2;
	
	@Column(name="Usebygroup2")
	@Lob
	String Usebygroup2;
	
	@Column(name="SubjectOfferedin2017_2018SchoolYear")
	@Lob
	String SubjectOfferedin2017_2018SchoolYear;
	
	@Column(name="SchoolsKeyConcerns")
	@Lob
	String SchoolsKeyConcerns;
	
	@Column(name="SchoolManagementOrganisation")
	@Lob
	String SchoolManagementOrganisation;
	
	@Column(name="IncorporatedManagementCommittee_SchoolManagement")
	@Lob
	String IncorporatedManagementCommittee_SchoolManagement;
	
	@Column(name="SchoolGreenPolicy")
	@Lob
	String SchoolGreenPolicy;
	
	@Column(name="Whole_schoolLanguagePolicy")
	@Lob
	String Whole_schoolLanguagePolicy;
	
	@Column(name="LearningAndTeachingStrategies")
	@Lob
	String LearningAndTeachingStrategies;
	
	@Column(name="School_basedcurriculum")
	@Lob
	String School_basedcurriculum;
	
	@Column(name="CareerandLifePlanning")
	@Lob
	String CareerandLifePlanning;
	
	@Column(name="KeyLearningAreas")
	@Lob
	String KeyLearningAreas;
	
	@Column(name="WholeSchoolApproachtoCaterforStudentDiversity")
	@Lob
	String WholeSchoolApproachtoCaterforStudentDiversity;
	
	@Column(name="LearningandAssessment")
	@Lob
	String LearningandAssessment;
	
	@Column(name="SchoolFeeRemission")
	@Lob
	String SchoolFeeRemission;
	
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
	
	@Column(name="Extra_curricular_Co_curricularActivities")
	@Lob
	String Extra_curricular_Co_curricularActivities;
	
	@Column(name="Others")
	@Lob
	String Others;
	
	@Column(name="DirectpublictransportationtoSchool")
	@Lob
	String DirectpublictransportationtoSchool;
	
	@Column(name="Remarks")
	@Lob
	String Remarks;

	
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
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getSchoolEmail() {
		return schoolEmail;
	}
	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
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


	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSchoolFacilities() {
		return SchoolFacilities;
	}
	public void setSchoolFacilities(String schoolFacilities) {
		SchoolFacilities = schoolFacilities;
	}
	public String getFacilityforSupportingStudentswithSpecialEducationalNeeds() {
		return FacilityforSupportingStudentswithSpecialEducationalNeeds;
	}
	public void setFacilityforSupportingStudentswithSpecialEducationalNeeds(
			String facilityforSupportingStudentswithSpecialEducationalNeeds) {
		FacilityforSupportingStudentswithSpecialEducationalNeeds = facilityforSupportingStudentswithSpecialEducationalNeeds;
	}
	
	public String getSecondaryOneAdmission() {
		return SecondaryOneAdmission;
	}
	public void setSecondaryOneAdmission(String secondaryOneAdmission) {
		SecondaryOneAdmission = secondaryOneAdmission;
	}
	public String getOrientationActivitiesandHealthyLife() {
		return OrientationActivitiesandHealthyLife;
	}
	public void setOrientationActivitiesandHealthyLife(
			String orientationActivitiesandHealthyLife) {
		OrientationActivitiesandHealthyLife = orientationActivitiesandHealthyLife;
	}
	public String getSubjectsOfferedin2017_2018SchoolYear() {
		return SubjectsOfferedin2017_2018SchoolYear;
	}
	public void setSubjectsOfferedin2017_2018SchoolYear(
			String subjectsOfferedin2017_2018SchoolYear) {
		SubjectsOfferedin2017_2018SchoolYear = subjectsOfferedin2017_2018SchoolYear;
	}
	public String getChineseasthemediumofinstruction() {
		return Chineseasthemediumofinstruction;
	}
	public void setChineseasthemediumofinstruction(
			String chineseasthemediumofinstruction) {
		Chineseasthemediumofinstruction = chineseasthemediumofinstruction;
	}
	public String getEnglishasthemediumofinstruction() {
		return Englishasthemediumofinstruction;
	}
	public void setEnglishasthemediumofinstruction(
			String englishasthemediumofinstruction) {
		Englishasthemediumofinstruction = englishasthemediumofinstruction;
	}
	public String getUsebygroup() {
		return Usebygroup;
	}
	public void setUsebygroup(
			String usebygroup) {
		Usebygroup = usebygroup;
	}
	public String getSubjectsOfferedin2017And2018SchoolYear() {
		return SubjectsOfferedin2017And2018SchoolYear;
	}
	public void setSubjectsOfferedin2017And2018SchoolYear(
			String subjectsOfferedin2017And2018SchoolYear) {
		SubjectsOfferedin2017And2018SchoolYear = subjectsOfferedin2017And2018SchoolYear;
	}
	public String getChineseasthemediumofinstruction0() {
		return Chineseasthemediumofinstruction0;
	}
	public void setChineseasthemediumofinstruction0(
			String chineseasthemediumofinstruction0) {
		Chineseasthemediumofinstruction0 = chineseasthemediumofinstruction0;
	}
	public String getEnglishasthemediumofinstruction0() {
		return Englishasthemediumofinstruction0;
	}
	public void setEnglishasthemediumofinstruction0(
			String englishasthemediumofinstruction0) {
		Englishasthemediumofinstruction0 = englishasthemediumofinstruction0;
	}
	
	public String getSubjectstobeOfferedin2018_2019SchoolYear() {
		return SubjectstobeOfferedin2018_2019SchoolYear;
	}
	public void setSubjectstobeOfferedin2018_2019SchoolYear1(
			String subjectstobeOfferedin2018_2019SchoolYear) {
		SubjectstobeOfferedin2018_2019SchoolYear = subjectstobeOfferedin2018_2019SchoolYear;
	}
	public String getChineseasthemediumofinstruction1() {
		return Chineseasthemediumofinstruction1;
	}
	public void setChineseasthemediumofinstruction1(
			String chineseasthemediumofinstruction1) {
		Chineseasthemediumofinstruction1 = chineseasthemediumofinstruction1;
	}
	public String getEnglishasthemediumofinstruction1() {
		return Englishasthemediumofinstruction1;
	}
	public void setEnglishasthemediumofinstruction1(
			String englishasthemediumofinstruction1) {
		Englishasthemediumofinstruction1 = englishasthemediumofinstruction1;
	}
	public String getUsebygroup1() {
		return Usebygroup1;
	}
	public void setUsebygroup1(
			String usebygroup1) {
		Usebygroup1 = usebygroup1;
	}
	public String getSubjectstobeOfferedin2018And2019SchoolYear() {
		return SubjectstobeOfferedin2018And2019SchoolYear;
	}
	public void setSubjectstobeOfferedin2018And2019SchoolYear(
			String subjectstobeOfferedin2018And2019SchoolYear) {
		SubjectstobeOfferedin2018And2019SchoolYear = subjectstobeOfferedin2018And2019SchoolYear;
	}
	public String getChineseasthemediumofinstruction2() {
		return Chineseasthemediumofinstruction2;
	}
	public void setChineseasthemediumofinstruction2(
			String chineseasthemediumofinstruction2) {
		Chineseasthemediumofinstruction2 = chineseasthemediumofinstruction2;
	}
	public String getEnglishasthemediumofinstruction2() {
		return Englishasthemediumofinstruction2;
	}
	public void setEnglishasthemediumofinstruction2(
			String englishasthemediumofinstruction2) {
		Englishasthemediumofinstruction2 = englishasthemediumofinstruction2;
	}
	public String getUsebygroup0() {
		return Usebygroup0;
	}
	public void setUsebygroup0(String usebygroup0) {
		Usebygroup0 = usebygroup0;
	}
	public String getUsebygroup2() {
		return Usebygroup2;
	}
	public void setUsebygroup2(String usebygroup2) {
		Usebygroup2 = usebygroup2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOtherDistrict() {
		return OtherDistrict;
	}
	public void setOtherDistrict(String otherDistrict) {
		OtherDistrict = otherDistrict;
	}
	public String getSupervisor_ChairmanofSchoolManagementCommittee() {
		return Supervisor_ChairmanofSchoolManagementCommittee;
	}
	public void setSupervisor_ChairmanofSchoolManagementCommittee(
			String supervisor_ChairmanofSchoolManagementCommittee) {
		Supervisor_ChairmanofSchoolManagementCommittee = supervisor_ChairmanofSchoolManagementCommittee;
	}
	public String getPrincipal() {
		return Principal;
	}
	public void setPrincipal(String principal) {
		Principal = principal;
	}
	public String getSchoolType() {
		return SchoolType;
	}
	public void setSchoolType(String schoolType) {
		SchoolType = schoolType;
	}
	public String getStudentGender() {
		return StudentGender;
	}
	public void setStudentGender(String studentGender) {
		StudentGender = studentGender;
	}
	public String getSchoolSize() {
		return SchoolSize;
	}
	public void setSchoolSize(String schoolSize) {
		SchoolSize = schoolSize;
	}
	public String getSponsoringBody() {
		return SponsoringBody;
	}
	public void setSponsoringBody(String sponsoringBody) {
		SponsoringBody = sponsoringBody;
	}
	public String getIncorporatedManagementCommittee() {
		return IncorporatedManagementCommittee;
	}
	public void setIncorporatedManagementCommittee(
			String incorporatedManagementCommittee) {
		IncorporatedManagementCommittee = incorporatedManagementCommittee;
	}
	public String getSchoolMotto() {
		return SchoolMotto;
	}
	public void setSchoolMotto(String schoolMotto) {
		SchoolMotto = schoolMotto;
	}
	public String getParent_TeacherAssociation() {
		return Parent_TeacherAssociation;
	}
	public void setParent_TeacherAssociation(String parent_TeacherAssociation) {
		Parent_TeacherAssociation = parent_TeacherAssociation;
	}
	public String getStudentUnion_Association() {
		return StudentUnion_Association;
	}
	public void setStudentUnion_Association(String studentUnion_Association) {
		StudentUnion_Association = studentUnion_Association;
	}
	public String getPastStudentsAssociation_SchoolAlumniAssociation() {
		return PastStudentsAssociation_SchoolAlumniAssociation;
	}
	public void setPastStudentsAssociation_SchoolAlumniAssociation(
			String pastStudentsAssociation_SchoolAlumniAssociation) {
		PastStudentsAssociation_SchoolAlumniAssociation = pastStudentsAssociation_SchoolAlumniAssociation;
	}
	public String getReligion() {
		return Religion;
	}
	public void setReligion(String religion) {
		Religion = religion;
	}
	public String getYearofCommencementofOperation() {
		return YearofCommencementofOperation;
	}
	public void setYearofCommencementofOperation(
			String yearofCommencementofOperation) {
		YearofCommencementofOperation = yearofCommencementofOperation;
	}
	public String getSchoolFeeS1() {
		return SchoolFeeS1;
	}
	public void setSchoolFeeS1(String schoolFeeS1) {
		SchoolFeeS1 = schoolFeeS1;
	}
	public String getTongFaiS1() {
		return TongFaiS1;
	}
	public void setTongFaiS1(String tongFaiS1) {
		TongFaiS1 = tongFaiS1;
	}
	public String getSchoolFeeS2() {
		return SchoolFeeS2;
	}
	public void setSchoolFeeS2(String schoolFeeS2) {
		SchoolFeeS2 = schoolFeeS2;
	}
	public String getTongFaiS2() {
		return TongFaiS2;
	}
	public void setTongFaiS2(String tongFaiS2) {
		TongFaiS2 = tongFaiS2;
	}
	public String getSchoolFeeS3() {
		return SchoolFeeS3;
	}
	public void setSchoolFeeS3(String schoolFeeS3) {
		SchoolFeeS3 = schoolFeeS3;
	}
	public String getTongFaiS3() {
		return TongFaiS3;
	}
	public void setTongFaiS3(String tongFaiS3) {
		TongFaiS3 = tongFaiS3;
	}
	public String getSchoolFeeS4() {
		return SchoolFeeS4;
	}
	public void setSchoolFeeS4(String schoolFeeS4) {
		SchoolFeeS4 = schoolFeeS4;
	}
	public String getTongFaiS4() {
		return TongFaiS4;
	}
	public void setTongFaiS4(String tongFaiS4) {
		TongFaiS4 = tongFaiS4;
	}
	public String getSchoolFeeS5() {
		return SchoolFeeS5;
	}
	public void setSchoolFeeS5(String schoolFeeS5) {
		SchoolFeeS5 = schoolFeeS5;
	}
	public String getTongFaiS5() {
		return TongFaiS5;
	}
	public void setTongFaiS5(String tongFaiS5) {
		TongFaiS5 = tongFaiS5;
	}
	public String getSchoolFeeS6() {
		return SchoolFeeS6;
	}
	public void setSchoolFeeS6(String schoolFeeS6) {
		SchoolFeeS6 = schoolFeeS6;
	}
	public String getTongFaiS6() {
		return TongFaiS6;
	}
	public void setTongFaiS6(String tongFaiS6) {
		TongFaiS6 = tongFaiS6;
	}
	public String getParent_TeacherAssociationFee() {
		return Parent_TeacherAssociationFee;
	}
	public void setParent_TeacherAssociationFee(String parent_TeacherAssociationFee) {
		Parent_TeacherAssociationFee = parent_TeacherAssociationFee;
	}
	public String getIncidentals() {
		return Incidentals;
	}
	public void setIncidentals(String incidentals) {
		Incidentals = incidentals;
	}
	public String getStudentsAssociationMembershipFee() {
		return StudentsAssociationMembershipFee;
	}
	public void setStudentsAssociationMembershipFee(
			String studentsAssociationMembershipFee) {
		StudentsAssociationMembershipFee = studentsAssociationMembershipFee;
	}
	public String getChargesforSpecificPurposes() {
		return ChargesforSpecificPurposes;
	}
	public void setChargesforSpecificPurposes(String chargesforSpecificPurposes) {
		ChargesforSpecificPurposes = chargesforSpecificPurposes;
	}
	public String getOtherCharges() {
		return OtherCharges;
	}
	public void setOtherCharges(String otherCharges) {
		OtherCharges = otherCharges;
	}
	public String getNumberofteachingpostsintheapprovedestablishment() {
		return Numberofteachingpostsintheapprovedestablishment;
	}
	public void setNumberofteachingpostsintheapprovedestablishment(
			String numberofteachingpostsintheapprovedestablishment) {
		Numberofteachingpostsintheapprovedestablishment = numberofteachingpostsintheapprovedestablishment;
	}
	public String getTotalnumberofteachersintheschool() {
		return Totalnumberofteachersintheschool;
	}
	public void setTotalnumberofteachersintheschool(
			String totalnumberofteachersintheschool) {
		Totalnumberofteachersintheschool = totalnumberofteachersintheschool;
	}
	public String getQualificationsandProfessionalTraining() {
		return QualificationsandProfessionalTraining;
	}
	public void setQualificationsandProfessionalTraining(
			String qualificationsandProfessionalTraining) {
		QualificationsandProfessionalTraining = qualificationsandProfessionalTraining;
	}
	public String getTeacherCertificate_DiplomainEducation() {
		return TeacherCertificate_DiplomainEducation;
	}
	public void setTeacherCertificate_DiplomainEducation(
			String teacherCertificate_DiplomainEducation) {
		TeacherCertificate_DiplomainEducation = teacherCertificate_DiplomainEducation;
	}
	public String getBachelorDegree() {
		return BachelorDegree;
	}
	public void setBachelorDegree(String bachelorDegree) {
		BachelorDegree = bachelorDegree;
	}
	public String getMaster_DoctorateDegreeorabove() {
		return Master_DoctorateDegreeorabove;
	}
	public void setMaster_DoctorateDegreeorabove(
			String master_DoctorateDegreeorabove) {
		Master_DoctorateDegreeorabove = master_DoctorateDegreeorabove;
	}
	public String getSpecialEducationTraining() {
		return SpecialEducationTraining;
	}
	public void setSpecialEducationTraining(String specialEducationTraining) {
		SpecialEducationTraining = specialEducationTraining;
	}
	public String getWorkingExperiences() {
		return WorkingExperiences;
	}
	public void setWorkingExperiences(String workingExperiences) {
		WorkingExperiences = workingExperiences;
	}
	public String getWorkingExperiences0_4years() {
		return WorkingExperiences0_4years;
	}
	public void setWorkingExperiences0_4years(String workingExperiences0_4years) {
		WorkingExperiences0_4years = workingExperiences0_4years;
	}
	public String getWorkingExperiences5_9years() {
		return WorkingExperiences5_9years;
	}
	public void setWorkingExperiences5_9years(String workingExperiences5_9years) {
		WorkingExperiences5_9years = workingExperiences5_9years;
	}
	public String getWorkingExperiences10yearsorabove() {
		return WorkingExperiences10yearsorabove;
	}
	public void setWorkingExperiences10yearsorabove(
			String workingExperiences10yearsorabove) {
		WorkingExperiences10yearsorabove = workingExperiences10yearsorabove;
	}
	public String getSubjectOfferedin2017_2018SchoolYear() {
		return SubjectOfferedin2017_2018SchoolYear;
	}
	public void setSubjectOfferedin2017_2018SchoolYear(
			String subjectOfferedin2017_2018SchoolYear) {
		SubjectOfferedin2017_2018SchoolYear = subjectOfferedin2017_2018SchoolYear;
	}
	public String getSchoolsKeyConcerns() {
		return SchoolsKeyConcerns;
	}
	public void setSchoolsKeyConcerns(String schoolsKeyConcerns) {
		SchoolsKeyConcerns = schoolsKeyConcerns;
	}
	public String getSchoolManagementOrganisation() {
		return SchoolManagementOrganisation;
	}
	public void setSchoolManagementOrganisation(String schoolManagementOrganisation) {
		SchoolManagementOrganisation = schoolManagementOrganisation;
	}
	public String getIncorporatedManagementCommittee_SchoolManagement() {
		return IncorporatedManagementCommittee_SchoolManagement;
	}
	public void setIncorporatedManagementCommittee_SchoolManagement(
			String incorporatedManagementCommittee_SchoolManagement) {
		IncorporatedManagementCommittee_SchoolManagement = incorporatedManagementCommittee_SchoolManagement;
	}
	public String getSchoolGreenPolicy() {
		return SchoolGreenPolicy;
	}
	public void setSchoolGreenPolicy(String schoolGreenPolicy) {
		SchoolGreenPolicy = schoolGreenPolicy;
	}
	public String getWhole_schoolLanguagePolicy() {
		return Whole_schoolLanguagePolicy;
	}
	public void setWhole_schoolLanguagePolicy(String whole_schoolLanguagePolicy) {
		Whole_schoolLanguagePolicy = whole_schoolLanguagePolicy;
	}
	public String getLearningAndTeachingStrategies() {
		return LearningAndTeachingStrategies;
	}
	public void setLearningAndTeachingStrategies(
			String learningAndTeachingStrategies) {
		LearningAndTeachingStrategies = learningAndTeachingStrategies;
	}
	public String getSchool_basedcurriculum() {
		return School_basedcurriculum;
	}
	public void setSchool_basedcurriculum(String school_basedcurriculum) {
		School_basedcurriculum = school_basedcurriculum;
	}
	public String getCareerandLifePlanning() {
		return CareerandLifePlanning;
	}
	public void setCareerandLifePlanning(String careerandLifePlanning) {
		CareerandLifePlanning = careerandLifePlanning;
	}
	public String getKeyLearningAreas() {
		return KeyLearningAreas;
	}
	public void setKeyLearningAreas(String keyLearningAreas) {
		KeyLearningAreas = keyLearningAreas;
	}
	public String getWholeSchoolApproachtoCaterforStudentDiversity() {
		return WholeSchoolApproachtoCaterforStudentDiversity;
	}
	public void setWholeSchoolApproachtoCaterforStudentDiversity(
			String wholeSchoolApproachtoCaterforStudentDiversity) {
		WholeSchoolApproachtoCaterforStudentDiversity = wholeSchoolApproachtoCaterforStudentDiversity;
	}
	public String getLearningandAssessment() {
		return LearningandAssessment;
	}
	public void setLearningandAssessment(String learningandAssessment) {
		LearningandAssessment = learningandAssessment;
	}
	public String getSchoolFeeRemission() {
		return SchoolFeeRemission;
	}
	public void setSchoolFeeRemission(String schoolFeeRemission) {
		SchoolFeeRemission = schoolFeeRemission;
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
	public String getExtra_curricular_Co_curricularActivities() {
		return Extra_curricular_Co_curricularActivities;
	}
	public void setExtra_curricular_Co_curricularActivities(
			String extra_curricular_Co_curricularActivities) {
		Extra_curricular_Co_curricularActivities = extra_curricular_Co_curricularActivities;
	}
	public String getOthers() {
		return Others;
	}
	public void setOthers(String others) {
		Others = others;
	}
	public String getDirectpublictransportationtoSchool() {
		return DirectpublictransportationtoSchool;
	}
	public void setDirectpublictransportationtoSchool(
			String directpublictransportationtoSchool) {
		DirectpublictransportationtoSchool = directpublictransportationtoSchool;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public void setSubjectstobeOfferedin2018_2019SchoolYear(
			String subjectstobeOfferedin2018_2019SchoolYear) {
		SubjectstobeOfferedin2018_2019SchoolYear = subjectstobeOfferedin2018_2019SchoolYear;
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
	public String getTeachingSituation() {
		return teachingSituation;
	}
	public void setTeachingSituation(String teachingSituation) {
		this.teachingSituation = teachingSituation;
	}
	public String getSchoolCategory() {
		return schoolCategory;
	}
	public void setSchoolCategory(String schoolCategory) {
		this.schoolCategory = schoolCategory;
	}
	public String getSchoolCategouryTitle() {
		return schoolCategouryTitle;
	}
	public void setSchoolCategouryTitle(String schoolCategouryTitle) {
		this.schoolCategouryTitle = schoolCategouryTitle;
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
	
	

