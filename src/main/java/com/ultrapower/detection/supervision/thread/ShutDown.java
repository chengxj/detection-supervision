package com.ultrapower.detection.supervision.thread;

import java.util.concurrent.TimeUnit;

public class ShutDown {

	public static void main(String[] args) throws InterruptedException {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();		
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();		
		TimeUnit.SECONDS.sleep(1);		
		two.cancel();
	}
	
	private static class Runner implements Runnable {

		private long i;
		private volatile boolean on = true;
		
		public void run() {
			while (on && Thread.currentThread().isInterrupted()) {
				i++;
			}
			System.out.println("Count i = " + i);
		}
		
		public void cancel() {
			on = false;
		}
		
	}

}
