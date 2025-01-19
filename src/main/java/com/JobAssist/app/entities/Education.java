package com.JobAssist.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_Education")
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
    

	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Education(Long id, String degree, String fieldOfStudy, String university, String startDate, String endDate,
			double grade, UserProfile user) {
		super();
		this.id = id;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.university = university;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
		this.user = user;
	}

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

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}
    

    // Getters and Setters
}

