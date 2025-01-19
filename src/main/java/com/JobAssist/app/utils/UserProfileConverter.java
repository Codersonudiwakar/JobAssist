package com.JobAssist.app.utils;

import com.JobAssist.app.dto.*;
import com.JobAssist.app.entities.UserProfile;

import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;


@Configuration
public class UserProfileConverter {

    public static UserProfileDTO toDTO(UserProfile userProfile) {
        if (userProfile == null) return null;

        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(userProfile.getId());
        dto.setFirstName(userProfile.getFirstName());
        dto.setLastName(userProfile.getLastName());
        dto.setEmail(userProfile.getEmail());
        dto.setPhoneNumber(userProfile.getPhoneNumber());
        dto.setLocation(userProfile.getLocation());

        // Convert Address
        if (userProfile.getAddress() != null) {
            dto.setAddress(AddressConverter.toDTO(userProfile.getAddress()));
        }

        // Convert Lists
        if (userProfile.getEducation() != null) {
            dto.setEducation(userProfile.getEducation()
                    .stream()
                    .map(EducationConverter::toDTO)
                    .collect(Collectors.toList()));
        }
        if (userProfile.getProjects() != null) {
            dto.setProjects(userProfile.getProjects()
                    .stream()
                    .map(ProjectConverter::toDTO)
                    .collect(Collectors.toList()));
        }
        if (userProfile.getWorkExperiences() != null) {
            dto.setWorkExperiences(userProfile.getWorkExperiences()
                    .stream()
                    .map(WorkExperienceConverter::toDTO)
                    .collect(Collectors.toList()));
        }
        if (userProfile.getSkills() != null) {
            dto.setSkills(userProfile.getSkills()
                    .stream()
                    .map(SkillConverter::toDTO)
                    .collect(Collectors.toList()));
        }
        
        if (userProfile.getCertifications() != null) {
            dto.setCertifications(userProfile.getCertifications()
                    .stream()
                    .map(CertificationConverter::toDTO)
                    .collect(Collectors.toList()));
        }
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

        // Convert Address
        if (dto.getAddress() != null) {
            userProfile.setAddress(AddressConverter.toEntity(dto.getAddress()));
        }

        // Convert Lists
        if (dto.getEducation() != null) {
            userProfile.setEducation(dto.getEducation()
                    .stream()
                    .map(EducationConverter::toEntity)
                    .collect(Collectors.toList()));
        }
        if (dto.getProjects() != null) {
            userProfile.setProjects(dto.getProjects()
                    .stream()
                    .map(ProjectConverter::toEntity)
                    .collect(Collectors.toList()));
        }
        if (dto.getWorkExperiences() != null) {
            userProfile.setWorkExperiences(dto.getWorkExperiences()
                    .stream()
                    .map(WorkExperienceConverter::toEntity)
                    .collect(Collectors.toList()));
        }
        if (dto.getSkills() != null) {
            userProfile.setSkills(dto.getSkills()
                    .stream()
                    .map(SkillConverter::toEntity)
                    .collect(Collectors.toList()));
        }
        if (dto.getCertifications() != null) {
            userProfile.setCertifications(dto.getCertifications()
                    .stream()
                    .map(CertificationConverter::toEntity)
                    .collect(Collectors.toList()));
        }

        return userProfile;
    }
}
