package com.ultrapower.detection.supervision.request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class RecipesNoLock {
	
	public static void main(String[] args) {
		final CountDownLatch down = new CountDownLatch(1);
		for (int i=0;i<10;i++) {
			new Thread(new Runnable() {

				public void run() {
					try {
						down.await();
					} catch (Exception e) {
						
					}
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
					String orderNo = sdf.format(new Date());
					System.out.println("生产的订单是:" + orderNo);
				}
				
			}).start();
		}
		down.countDown();
			
	}

}
