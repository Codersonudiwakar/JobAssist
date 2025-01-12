package com.JobAssist.app.entities;

import jakarta.persistence.*;

@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String jobTitle;
    private String location;
    private String startDate;
    private String endDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    // Getters and Setters
}
