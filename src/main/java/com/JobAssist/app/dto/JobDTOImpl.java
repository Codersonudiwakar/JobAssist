package com.JobAssist.app.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.JobAssist.app.entities.Job;
import com.JobAssist.app.entities.Skill;

public class JobDTOImpl {
	public JobDTO convertJobDTO(Job job) {
        List<SkillDTO> skillDTOs = job.getSkills().stream()
                .map(skill -> new SkillDTO(skill.getId(), skill.getSkillName()))
                .collect(Collectors.toList());

        return new JobDTO(
                job.getId(),
                job.getPostName(),
                job.getCompanyName(),
                job.getJobDescription(),
                job.getWorkLocation(),
                skillDTOs,
                job.getJobResponsibilities(),
                job.getJobQualifications(),
                job.getJobExperience()
        );
    }
	 public Job convertToJobEntity(JobDTO jobDTO) {
	        Job job = new Job();
	        job.setId(jobDTO.getId());
	        job.setPostName(jobDTO.getPostName());
	        job.setCompanyName(jobDTO.getCompanyName());
	        job.setJobDescription(jobDTO.getJobDescription());
	        job.setWorkLocation(jobDTO.getWorkLocation());
	        job.setJobResponsibilities(jobDTO.getJobResponsibilities());
	        job.setJobQualifications(jobDTO.getJobQualifications());
	        job.setJobExperience(jobDTO.getJobExperience());

	        List<Skill> skills = jobDTO.getSkills().stream()
	                .map(skillDTO -> new Skill(skillDTO.getId(), skillDTO.getSkillName(), job))
	                .collect(Collectors.toList());
	        job.setSkills(skills);

	        return job;
	    }

}
