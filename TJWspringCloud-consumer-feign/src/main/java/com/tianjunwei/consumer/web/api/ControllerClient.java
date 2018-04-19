package com.tianjunwei.consumer.web.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("computer-service")
public interface ControllerClient {

	@GetMapping("/add")
	 public String add(@RequestParam(value="a") Integer a,  @RequestParam(value="b") Integer b);
}
