package com.JobAssist.app.entities;

import jakarta.persistence.*;

@Entity
public class UserSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String proficiencyLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    // Getters and Setters
}

