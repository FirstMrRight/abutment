package com.example.abutment;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author Liutx
 * @date 2020/12/10 11:00
 * @Description
 */
public class TestEat {
    public static void main(String[] args) throws ParseException {
        String date = "Sat Mar 04 09:54:20 EET 2017";
        LocalDate dateNew = ZonedDateTime
                .parse(date, DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH))
                .toLocalDate();
        java.sql.Date date5 = java.sql.Date.valueOf(dateNew);

        System.out.println(date5);
    }
}
