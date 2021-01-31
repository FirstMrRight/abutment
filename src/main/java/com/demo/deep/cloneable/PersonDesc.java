package com.demo.deep.cloneable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liutx
 * @date 2021/1/31 15:08
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDesc implements Cloneable {
    private String desc;
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
