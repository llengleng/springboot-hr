package com.niit.springboothr.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Lenovo
 * @date : 2020/5/23 12：54
 * @description :
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试相关接口", description = "提供测试相关的Rest API")
public class TestController {

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }
}
