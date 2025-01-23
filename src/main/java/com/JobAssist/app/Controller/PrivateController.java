package com.JobAssist.app.Controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JobAssist.app.SecurityConfig.JwtTokenUtil;
import com.JobAssist.app.dto.JobDTO;
import com.JobAssist.app.dto.UserProfileDTO;
import com.JobAssist.app.repository.RoleRepository;
import com.JobAssist.app.repository.UserRepository;
import com.JobAssist.app.service.JobService;
import com.JobAssist.app.service.UserService;

@RestController
@RequestMapping("/JOBASSIST/private")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class PrivateController {
	private  UserService userService;
	private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private  AuthenticationManager authenticationManager;
    private  RoleRepository roleRepository; 
    private  JwtTokenUtil jwtTokenUtil; 
    private JobService jobService;
	public PrivateController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, RoleRepository roleRepository, JwtTokenUtil jwtTokenUtil,
			JobService jobService) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.roleRepository = roleRepository;
		this.jwtTokenUtil = jwtTokenUtil;
		this.jobService = jobService;
	}

	
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
	    @GetMapping("/get/{id}")
	    public ResponseEntity<UserProfileDTO> getUserById(@PathVariable Long id) {
	        return ResponseEntity.ok(userService.getUserProfileById(id));
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<UserProfileDTO> updateUser(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
	        return ResponseEntity.ok(userService.updateUserProfile(id, userProfileDTO));
	    }
//	    @GetMapping("/search")
//	    public ResponseEntity<List<JobDTO>> searchJobs(@RequestParam String keyword) {
//	        if (keyword == null || keyword.trim().isEmpty()) {
//	            return ResponseEntity.badRequest().body(Collections.emptyList());
//	        }
//	        List<JobDTO> jobDTOs = jobService.searchJobsByKeyword(keyword);
//	        return ResponseEntity.ok(jobDTOs);
//	    }
}
