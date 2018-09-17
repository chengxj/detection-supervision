package com.ultrapower.detection.supervision.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public MyInvocationHandler(Object object) {
		super();
		this.target = object;		
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("----------------before----------------");
		Object result = method.invoke(this.target, args);
		System.out.println("----------------after----------------");
		return result;
	}
	
	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.target.getClass().getInterfaces(), this);
	}

}
