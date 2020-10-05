package com.example.abutment.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liutx
 * @date 2020/10/5 12:31
 * @Description
 */
@Data
public class DailyWeather implements Serializable {
    private String day;
    private String date;
    private String week;
    private String wea;
    private String wea_img;
    private String air;
    private String humidity;
    private String air_level;
    private String air_tips;
    private ArrayList<Alarm> alarm;
    private String tem1;
    private String tem2;
    private String tem;
    private List<Win> win;
    private String win_speed;
    private List<Hours> hours;
    private List<Index> index;
}
