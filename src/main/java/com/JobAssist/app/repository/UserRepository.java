package com.JobAssist.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.JobAssist.app.entities.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
