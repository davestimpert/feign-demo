package com.example.feigndemo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "foo", url = "http://localhost:4444/feign")
public interface LocalhostClient {

    @RequestMapping(method = RequestMethod.GET, path = "/feign")
    public String feign();

}
