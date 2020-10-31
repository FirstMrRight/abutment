package com.example.abutment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Liutx
 * @date 2020/10/8 11:27
 * @Description
 */
@Data
public class User {
    private String nick;
    private String email;
    @JsonProperty("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", locale = "zh", timezone = "GMT+8")
    private Date time;
}
