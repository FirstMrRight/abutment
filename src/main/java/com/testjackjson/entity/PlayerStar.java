package com.testjackjson.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liutx
 * @date 2020/10/7 22:15
 * @Description
 */

@Data
public class PlayerStar {
    @JsonProperty("playerName")
    private String name;
    private Integer age;
    private String[] hobbies;    //业余爱好,数组
    private List<String> friends;   //  朋友
    private Map<String, BigDecimal> salary; //年收入 Map


    //初始化一个对象用于测试
    public static PlayerStar getInstance(){
        PlayerStar playerStar = new PlayerStar();

        playerStar.setName("乔丹");
        playerStar.setAge(45);
        playerStar.setHobbies(new String[]{"高尔夫球", "棒球"});
        Map<String, BigDecimal> salary = new HashMap<String, BigDecimal>() {{
            put("2000", new BigDecimal(10000000));
            put("2010", new BigDecimal(62000000));
            put("2020", new BigDecimal(112400000));
        }};
        playerStar.setSalary(salary);
        playerStar.setFriends(Arrays.asList("kobe", "curry", "james"));

        return playerStar;
    }

}
