package com.ultrapower.detection.supervision.designPattern.behavior.template;

public abstract class Game {
	
	abstract void initialize();
	
	abstract void startPlay();
	
	abstract void endPlay();
	
	public final void play() {
		initialize();
		startPlay();
		endPlay();
	}

}