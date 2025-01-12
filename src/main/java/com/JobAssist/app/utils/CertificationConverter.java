package com.JobAssist.app.utils;

import com.JobAssist.app.dto.CertificationDTO;
import com.JobAssist.app.entities.Certification;

public class CertificationConverter {

    public static CertificationDTO toDTO(Certification certification) {
        if (certification == null) return null;

        CertificationDTO dto = new CertificationDTO();
        dto.setId(certification.getId());
        dto.setName(certification.getName());
        dto.setIssuedBy(certification.getIssuedBy());
        dto.setIssueDate(certification.getIssueDate());

        return dto;
    }

    public static Certification toEntity(CertificationDTO dto) {
        if (dto == null) return null;

        Certification certification = new Certification();
        certification.setId(dto.getId());
        certification.setName(dto.getName());
        certification.setIssuedBy(dto.getIssuedBy());
        certification.setIssueDate(dto.getIssueDate());

        return certification;
    }
}
