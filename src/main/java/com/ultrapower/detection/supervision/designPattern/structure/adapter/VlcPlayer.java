package com.ultrapower.detection.supervision.designPattern.structure.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

	public void playVlc(String fileName) {
		System.out.println("Playing mp4 file.Name: " + fileName);
	}

	public void playMp4(String fileName) {
		
	}

}
