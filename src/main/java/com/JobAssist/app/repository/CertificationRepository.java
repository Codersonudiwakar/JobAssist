package com.JobAssist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobAssist.app.entities.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {}
