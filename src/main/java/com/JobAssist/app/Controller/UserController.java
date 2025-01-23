package com.JobAssist.app.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.JobAssist.app.Request.AuthRequest;
import com.JobAssist.app.SecurityConfig.JwtTokenUtil;
import com.JobAssist.app.dto.UserProfileDTO;
import com.JobAssist.app.entities.Role;
import com.JobAssist.app.entities.Users;
import com.JobAssist.app.repository.RoleRepository;
import com.JobAssist.app.repository.UserRepository;
import com.JobAssist.app.response.LoginResponse;
import com.JobAssist.app.response.SignupResponse;
import com.JobAssist.app.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/JOBASSIST/users")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {
	
	private  UserService userService;
	private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private  AuthenticationManager authenticationManager;
    private  RoleRepository roleRepository; 
    private  JwtTokenUtil jwtTokenUtil;

	public UserController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, RoleRepository roleRepository, JwtTokenUtil jwtTokenUtil) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.roleRepository = roleRepository;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody AuthRequest request) {
        long startTime = System.currentTimeMillis(); // Start time
        Optional<Users> getUser=userRepository.findByEmail(request.getUsername());
        if(getUser!=null) {
        	long responseTime = System.currentTimeMillis() - startTime;
        	SignupResponse response=new SignupResponse(
            		"User already registered please Login",
                  HttpStatus.OK.value(),
                  responseTime,
                  request.	getUsername()
            		);
        	 return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Users user = new Users();
        user.setEmail(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            try {
            	roleRepository.save(userRole);
			} catch (Exception e) {
				
			}
        }
        
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);

        long responseTime = System.currentTimeMillis() - startTime; // Calculate response time
        SignupResponse response=new SignupResponse(
        		"User registered successfully",
              HttpStatus.OK.value(),
              responseTime,
              request.	getUsername()
        		);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping("/isLoggedIn")
    public boolean checkLoginWorking(String token,String username){
		boolean login=jwtTokenUtil.isTokenValid(token, username);
		return login;
    }
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthRequest authRequest) throws AuthenticationException {
		long startTime = System.currentTimeMillis();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    String token=jwtTokenUtil.generateToken(authRequest.getUsername());
    
    long responseTime = System.currentTimeMillis() - startTime;
    LoginResponse response=new LoginResponse(
    		"User Login Sucessfull", HttpStatus.OK.value(), responseTime, jwtTokenUtil.extractUsername(token), token);
    		

        return new ResponseEntity<LoginResponse>(response, HttpStatus.OK) ;
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<UserProfileDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUserProfiles());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserProfileDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserProfileById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserProfileDTO> updateUser(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
        return ResponseEntity.ok(userService.updateUserProfile(id, userProfileDTO));
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUserProfile(id);
//        return ResponseEntity.noContent().build();
//    }

}
