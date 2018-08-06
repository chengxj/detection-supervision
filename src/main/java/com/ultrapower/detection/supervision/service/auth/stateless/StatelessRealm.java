package com.ultrapower.detection.supervision.service.auth.stateless;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class StatelessRealm extends AuthorizingRealm {
	
	public boolean supports(AuthenticationToken token) {
		return token instanceof StatelessToken;
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		StatelessUser user = (StatelessUser) getAvailablePrincipal(principals);
        Set<String> roleNames = new LinkedHashSet<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(user.getPermissions());
		List<String> roles = new ArrayList<String>();
		roles.add("normal");
		info.addRoles(roles);
        return info;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		StatelessToken statelessToken = (StatelessToken)token;
		String accessToken = statelessToken.getAccessToken();
		if (accessToken == null)
			throw new AuthenticationException();
		StatelessUser user = new StatelessUser();
		user.setAccessToken(accessToken);
		return new SimpleAuthenticationInfo(user, false, getName());
	}
	
}
