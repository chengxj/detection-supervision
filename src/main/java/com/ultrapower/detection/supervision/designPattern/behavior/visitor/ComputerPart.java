package com.ultrapower.detection.supervision.designPattern.behavior.visitor;

public interface ComputerPart {
	
	public void accept(ComputerPartVisitor computerPartVisitor);

}
