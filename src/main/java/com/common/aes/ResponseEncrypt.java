package com.common.aes;

/**
 * @author Liu-PC
 */
public @interface ResponseEncrypt {
    /**
     * 返回对body加密，默认是true
     * @author 溪云阁
     * @return boolean
     */
    boolean value() default true;
}
