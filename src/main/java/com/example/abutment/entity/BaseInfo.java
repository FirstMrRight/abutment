package com.example.abutment.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liutx
 * @date 2020/10/5 12:20
 * @Description
 */

@Data
public class BaseInfo implements Serializable {
    private String cityid;
    private String update_time;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private List<DailyWeather> data;
}
