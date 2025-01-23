package com.JobAssist.app.response;

public class LoginResponse {
	    private String message;
	    private int status;
	    private long responseTime;
	    private String username;
	    private String jwtToken;
	
		public LoginResponse(String message, int status, long responseTime, String username, String jwtToken) {
			super();
			this.message = message;
			this.status = status;
			this.responseTime = responseTime;
			this.username = username;
			this.jwtToken = jwtToken;
		}
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
		public String getJwtToken() {
			return jwtToken;
		}
		public void setJwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
		}

}
