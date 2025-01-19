package com.JobAssist.app.service;


import java.util.List;
import java.util.Optional;

import com.JobAssist.app.dto.UserProfileDTO;
import com.JobAssist.app.entities.UserProfile;

public interface UserService {

    UserProfileDTO createUserProfile(UserProfileDTO userProfile);

    List<UserProfileDTO> getAllUserProfiles();

    UserProfileDTO getUserProfileById(Long id);

    UserProfileDTO updateUserProfile(Long id, UserProfileDTO updatedProfile);

    String deleteUserProfile(Long id);
}

