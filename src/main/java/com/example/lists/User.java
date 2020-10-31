package com.example.lists;

import lombok.*;

/**
 * @author Liutx
 * @date 2020/10/23 23:57
 * @Description
 */

@Data
//@Getter
//@Setter
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer id;
    private String sex;
}
