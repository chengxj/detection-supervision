package com.ultrapower.detection.supervision.designPattern.behavior.mediator;

public class MediatorPatternDemo {

	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");
		robert.sendMessage("Hello John");
		john.sendMessage("Hello Robert");

	}

}
