package com.common.testconfig.config;

import com.common.testconfig.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Liutx
 * @date 2020/12/5 23:10
 * @Description
 */
//@Component
@Configuration
public class LiteBeanConfig {

    @Bean
    public User user() {
        System.out.println("user() 方法执行");
        return new User();
    }

    @Bean
    public String name(User user) {
        System.out.println("name(User user) 方法执行");
        System.out.println(user.hashCode());
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("再次调用user()方法: " + user().hashCode());
        }).start();
        return "123";
    }
}
