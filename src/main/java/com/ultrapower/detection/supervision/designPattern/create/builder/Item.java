package com.ultrapower.detection.supervision.designPattern.create.builder;

import com.ultrapower.detection.supervision.designPattern.create.builder.Packing;

public interface Item {
	
	public String name();
	public Packing packing();
	public float price();

}
