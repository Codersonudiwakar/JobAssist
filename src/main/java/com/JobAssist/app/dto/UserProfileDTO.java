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
    private List<SkillDTO> skills;
    private List<CertificationDTO> certifications;

    // Getters and Setters
}
