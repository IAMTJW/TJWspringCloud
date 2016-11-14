package com.tianjunwei.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class ZookeeperMain {

  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperMain.class, args);
  }

}