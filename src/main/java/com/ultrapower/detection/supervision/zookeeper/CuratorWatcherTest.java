package com.ultrapower.detection.supervision.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryNTimes;

public class CuratorWatcherTest {

	private static final String HOSTS = "10.0.0.160:2181";
	private static final String PATH = "/test";
	
	public static void main(String[] args) {
		CuratorFramework client = CuratorFrameworkFactory.newClient("", new RetryNTimes(10, 5000));
		client.start();
		System.out.println("zk client start successluflly");
		PathChildrenCache watcher = new PathChildrenCache(client, PATH, true);
		watcher.getListenable().addListener((client1, data) -> {
			
		});

	}

}
