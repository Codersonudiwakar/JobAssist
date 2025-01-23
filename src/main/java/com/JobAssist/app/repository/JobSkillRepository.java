package com.JobAssist.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JobAssist.app.entities.JobSkill;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {

    // Find skills by skill name
    List<JobSkill> findBySkillName(String skillName);

    // Custom query to find skills for a specific job ID
    @Query("SELECT js FROM JobSkill js WHERE js.job.id = :jobId")
    List<JobSkill> findSkillsByJobId(@Param("jobId") Long jobId);


    // Custom query to find all distinct skill names across jobs
    @Query("SELECT DISTINCT js.skillName FROM JobSkill js")
    List<String> findAllDistinctSkillNames();
}

