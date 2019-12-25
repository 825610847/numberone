package com.gt;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class WebSpringBootRun {

    public static void main(String[] args) {
        SpringApplication.run(WebSpringBootRun.class,args);
    }
}
