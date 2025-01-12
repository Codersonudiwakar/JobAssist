package com.JobAssist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobAssist.app.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {}
