package com.ultrapower.detection.supervision.service.auth.stateless;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

public class StatelessSubjectFactory extends DefaultWebSubjectFactory {
	
	 public Subject createSubject(SubjectContext context) {
		 context.setSessionCreationEnabled(false);
		 return super.createSubject(context);	 
	 }
	 
}
