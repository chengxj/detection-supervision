package com.ultrapower.detection.supervision.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class LatchTest {

	public static void main(String[] args) throws InterruptedException {
		Runnable taskTemp = new Runnable() {
			
			private int iCounter;
			
			public void run() {
				for (int i=0;i<10;i++) {
					iCounter++;
					System.out.println(System.nanoTime() + " [" + Thread.currentThread().getName() + " ] iCounter = " + iCounter);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
			
		};
		LatchTest latchTest = new LatchTest();
//		latchTest.startTaskAllInOnce(5, taskTemp);
		latchTest.startNTHreadByBarrier(5, taskTemp);
	}
	
	public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(1);
		for (int i=0;i<threadNums;i++) {
			Thread t = new Thread() {
				
				public void run( ) {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			};
			t.start();
		}		
		long startTime = System.nanoTime();
		System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
		startGate.countDown();
		endGate.await();
		long endTime = System.nanoTime();
		System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
		return endTime = startTime;
		
	}
	
	public void startNTHreadByBarrier(int threadNums, Runnable finishTask) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(threadNums, finishTask);
		for (int i=0;i<threadNums;i++) {
			Thread.sleep(100);
			new Thread(new CounterTask(barrier)).start();
		}
		System.out.println(Thread.currentThread().getName() + " out over ... ");
	}

}

class CounterTask implements Runnable {
	
	private CyclicBarrier barrier;
	
	public CounterTask(final CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis() + " is ready ... ");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis() + " start ... ");
	}
	
}