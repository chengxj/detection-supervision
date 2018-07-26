package com.ultrapower.detection.supervision.service.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {

	private static final long serialVersionUID = 1L;

	public Object getCredentials() {
		return null;
	}

	public Object getPrincipal() {
		return null;
	}

}
