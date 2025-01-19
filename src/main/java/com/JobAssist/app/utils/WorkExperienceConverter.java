package com.JobAssist.app.utils;

import com.JobAssist.app.dto.WorkExperienceDTO;
import com.JobAssist.app.entities.WorkExperience;
import com.JobAssist.app.entities.UserProfile;

public class WorkExperienceConverter {

    public static WorkExperienceDTO toDTO(WorkExperience workExperience) {
        if (workExperience == null) return null;

        WorkExperienceDTO dto = new WorkExperienceDTO();
        dto.setId(workExperience.getId());
        dto.setCompanyName(workExperience.getCompanyName());
        dto.setJobTitle(workExperience.getJobTitle());
        dto.setLocation(workExperience.getLocation());
        dto.setStartDate(workExperience.getStartDate());
        dto.setEndDate(workExperience.getEndDate());
        dto.setDescription(workExperience.getDescription());

        // Map userId from UserProfile
        UserProfile user = workExperience.getUser();
        if (user != null) {
            dto.setUserId(user.getId());
        }

        return dto;
    }

    public static WorkExperience toEntity(WorkExperienceDTO dto) {
        if (dto == null) return null;

        WorkExperience workExperience = new WorkExperience();
        workExperience.setId(dto.getId());
        workExperience.setCompanyName(dto.getCompanyName());
        workExperience.setJobTitle(dto.getJobTitle());
        workExperience.setLocation(dto.getLocation());
        workExperience.setStartDate(dto.getStartDate());
        workExperience.setEndDate(dto.getEndDate());
        workExperience.setDescription(dto.getDescription());

        // Map UserProfile if userId exists
        if (dto.getUserId() != null) {
            UserProfile user = new UserProfile();
            user.setId(dto.getUserId());
            workExperience.setUser(user);
        }

        return workExperience;
    }
}
