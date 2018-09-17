package com.ultrapower.detection.supervision.service.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		UserService service = new UserServiceImpl();
		MyInvocationHandler invocationHandler = new MyInvocationHandler(service);
		UserService serviceProxy = (UserService)invocationHandler.getProxy();
		serviceProxy.add();
	}

}
