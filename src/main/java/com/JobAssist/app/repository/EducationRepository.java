package com.JobAssist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobAssist.app.entities.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {}

