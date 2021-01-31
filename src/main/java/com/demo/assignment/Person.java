package com.demo.assignment;

import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Liutx
 * @date 2021/1/31 10:22
 * @Description
 */

@Slf4j
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private String email;
    private String desc;
}

class PersonApp {
    public static void main(String[] args) {
        Person person = new Person("张三", 22, "156xxxx2775@163.com", "我是张三");

        //复制对象
        Person person1 = person;
        person1.setName("李四");
        System.out.println("person" + person + " " + person.hashCode());
        System.out.println("person1" + person1 + " " + person1.hashCode());
        Console.log(person == person1);
    }
}
