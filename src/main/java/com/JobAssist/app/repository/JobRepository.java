package com.JobAssist.app.repository;

import com.JobAssist.app.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    // Find jobs by company name
    List<Job> findByCompanyName(String companyName);

    // Find jobs by post name
    List<Job> findByPostName(String postName);

    // Find jobs containing specific keywords in job description
    List<Job> findByJobDescriptionContaining(String keyword);
    

    // Custom query to find jobs by location
    @Query("SELECT j FROM Job j WHERE j.workLocation = :location")
    List<Job> findJobsByLocation(@Param("location") String location);

    // Find jobs that require specific skills
    @Query("SELECT j FROM Job j JOIN j.skills s WHERE s.skillName = :skillName")
    List<Job> findJobsBySkill(@Param("skillName") String skillName);
   
    @Query("SELECT DISTINCT j FROM Job j " +
    	       "LEFT JOIN j.skills s " +
    	       "WHERE LOWER(j.postName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
    	       "OR LOWER(s.skillName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    	List<Job> searchByPostNameOrSkill(@Param("keyword") String keyword);


}


