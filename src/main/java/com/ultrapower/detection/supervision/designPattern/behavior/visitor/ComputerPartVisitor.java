package com.ultrapower.detection.supervision.designPattern.behavior.visitor;

public interface ComputerPartVisitor {
	
	public void visit(Computer computer);
	
	public void visit(Mouse mouse);
	
	public void visit(Keyboard keyboard);
	
	public void visit(Monitor monitor);

}