package com.ultrapower.detection.supervision.designPattern.behavior.nullobject;

public class RealCustomer extends AbstractCustomer {
	
	public RealCustomer(String name) {
		this.name = name;
	}

	public boolean isNil() {
		return false;
	}

	public String getName() {
		return name;
	}

}
