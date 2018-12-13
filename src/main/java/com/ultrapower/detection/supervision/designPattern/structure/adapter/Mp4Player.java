package com.ultrapower.detection.supervision.designPattern.structure.adapter;

public class Mp4Player implements AdvancedMediaPlayer {

	public void playVlc(String fileName) {

	}

	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file.Name: " + fileName);
	}

}
