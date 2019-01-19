package com.tianjunwei.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author tianjunwei
 * 2019/1/19 21:19
 */
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    @Value("${database.port}")
    private int port;

    @RequestMapping(value = "/config-info", method = RequestMethod.GET)
    public int info() {
        return port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
