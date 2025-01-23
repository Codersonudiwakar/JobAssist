package com.JobAssist.app.response;

public class SignupResponse {
    private String message;
    private int status;
    private long responseTime;
    private String username;

    public SignupResponse(String message, int status, long responseTime, String username) {
        this.message = message;
        this.status = status;
        this.responseTime = responseTime;
        this.username = username;
    }


	// Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

