package com.JobAssist.app.utils;


import com.JobAssist.app.entities.UserSkills;
import com.JobAssist.app.dto.UserSkillDTO;
import com.JobAssist.app.entities.UserProfile;

public class SkillConverter {

    public static UserSkillDTO toDTO(UserSkills skill) {
        if (skill == null) return null;

        UserSkillDTO dto = new UserSkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setProficiencyLevel(skill.getProficiencyLevel());
        return dto;
    }

    public static UserSkills toEntity(UserSkillDTO skillDTO) {
        if (skillDTO == null) return null;

        UserSkills skill = new UserSkills();
        skill.setId(skillDTO.getId());
        skill.setName(skillDTO.getName());
        skill.setProficiencyLevel(skillDTO.getProficiencyLevel());
        return skill;
    }
}

