package com.testjackjson.entity;

import lombok.Data;

/**
 * @author Liutx
 * @date 2020/10/8 10:28
 * @Description
 */

@Data
public class PostDTO {
    private Integer userId;
    private Integer id;
    private String title;
    private String content;
}
