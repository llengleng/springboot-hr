package com.niit.springboothr.controller;

import com.niit.springboothr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Lenovo
 * @date : 2020/4/18 19：15
 * @description :
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("未登录，请登录");
    }
}
