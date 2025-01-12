package com.JobAssist.app.entities;

import jakarta.persistence.*;

@Entity
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String organization;
    private String issueDate;
    private String expiryDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    
}
