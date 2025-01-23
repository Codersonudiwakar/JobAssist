package com.JobAssist.app.Controller;
import com.JobAssist.app.dto.JobDTO;
import com.JobAssist.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/JOBASSIST/jobs")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class JobController {

    @Autowired
    private JobService jobService;

    // Endpoint to get all jobs
    @GetMapping("/getAll")
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<JobDTO> jobDTOs = jobService.getAllJobs();
        return ResponseEntity.ok(jobDTOs);
    }

    // Endpoint to get a job by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
    //    return jobService.getJobById(id);
    	 ResponseEntity<JobDTO> job = jobService.getJobById(id);
    	 return job;
    }
    // Endpoint to create a new job
    @PostMapping("/create")
    public ResponseEntity<JobDTO> createJob(@RequestBody JobDTO jobDTO) {
        JobDTO createdJob = jobService.createJob(jobDTO);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO) {
        Optional<JobDTO> updatedJob = jobService.updateJob(id, jobDTO);
        return updatedJob.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }
//    @GetMapping("/search")
//    public ResponseEntity<List<JobDTO>> searchJobs(@RequestParam String keyword) {
//        if (keyword == null || keyword.trim().isEmpty()) {
//            return ResponseEntity.badRequest().body(Collections.emptyList());
//        }
//        List<JobDTO> jobDTOs = jobService.searchJobsByKeyword(keyword);
//        return ResponseEntity.ok(jobDTOs);
//    }
    
    @GetMapping("/search")
    public ResponseEntity<List<JobDTO>> searchJobs(@RequestParam String keyword) {
        List<JobDTO> jobDTOs = jobService.searchJobsByKeyword(keyword);
        return ResponseEntity.ok(jobDTOs);
    }




    // Endpoint for deleting a job
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
