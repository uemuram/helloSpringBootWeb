package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StartInstancesRequest;

@Service
public class HelloSpringBootWebService {

	public int doSomeService(String instanceId) {

		// EC2操作用クライアント
		// Windowsであれば、C:\Users\[ユーザ名]\.aws 以下にCredentialsが設定されている前提
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();

		// EC2起動
		ec2.startInstances(new StartInstancesRequest().withInstanceIds(instanceId));

		return 3;
	}
}
