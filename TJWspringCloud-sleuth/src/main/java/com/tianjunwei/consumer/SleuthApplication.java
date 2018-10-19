package com.tianjunwei.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@RestController
public class SleuthApplication {

    private final static Logger logger = LoggerFactory.getLogger(SleuthApplication.class);


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://computer-service/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping(value = "/traceId", method = RequestMethod.GET)
    public String info() {
        logger.info("traceId");
        return "success";
    }
	
    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
    }
}
