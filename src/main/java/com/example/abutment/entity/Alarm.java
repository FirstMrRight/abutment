package com.example.abutment.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liutx
 * @date 2020/10/5 14:39
 * @Description
 */
@Data
public class Alarm implements Serializable {
    private String alarm_type;
    private String alarm_level;
    private String alarm_content;
}
