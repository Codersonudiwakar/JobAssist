package com.JobAssist.app.dto;

import java.util.Date;
import java.util.List;

public class UserProfileDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location;
    private AddressDTO address;
    private List<EducationDTO> education;
    private List<ProjectDTO> projects;
    private List<WorkExperienceDTO> workExperiences;
    private List<UserSkillDTO> skills;
    private List<CertificationDTO> certifications;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public List<EducationDTO> getEducation() {
		return education;
	}
	public void setEducation(List<EducationDTO> education) {
		this.education = education;
	}
	public List<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
	public List<WorkExperienceDTO> getWorkExperiences() {
		return workExperiences;
	}
	public void setWorkExperiences(List<WorkExperienceDTO> workExperiences) {
		this.workExperiences = workExperiences;
	}
	public List<UserSkillDTO> getSkills() {
		return skills;
	}
	public void setSkills(List<UserSkillDTO> skills) {
		this.skills = skills;
	}
	public List<CertificationDTO> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<CertificationDTO> certifications) {
		this.certifications = certifications;
	}

    // Getters and Setters
}
