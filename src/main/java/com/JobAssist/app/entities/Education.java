package com.JobAssist.app.entities;

import jakarta.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;
    private String fieldOfStudy;
    private String university;
    private String startDate;
    private String endDate;
    private double grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    // Getters and Setters
}

