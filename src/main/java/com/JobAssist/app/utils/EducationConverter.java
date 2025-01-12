package com.JobAssist.app.utils;

import com.JobAssist.app.dto.EducationDTO;
import com.JobAssist.app.entities.Education;

public class EducationConverter {

    public static EducationDTO toDTO(Education education) {
        if (education == null) return null;

        EducationDTO dto = new EducationDTO();
        dto.setId(education.getId());
        dto.setDegree(education.getDegree());
        dto.setInstitution(education.getInstitution());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        dto.setGrade(education.getGrade());

        return dto;
    }

    public static Education toEntity(EducationDTO dto) {
        if (dto == null) return null;

        Education education = new Education();
        education.setId(dto.getId());
        education.setDegree(dto.getDegree());
        education.setInstitution(dto.getInstitution());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        education.setGrade(dto.getGrade());

        return education;
    }
}
