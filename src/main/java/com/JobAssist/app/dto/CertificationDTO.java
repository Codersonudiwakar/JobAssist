package com.JobAssist.app.dto;


public class CertificationDTO {
    private Long id;
    private String name;
    private String organization;
    private String issueDate;
    private String expiryDate;
    private Long userId; // Simplified to userId to avoid circular dependency
    

    public CertificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CertificationDTO(Long id, String name, String organization, String issueDate, String expiryDate,
			Long userId) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.userId = userId;
	}

	// Getters and Setters
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

