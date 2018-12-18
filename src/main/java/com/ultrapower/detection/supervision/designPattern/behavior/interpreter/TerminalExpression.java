package com.ultrapower.detection.supervision.designPattern.behavior.interpreter;

public class TerminalExpression implements Expression {
	
	private String data;
	
	public TerminalExpression(String data) {
		this.data = data;
	}

	public boolean interpret(String context) {
		if (context.contains(data)) {
			return true;
		}		
		return false;
	}

}
