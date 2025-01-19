package com.JobAssist.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobAssist.app.dto.UserProfileDTO;
import com.JobAssist.app.entities.UserProfile;
import com.JobAssist.app.repository.UserProfileRepository;
import com.JobAssist.app.utils.UserProfileConverter;

@Service
public class UserServiceImpl implements UserService {

	UserProfileConverter userConverter;
	UserProfileRepository userRepo;

	@Autowired
	public UserServiceImpl(UserProfileConverter userConverter, UserProfileRepository userRepo) {
		super();
		this.userConverter = userConverter;
		this.userRepo = userRepo;
	}

	@Override
	public UserProfileDTO createUserProfile(UserProfileDTO userProfile) {
		UserProfile user = userConverter.toEntity(userProfile);
		UserProfile savedUser = userRepo.save(user);
		return userConverter.toDTO(savedUser);
	}

	@Override
	public List<UserProfileDTO> getAllUserProfiles() {
		List<UserProfile> allUsers = userRepo.findAll();
		List<UserProfileDTO> users = new ArrayList<UserProfileDTO>();
		for (UserProfileDTO user : users) {
			users.add(user);
		}
		return users;
	}

	@Override
	public UserProfileDTO getUserProfileById(Long id) {
		UserProfile userProfile = userRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		return userConverter.toDTO(userProfile);
	}

	@Override
	public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
		UserProfile userProfile = userRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setEmail(userProfileDTO.getEmail());
		userProfile.setPhoneNumber(userProfileDTO.getPhoneNumber());
		userProfile.setLocation(userProfileDTO.getLocation());
		UserProfile updatedProfile = userRepo.save(userProfile);
		return userConverter.toDTO(updatedProfile);
	}

	@Override
	public String deleteUserProfile(Long id) {
		userRepo.deleteById(id);
		return "User Deleted";

	}

}
