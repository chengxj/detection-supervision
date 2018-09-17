package com.ultrapower.detection.supervision.service.proxy;

import org.springframework.cglib.proxy.Enhancer;

public class Test {

	public static void main(String[] args) {
		Enhancer eh = new Enhancer();
		eh.setSuperclass(Target.class);
		eh.setCallback(new Interceptor());
		Target t = (Target)eh.create();
		t.f();
		t.g();
	}

}
