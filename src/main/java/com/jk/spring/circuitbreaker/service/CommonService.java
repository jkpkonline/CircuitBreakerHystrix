package com.jk.spring.circuitbreaker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommonService {

    @Autowired
    private RestTemplate resttemplate;

    @HystrixCommand(fallbackMethod = "servicefail"
            //, commandProperties = {
            //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")}
    )
    public String say() {
        return resttemplate.getForObject("http://localhost:8080/sayhello", String.class);
    }

    private String servicefail() {
        return "Service not available";
    }
}
