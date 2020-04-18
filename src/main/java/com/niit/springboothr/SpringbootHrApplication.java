package com.niit.springboothr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.niit.springboothr.mapper")
public class SpringbootHrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHrApplication.class, args);
    }

}
