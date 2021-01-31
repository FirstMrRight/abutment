package com.demo.deep.seralizable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liutx
 * @date 2021/1/31 16:07
 * @Description
 */
@Data
public class PersonDesc implements Serializable {
    private static final long serialVersionUID = 872390113109L;
    private String desc;
}
