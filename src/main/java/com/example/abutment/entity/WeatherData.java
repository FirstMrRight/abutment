package com.example.abutment.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liutx
 * @date 2020/10/5 11:21
 * @Description
 */

@lombok.Data
public class WeatherData implements Serializable {
    private String time;
    private String level;
    private String value;
}
