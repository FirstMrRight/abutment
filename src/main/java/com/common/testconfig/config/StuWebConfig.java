package com.common.testconfig.config;

import com.common.testconfig.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Liutx
 * @date 2020/12/5 11:30
 * @Description
 */
//@Component
public class StuWebConfig {
//    @Bean
//    public User user() {
//        return new User();
//    }

    @Bean
    public String name(User user) {
        System.out.println("invoke others Bean's INSTANCE is " + user.hashCode());
//        System.out.println("invoke Constructor Bean's INSTANCE is " + user().hashCode());
        return "123";
    }
}
