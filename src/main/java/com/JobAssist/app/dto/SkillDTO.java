package com.JobAssist.app.dto;

public class SkillDTO {
    private Long id;
    private String skillName;

    // Constructors
    public SkillDTO() {}

    public SkillDTO(Long id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
