package com.ultrapower.detection.supervision.service.auth;

public class RefreshVO {
	
    private String accessToken;
    private String refreshToken;
    
	public String getAccessToken() {
		return accessToken;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
