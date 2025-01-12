package com.JobAssist.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import java.util.*;

import com.JobAssist.app.dto.JobDTO;


public interface JobService {
    List<JobDTO> getAllJobs();
    ResponseEntity<JobDTO> getJobById(Long id);
    public List<JobDTO> searchJobsByKeyword(String keyword);
    JobDTO createJob(JobDTO jobDTO);
    Optional<JobDTO> updateJob(Long id, JobDTO jobDTO);
    boolean deleteJob(Long id);
}

