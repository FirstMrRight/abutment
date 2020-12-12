package com.common.testconfig.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Liutx
 * @date 2020/12/5 15:31
 * @Description
 */

@Accessors(chain = true)
@Data
public class Teacher {
    private String tName;

    private int tAge;

    public Teacher() {
        System.out.println("teacher create current INSTANCE is : " + this.hashCode());
    }
}
