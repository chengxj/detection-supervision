package com.ultrapower.detection.supervision.service.auth.stateless;

import org.apache.shiro.authc.AuthenticationToken;

public class StatelessToken implements AuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String accessToken;
	private boolean available;
		
	public StatelessToken(String accessToken, boolean available) {
		this.accessToken = accessToken;
		this.available = available;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Object getPrincipal() {
		return accessToken;
	}

	public Object getCredentials() {
		return available;
	}

}