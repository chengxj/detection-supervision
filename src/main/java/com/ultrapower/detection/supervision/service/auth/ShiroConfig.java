package com.ultrapower.detection.supervision.service.auth;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ShiroConfig {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);
		factoryBean.setLoginUrl("/login");
		factoryBean.setSuccessUrl("/index");
		factoryBean.setUnauthorizedUrl("/error-404");		
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();	
		filterChainDefinitionMap.put("/", "roles[normal]");
		filterChainDefinitionMap.put("/assets/**", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/warn", "anon");
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/**", "roles[normal]");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;
	}

	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		securityManager.setSessionManager(sessionManager());
		securityManager.setCacheManager(cacheManager());
		securityManager.setRealm(userPwdRealm());
		return securityManager;
	}
	
	@Bean
	public CacheManager cacheManager() {
		CacheManager cacheManager = new MemoryConstrainedCacheManager();
		return  cacheManager;
	}
	
//	@Bean
//	public SessionManager sessionManager(){
//		DefaultSessionManager sessionManager = new DefaultSessionManager();
//		sessionManager.setGlobalSessionTimeout(1800000);
//		sessionManager.setSessionDAO(sessionDao());
//		sessionManager.setSessionValidationSchedulerEnabled(true);
//		return sessionManager;
//	}
//	
//	@Bean
//	public SessionDAO sessionDao() {
//		SessionDAO sessionDao = new EnterpriseCacheSessionDAO();
//		return sessionDao;
//	}
	
	@Bean
	public UsernamePasswordRealm userPwdRealm(){
		UsernamePasswordRealm userPwdRealm = new UsernamePasswordRealm();
		return userPwdRealm;
	}
	
	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
		mappings.setProperty("UnauthorizedException","403");
		r.setExceptionMappings(mappings);
		r.setDefaultErrorView("error");
		r.setExceptionAttribute("ex");
		return r;
	}

}
