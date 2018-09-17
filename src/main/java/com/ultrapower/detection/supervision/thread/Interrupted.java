package com.ultrapower.detection.supervision.thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {

	public static void main(String[] args) throws InterruptedException {
		Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
		sleepThread.setDaemon(true);
		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
		busyThread.setDaemon(true);
		
		sleepThread.start();
		busyThread.start();
		TimeUnit.SECONDS.sleep(10);
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is " + busyThread.isInterrupted());
		
		SleepUtils.second(2);
	}
	
	static class SleepRunner implements Runnable {

		public void run() {
			while (true) {
				SleepUtils.second(10);
			}			
		}
		
	}
	
	static class BusyRunner implements Runnable {

		public void run() {
			while (true) {
				
			}
		}
		
		
		
	}
	
	

}
