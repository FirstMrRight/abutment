package com.common.testconfig;

import com.common.testconfig.config.StuWebConfig;
import com.common.testconfig.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liutx
 * @date 2020/12/5 11:33
 * @Description
 */

@Slf4j
public class Test {
    public static void main(String[] args) {
//        ApplicationContext stuContext = new AnnotationConfigApplicationContext(StuWebConfig.class);
        //使用ApplicationContext获取Spring中已初始化的bean
        /**
         * getBean一共有以下四种方法原型：
         * 1，l getBean(String name)
         * 2，l getBean(Class<T> type)
         * 3，l getBean(String name,Class<T> type)
         * 4，l getBean(String name,Object[] args)
         * https://blog.csdn.net/qq_23927391/article/details/80625578
         */
//        ApplicationContext teaContext = new AnnotationConfigApplicationContext(TeaWebConfig.class);
//        Teacher teacher = teaContext.getBean(Teacher.class);
//        System.out.println("Test.invoke + : " + teacher.hashCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StuWebConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user.hashCode());
        context.close();
    }

}
