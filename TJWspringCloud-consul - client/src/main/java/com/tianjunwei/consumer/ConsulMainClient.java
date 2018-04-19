package com.tianjunwei.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.ConsulLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;  
  
@SpringBootApplication  
@EnableDiscoveryClient  
@RestController  
public class ConsulMainClient  {  
      
    @Autowired(required=true)    
    private LoadBalancerClient loadBalancer;  
      
    @Autowired(required=true)
    private DiscoveryClient discoveryClient;  
      
    /** 
     * 从所有服务中选择一个服务（轮询） 
     */  
    @RequestMapping("/discover")  
    public Object discover() {  
        return loadBalancer.choose("consul-miya").getUri().toString();  
    }  
      
    
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    
    /** 
     * 获取所有服务  
     */  
    @RequestMapping("/services")  
    public Object services() {  
        return discoveryClient.getInstances("consul-miya");  
    }  
      
    public static void main( String[] args ) {  
        SpringApplication.run(ConsulMainClient.class, args);  
    }  
}  