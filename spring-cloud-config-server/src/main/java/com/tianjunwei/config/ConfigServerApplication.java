package com.tianjunwei.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianjunwei
 * 2019/1/19 21:06
 */
@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigServerApplication {


    @RequestMapping(value = "/config-info", method = RequestMethod.GET)
    public String info() {
        return "success";
    }
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
