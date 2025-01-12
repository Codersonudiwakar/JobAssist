package com.JobAssist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobAssist.app.entities.UserSkills;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkills, Long> {}
