package com.niit.springboothr.controller;

import com.niit.springboothr.model.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author : Lenovo
 * @date : 2020/4/18 19：15
 * @description :
 */
@RestController
@ApiIgnore
public class LoginController {


    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("未登录，请登录");
    }
}
