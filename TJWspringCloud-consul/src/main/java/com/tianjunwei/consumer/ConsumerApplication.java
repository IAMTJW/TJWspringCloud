package com.tianjunwei.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsumerApplication {
	
	@RequestMapping("/hi")
    public String home() {
        return "hi ,i'm miya";
    }
	
	/*
	 * 自检
	 */
	@RequestMapping("/health")
    public String health() {
        return "health";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}