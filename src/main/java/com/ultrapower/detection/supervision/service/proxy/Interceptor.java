package com.ultrapower.detection.supervision.service.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Interceptor implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("I am intercept begin");
		proxy.invokeSuper(obj, args);
		System.out.println("I am intercept end");
		return null;
	}

}
