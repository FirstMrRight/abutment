package com;

import cn.shuibo.annotation.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
//@EnableAutoConfiguration
public class AbutmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AbutmentApplication.class, args);
    }

}
