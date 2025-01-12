package com.JobAssist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.JobAssist.app.entities.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {}
