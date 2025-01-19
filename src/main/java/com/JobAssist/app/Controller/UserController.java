package com.JobAssist.app.Controller;

import java.util.Collections;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.JobAssist.app.Request.AuthRequest;
import com.JobAssist.app.SecurityConfig.JwtTokenUtil;
import com.JobAssist.app.dto.UserProfileDTO;
import com.JobAssist.app.entities.Role;
import com.JobAssist.app.entities.Users;
import com.JobAssist.app.repository.RoleRepository;
import com.JobAssist.app.repository.UserRepository;
import com.JobAssist.app.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
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
    public String signup(@RequestBody AuthRequest request) {
        Users user = new Users();
        user.setEmail(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
        return "User registered successfully";
    }
	
	@PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    String token=jwtTokenUtil.generateToken(authRequest.getUsername());

        return jwtTokenUtil.generateToken(authRequest.getUsername());
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
