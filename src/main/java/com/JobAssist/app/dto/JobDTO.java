package com.JobAssist.app.dto;
import java.util.List;

public class JobDTO {
    private Long id;
    private String postName;
    private String companyName;
    private String jobDescription;
    private String workLocation;
    private List<SkillDTO> skills;
    private String jobResponsibilities;
    private String jobQualifications;
    private String jobExperience;

    public JobDTO() {}

    public JobDTO(Long id, String postName, String companyName, String jobDescription, String workLocation,
                  List<SkillDTO> skills, String jobResponsibilities, String jobQualifications, String jobExperience) {
        this.id = id;
        this.postName = postName;
        this.companyName = companyName;
        this.jobDescription = jobDescription;
        this.workLocation = workLocation;
        this.skills = skills;
        this.jobResponsibilities = jobResponsibilities;
        this.jobQualifications = jobQualifications;
        this.jobExperience = jobExperience;
    }

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

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
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
}

