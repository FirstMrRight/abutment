package com.example.abutment.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liutx
 * @date 2020/10/5 14:42
 * @Description
 */

@Data
public class Hours implements Serializable {
    private String day;
    private String wea;
    private String tem;
    private String win;
    private String win_speed;
}
