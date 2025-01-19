package com.JobAssist.app.dto;


public class EducationDTO {
    private Long id;
    private String degree;
    private String fieldOfStudy;
    private String university;
    private String startDate;
    private String endDate;
    private double grade;
    private Long userId; // Simplified to userId to avoid circular dependency
    

    public EducationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EducationDTO(Long id, String degree, String fieldOfStudy, String university, String startDate,
			String endDate, double grade, Long userId) {
		super();
		this.id = id;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.university = university;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
		this.userId = userId;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
