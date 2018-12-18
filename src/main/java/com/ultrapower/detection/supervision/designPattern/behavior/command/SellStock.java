package com.ultrapower.detection.supervision.designPattern.behavior.command;

public class SellStock implements Order {

	private Stock abcStock;
	
	public SellStock(Stock abcStock) {
		this.abcStock = abcStock;
	}
	
	public void execute() {
		abcStock.sell();
	}

}
