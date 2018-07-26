package com.ultrapower.detection.supervision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.shiro.authc.AuthenticationToken;

@SpringBootApplication
public class DsApplication {
	
//	private final static Logger LOG = LoggerFactory.getLogger(DsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DsApplication.class, args);
	}
	
}
