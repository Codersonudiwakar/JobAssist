package com.JobAssist.app.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name", nullable = false)
    private String skillName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

	public Skill(Long id, String skillName, Job job) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.job = job;
	}

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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

  
}
