package com.common.testconfig;

import com.common.testconfig.config.StuWebConfig;
import com.common.testconfig.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liutx
 * @date 2020/12/5 22:51
 * @Description
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext userContext = new AnnotationConfigApplicationContext(StuWebConfig.class);
        User user = userContext.getBean(User.class);
        System.out.println("Test.invoke + : " + user.hashCode());
    }
}
