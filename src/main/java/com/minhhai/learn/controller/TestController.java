package com.minhhai.learn.controller;

import com.minhhai.learn.entities.ConfigEntity;
import com.minhhai.learn.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test();
    }

    @GetMapping("/tests")
    public List<ConfigEntity> findAll() {
        return testService.testAll();
    }

    @GetMapping("/refresh")
    public String refresh() {
        return testService.refresh();
    }
}
