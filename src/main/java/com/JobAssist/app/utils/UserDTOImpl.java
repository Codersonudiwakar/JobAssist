package com.JobAssist.app.utils;

import org.springframework.stereotype.Component;

import com.JobAssist.app.dto.UserProfileDTO;
import com.JobAssist.app.entities.UserProfile;

@Component
public class UserDTOImpl {

	
	public static UserProfileDTO toDTO(UserProfile userProfile) {
        if (userProfile == null) return null;

        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(userProfile.getId());
        dto.setFirstName(userProfile.getFirstName());
        dto.setLastName(userProfile.getLastName());
        dto.setEmail(userProfile.getEmail());
        dto.setPhoneNumber(userProfile.getPhoneNumber());
        dto.setLocation(userProfile.getLocation());
        dto.setAddress(AddressConverter.toDTO(userProfile.getAddress()));
        dto.setEducation(userProfile.getEducation()
                .stream()
                .map(EducationConverter::toDTO)
                .collect(Collectors.toList()));
        dto.setProjects(userProfile.getProjects()
                .stream()
                .map(ProjectConverter::toDTO)
                .collect(Collectors.toList()));
        dto.setWorkExperiences(userProfile.getWorkExperiences()
                .stream()
                .map(WorkExperienceConverter::toDTO)
                .collect(Collectors.toList()));
        dto.setSkills(userProfile.getSkills()
                .stream()
                .map(SkillConverter::toDTO)
                .collect(Collectors.toList()));
        dto.setCertifications(userProfile.getCertifications()
                .stream()
                .map(CertificationConverter::toDTO)
                .collect(Collectors.toList()));

        return dto;
    }

	

    public static UserProfile toEntity(UserProfileDTO dto) {
        if (dto == null) return null;

        UserProfile userProfile = new UserProfile();
        userProfile.setId(dto.getId());
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setLastName(dto.getLastName());
        userProfile.setEmail(dto.getEmail());
        userProfile.setPhoneNumber(dto.getPhoneNumber());
        userProfile.setLocation(dto.getLocation());
        userProfile.setAddress(AddressConverter.toEntity(dto.getAddress()));
        userProfile.setEducation(dto.getEducation()
                .stream()
                .map(EducationConverter::toEntity)
                .collect(Collectors.toList()));
        userProfile.setProjects(dto.getProjects()
                .stream()
                .map(ProjectConverter::toEntity)
                .collect(Collectors.toList()));
        userProfile.setWorkExperiences(dto.getWorkExperiences()
                .stream()
                .map(WorkExperienceConverter::toEntity)
                .collect(Collectors.toList()));
        userProfile.setSkills(dto.getSkills()
                .stream()
                .map(SkillConverter::toEntity)
                .collect(Collectors.toList()));
        userProfile.setCertifications(dto.getCertifications()
                .stream()
                .map(CertificationConverter::toEntity)
                .collect(Collectors.toList()));

        return userProfile;
    }
}
