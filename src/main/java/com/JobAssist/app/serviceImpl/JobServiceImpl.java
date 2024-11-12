package com.JobAssist.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.JobAssist.app.dto.JobDTO;
import com.JobAssist.app.dto.JobDTOImpl;
import com.JobAssist.app.entities.Job;
import com.JobAssist.app.repository.JobRepository;
import com.JobAssist.app.repository.SkillRepository;
import com.JobAssist.app.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private JobDTOImpl jobDtoImpl;

	@Override
	public List<JobDTO> getAllJobs() {
		 List<Job> jobs = jobRepository.findAll();
		    List<JobDTO> jobDTOs = new ArrayList<>();
		    for (Job job : jobs) {
		        jobDTOs.add(jobDtoImpl.convertJobDTO(job));
		    }
		    return jobDTOs;
	}
	
	
	

	@Override
	public ResponseEntity<JobDTO> getJobById(Long id) {
	    Optional<Job> job = jobRepository.findById(id);

	    if (job.isPresent()) {
	        JobDTO jobDto = jobDtoImpl.convertJobDTO(job.get());
	        return ResponseEntity.ok(jobDto);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@Override
	public JobDTO createJob(JobDTO jobDTO) {
	    Job job =jobDtoImpl.convertToJobEntity(jobDTO);
	    Job savedJob = jobRepository.save(job);
	    return jobDtoImpl.convertJobDTO(savedJob);
	}
	
	@Override
	public List<JobDTO> searchJobs(String postName, String companyName, String workLocation) {
        List<Job> jobs = jobRepository.searchJobs(postName, companyName, workLocation);
        return jobs.stream()
                .map(jobDtoImpl::convertJobDTO)
                .collect(Collectors.toList());
    }

	@Override
	public Optional<JobDTO> updateJob(Long id, JobDTO jobDTO) {
		return Optional.empty();
	}

	@Override
	public boolean deleteJob(Long id) {
		
		return false;
	}


}
