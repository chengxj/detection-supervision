package com.ultrapower.detection.supervision.service.auth.stateless;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ultrapower.detection.supervision.entity.User;

public class StatelessUser extends User {
	
	private String accessToken;
	
	private String grantMenu;
	
	private List<String> roles;
	
	private Set<String> permissions = new HashSet<String>();

	public String getAccessToken() {
		return accessToken;
	}

	public String getGrantMenu() {
		return grantMenu;
	}

	public List<String> getRoles() {
		return roles;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setGrantMenu(String grantMenu) {
		this.grantMenu = grantMenu;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

}