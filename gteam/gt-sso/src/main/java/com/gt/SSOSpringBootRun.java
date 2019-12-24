package com.gt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gt.mapper")
public class SSOSpringBootRun {

    public static void main(String[] args) {
        SpringApplication.run(SSOSpringBootRun.class,args);
    }
}
