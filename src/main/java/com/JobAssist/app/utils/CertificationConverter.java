package com.JobAssist.app.utils;

import com.JobAssist.app.dto.CertificationDTO;
import com.JobAssist.app.entities.Certification;
import com.JobAssist.app.entities.UserProfile;

public class CertificationConverter {

    public static CertificationDTO toDTO(Certification certification) {
        if (certification == null) return null;

        CertificationDTO dto = new CertificationDTO();
        dto.setId(certification.getId());
        dto.setName(certification.getName());
        dto.setOrganization(certification.getOrganization());
        dto.setIssueDate(certification.getIssueDate());
        dto.setExpiryDate(certification.getExpiryDate());

        // Map userId from UserProfile
        UserProfile user = certification.getUser();
        if (user != null) {
            dto.setUserId(user.getId());
        }

        return dto;
    }

    public static Certification toEntity(CertificationDTO dto) {
        if (dto == null) return null;

        Certification certification = new Certification();
        certification.setId(dto.getId());
        certification.setName(dto.getName());
        certification.setOrganization(dto.getOrganization());
        certification.setIssueDate(dto.getIssueDate());
        certification.setExpiryDate(dto.getExpiryDate());

        // Map UserProfile if userId exists
        if (dto.getUserId() != null) {
            UserProfile user = new UserProfile();
            user.setId(dto.getUserId());
            certification.setUser(user);
        }

        return certification;
    }
}

