package com.JobAssist.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.JobAssist.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
