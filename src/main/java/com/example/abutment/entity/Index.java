package com.example.abutment.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liutx
 * @date 2020/10/5 14:44
 * @Description
 */
@Data
public class Index implements Serializable {
    private String title;
    private String level;
    private String desc;
}
