package com.tianjunwei.consumer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;

public class ConsulMain {

	
	public static void main(String [] args) {
		
		HostAndPort hostAndPort = HostAndPort.fromParts("127.0.0.1", 8500);
		
		Consul client = Consul.builder().withHostAndPort(hostAndPort).build();  
		String serviceName = UUID.randomUUID().toString();  
		System.err.println(serviceName);
		String serviceId = UUID.randomUUID().toString();  
		try {
			client.agentClient().register(8502, new URL("http://localhost:8502/health"), 1000L, serviceName, serviceId);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
}
