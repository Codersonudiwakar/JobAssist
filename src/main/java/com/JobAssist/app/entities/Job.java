package com.JobAssist.app.entities;

import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_name", nullable = false)
    private String postName;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "job_description", columnDefinition = "TEXT")
    private String jobDescription;

    @Column(name = "work_location")
    private String workLocation;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobSkill> skills = new ArrayList<>();


    @Column(name = "job_responsibilities", columnDefinition = "TEXT")
    private String jobResponsibilities;

    @Column(name = "job_qualifications", columnDefinition = "TEXT")
    private String jobQualifications;

    @Column(name = "job_experience")
    private String jobExperience;
    
    
    @Column(name = "job_apply_link")
    private String applyLink;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getWorkLocation() {
		return workLocation;
	}


	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}


	public List<JobSkill> getSkills() {
		return skills;
	}


	public void setSkills(List<JobSkill> skills) {
		this.skills = skills;
	}


	public String getJobResponsibilities() {
		return jobResponsibilities;
	}


	public void setJobResponsibilities(String jobResponsibilities) {
		this.jobResponsibilities = jobResponsibilities;
	}


	public String getJobQualifications() {
		return jobQualifications;
	}


	public void setJobQualifications(String jobQualifications) {
		this.jobQualifications = jobQualifications;
	}


	public String getJobExperience() {
		return jobExperience;
	}


	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}


	public String getApplyLink() {
		return applyLink;
	}


	public void setApplyLink(String applyLink) {
		this.applyLink = applyLink;
	}

   
}


