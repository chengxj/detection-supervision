package com.ultrapower.detection.supervision.thread;

public class Daemon {

	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
		thread.setDaemon(true);
		thread.start();
	}
	
	static class DaemonRunner implements Runnable {

		public void run() {
			try {
				System.out.println("DaemonThread run ...");
				SleepUtils.second(10);
				System.out.println("DaemonThread run ....");
			} finally {
				System.out.println("DaemonThread finally run.");
			}
			
		}
		
	}

}
