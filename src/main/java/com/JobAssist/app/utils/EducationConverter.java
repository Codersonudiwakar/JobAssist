package com.JobAssist.app.utils;

import com.JobAssist.app.dto.EducationDTO;
import com.JobAssist.app.entities.Education;
import com.JobAssist.app.entities.UserProfile;

public class EducationConverter {

    public static EducationDTO toDTO(Education education) {
        if (education == null) return null;

        EducationDTO dto = new EducationDTO();
        dto.setId(education.getId());
        dto.setDegree(education.getDegree());
        dto.setFieldOfStudy(education.getFieldOfStudy());
        dto.setUniversity(education.getUniversity());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        dto.setGrade(education.getGrade());

        // Map userId from UserProfile
        UserProfile user = education.getUser();
        if (user != null) {
            dto.setUserId(user.getId());
        }

        return dto;
    }

    public static Education toEntity(EducationDTO dto) {
        if (dto == null) return null;

        Education education = new Education();
        education.setId(dto.getId());
        education.setDegree(dto.getDegree());
        education.setFieldOfStudy(dto.getFieldOfStudy());
        education.setUniversity(dto.getUniversity());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        education.setGrade(dto.getGrade());

        // Map UserProfile if userId exists
        if (dto.getUserId() != null) {
            UserProfile user = new UserProfile();
            user.setId(dto.getUserId());
            education.setUser(user);
        }

        return education;
    }
}

