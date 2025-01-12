package com.JobAssist.app.utils;

import com.JobAssist.app.dto.SkillDTO;
import com.JobAssist.app.entities.Skill;

public class SkillConverter {

    public static SkillDTO toDTO(Skill skill) {
        if (skill == null) return null;

        SkillDTO dto = new SkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setProficiency(skill.getProficiency());

        return dto;
    }

    public static Skill toEntity(SkillDTO dto) {
        if (dto == null) return null;

        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setProficiency(dto.getProficiency());

        return skill;
    }
}
