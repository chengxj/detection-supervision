package com.ultrapower.detection.supervision.service.auth.stateless;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;

public class StatelessAccessControlFilter extends AccessControlFilter {
	
	private static final String ACCESS_TOKEN = "token";

	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		return false;
	}

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String accessToken = getAccessTokenByRequest(request);
		StatelessToken token = new StatelessToken(accessToken, true);
		try {
			super.getSubject(request, response).login(token);			
		} catch (Exception e) {
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpServletResponse.getWriter().write("login fail.");
			return false;			
		}
		return true;
	}
	
	private String getAccessTokenByRequest(ServletRequest servletRequest) {
		String accessToken = servletRequest.getParameter(ACCESS_TOKEN);
		if (accessToken == null || "".equals(accessToken)) {
			if (servletRequest instanceof ShiroHttpServletRequest) {
				accessToken = getCookieValueByKey(((ShiroHttpServletRequest) servletRequest).getCookies(), ACCESS_TOKEN);
			}
		}
		return accessToken;
	}

	private String getCookieValueByKey(Cookie[] cookies, String key) {
		String val = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && key.equals(cookie.getName())) {
					val = cookie.getValue();
					break;
				}
			}
		}
		return val;
	}

}
