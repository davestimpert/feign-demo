package com.example.feigndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired LocalhostClient client;

    @RequestMapping("/")
    public String index() {
        return client.feign();
    }

}
