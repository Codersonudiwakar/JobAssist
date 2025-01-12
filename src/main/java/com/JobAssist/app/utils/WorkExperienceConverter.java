package com.JobAssist.app.utils;

import com.JobAssist.app.dto.WorkExperienceDTO;
import com.JobAssist.app.entities.WorkExperience;

public class WorkExperienceConverter {

    public static WorkExperienceDTO toDTO(WorkExperience workExperience) {
        if (workExperience == null) return null;

        WorkExperienceDTO dto = new WorkExperienceDTO();
        dto.setId(workExperience.getId());
        dto.setCompanyName(workExperience.getCompanyName());
        dto.setPosition(workExperience.getPosition());
        dto.setStartDate(workExperience.getStartDate());
        dto.setEndDate(workExperience.getEndDate());
        dto.setResponsibilities(workExperience.getResponsibilities());

        return dto;
    }

    public static WorkExperience toEntity(WorkExperienceDTO dto) {
        if (dto == null) return null;

        WorkExperience workExperience = new WorkExperience();
        workExperience.setId(dto.getId());
        workExperience.setCompanyName(dto.getCompanyName());
        workExperience.setPosition(dto.getPosition());
        workExperience.setStartDate(dto.getStartDate());
        workExperience.setEndDate(dto.getEndDate());
        workExperience.setResponsibilities(dto.getResponsibilities());

        return workExperience;
    }
}
