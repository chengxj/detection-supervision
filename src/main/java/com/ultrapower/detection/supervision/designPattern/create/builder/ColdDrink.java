package com.ultrapower.detection.supervision.designPattern.create.builder;

public abstract class ColdDrink implements Item {

	public Packing packing() {
		return new Bottle();
	}

	public abstract float price();

}
