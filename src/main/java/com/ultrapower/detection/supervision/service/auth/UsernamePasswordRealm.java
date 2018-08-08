package com.ultrapower.detection.supervision.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ultrapower.detection.supervision.dao.UserDao;
import com.ultrapower.detection.supervision.entity.User;

public class UsernamePasswordRealm extends AuthorizingRealm {
	
	@Autowired
	UserDao userDao;
		
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection参数不能为空。");
		}
//		User user = (User) getAvailablePrincipal(principals);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> roles = new ArrayList<String>();
		roles.add("normal");
		info.addRoles(roles);
		return info;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		String userName = usernamePasswordToken.getUsername();
		if (userName == null || "".equals(userName.trim())) {
			throw new AccountException("用户名为空");
		}		
		String pwd = new String(usernamePasswordToken.getPassword());
		User user = userDao.getUserByUserName(userName);
		if (user == null) {
			throw new AuthenticationException("用户名或密码不正确");
		}
		if (!(new Md5Hash(user.getPwd()).toString()).equals(pwd)) {
			throw new AuthenticationException("用户名或密码不正确");			
		}
		return new SimpleAuthenticationInfo(user, pwd, getName());
	}
	
}
