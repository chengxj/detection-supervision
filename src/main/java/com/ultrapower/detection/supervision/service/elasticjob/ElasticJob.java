package com.ultrapower.detection.supervision.service.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;

@ElasticSimpleJob(cron="0/5 * * * * ?",jobName="0-5-TEST",shardingTotalCount=2,jobParameter="参数",shardingItemParameters="0=A,1=B")
public class ElasticJob implements SimpleJob {

	public void execute(ShardingContext shardingContext) {
		switch(shardingContext.getShardingItem()) {
		case 0:
			System.out.println("===============================" + shardingContext.getShardingParameter());
			break;
		case 1:
			System.out.println("###############################" + shardingContext.getShardingParameter());			
			break;
		}
		System.out.println(String.format("------Thread ID: %s, 任务总片数: %s, " +
                "当前分片项: %s,当前参数: %s," +
                "当前任务名称: %s,当前任务参数: %s,"+
                "当前任务的id: %s",
		Thread.currentThread().getId(),
        //获取任务总片数
        shardingContext.getShardingTotalCount(),
        //获取当前分片项
        shardingContext.getShardingItem(),
        //获取当前的参数
        shardingContext.getShardingParameter(),
        //获取当前的任务名称
        shardingContext.getJobName(),
        //获取当前任务参数
        shardingContext.getJobParameter(),
        //获取任务的id
        shardingContext.getTaskId()));
	}

}
