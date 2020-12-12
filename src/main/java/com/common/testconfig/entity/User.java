package com.common.testconfig.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Liutx
 * @date 2020/12/5 11:28
 * @Description
 */
@Accessors(chain = true)
@Data
public class User {

    private int age;

    private String name;

    private String doHomeWork;

    public User() {
        System.out.println("user create current INSTANCE is : " + this.hashCode());
    }
}


