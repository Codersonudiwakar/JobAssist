package com.JobAssist.app.repository;

import com.JobAssist.app.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    // Find skills by skill name
    List<Skill> findBySkillName(String skillName);

    // Custom query to find skills for a specific job ID
    @Query("SELECT s FROM Skill s WHERE s.job.id = :jobId")
    List<Skill> findSkillsByJobId(@Param("jobId") Long jobId);


    // Custom query to find all distinct skill names across jobs
    @Query("SELECT DISTINCT s.skillName FROM Skill s")
    List<String> findAllDistinctSkillNames();
}

