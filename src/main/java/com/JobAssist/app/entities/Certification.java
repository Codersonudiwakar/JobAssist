package com.JobAssist.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_Certification")
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
    

	public Certification(Long id, String name, String organization, String issueDate, String expiryDate,
			UserProfile user) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.user = user;
	}

	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

    
}
