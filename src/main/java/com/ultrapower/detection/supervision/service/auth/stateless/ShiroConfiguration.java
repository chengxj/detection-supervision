package com.ultrapower.detection.supervision.service.auth.stateless;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
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
		factoryBean.getFilters().put("authc", statelessAccessControlFilter());
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		filterChainDefinitionMap.put("/resources/**", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;
	}

	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setSubjectFactory(subjectFactory());
		securityManager.setSessionManager(sessionManager());
		securityManager.setRealm(stalessRealm());
		((DefaultSessionStorageEvaluator)((DefaultSubjectDAO)securityManager.getSubjectDAO()).getSessionStorageEvaluator()).setSessionStorageEnabled(false);
		return securityManager;
	}
		
	@Bean
	public DefaultWebSubjectFactory subjectFactory(){
		StatelessSubjectFactory statelessDefaultSubjectFactory = new StatelessSubjectFactory();
		return statelessDefaultSubjectFactory;
	}
	
	@Bean
	public DefaultSessionManager sessionManager(){
		DefaultSessionManager sessionManager = new DefaultSessionManager();
		sessionManager.setSessionValidationSchedulerEnabled(false);
		return sessionManager;
	}
	
	@Bean
	public StatelessRealm stalessRealm(){
		StatelessRealm statelessRealm = new StatelessRealm();
		return statelessRealm;
	}
	
	@Bean 
	public StatelessAccessControlFilter statelessAccessControlFilter(){
		StatelessAccessControlFilter statelessAccessControlFilter = new StatelessAccessControlFilter();
		return statelessAccessControlFilter;
	}

}
