package com.ultrapower.detection.supervision.service.auth;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager){
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);
		factoryBean.setLoginUrl("/login");
		factoryBean.setSuccessUrl("/");
		factoryBean.setUnauthorizedUrl("/warn");
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();			
		filterChainDefinitionMap.put("/", "roles[normal]");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/warn", "anon");
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;
	}

	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setSessionManager(sessionManager());
		securityManager.setRealm(userPwdRealm());
		securityManager.setCacheManager(cacheManager());
		return securityManager;
	}
	
	@Bean
	public CacheManager cacheManager() {
		CacheManager cacheManager = new MemoryConstrainedCacheManager();
		return  cacheManager;
		
	}
	
	@Bean
	public DefaultSessionManager sessionManager(){
		DefaultSessionManager sessionManager = new DefaultSessionManager();
		sessionManager.setGlobalSessionTimeout(1800000);
		sessionManager.setSessionDAO(sessionDao());
		sessionManager.setSessionValidationSchedulerEnabled(true);
		return sessionManager;
	}
	
	@Bean
	public SessionDAO sessionDao() {
		SessionDAO sessionDao = new EnterpriseCacheSessionDAO();
		return sessionDao;
	}
	
	@Bean
	public UsernamePasswordRealm userPwdRealm(){
		UsernamePasswordRealm userPwdRealm = new UsernamePasswordRealm();
		return userPwdRealm;
	}

}
