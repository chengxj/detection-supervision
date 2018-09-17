package com.ultrapower.detection.supervision.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.ultrapower.detection.supervision.service.elasticjob.ElasticJob;

@RestController


public class ApiController {
	
	@Autowired
    private ZookeeperRegistryCenter zookeeperRegistryCenter;
	
	@RequestMapping("/api/test")
    public void testApi() {
        String name = "PhaseQuery-" + UUID.randomUUID().toString();
        JobCoreConfiguration jobConf = JobCoreConfiguration
                .newBuilder(name, "*/1 * * * * ?", 4)
                .shardingItemParameters("0=A,1=B")
                .build();
        SimpleJobConfiguration simpleJobConf = new SimpleJobConfiguration(jobConf, ElasticJob.class.getCanonicalName());
        JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConf).build());
        try {
            jobScheduler.init();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("定时任务创建失败");
        }
    }

}
