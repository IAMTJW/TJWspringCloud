package com.tianjunwei.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tianjunwei.consumer.web.api.ControllerClient;

@RestController
public class ConsumerController {

	@Autowired
	ControllerClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        return client.add(a,b);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "success";
    }

}