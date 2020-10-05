package com.example.abutment.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liutx
 * @date 2020/10/5 11:20
 * @Description
 */
@lombok.Data
public class Weather implements Serializable {
    private String errcode;
    private String time;
    private String update_time;
    private String msg;
    private List<WeatherData> data;
}
