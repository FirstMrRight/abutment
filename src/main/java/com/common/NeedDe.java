package com.common;

import com.common.aes.ResponseEncrypt;
import org.springframework.core.MethodParameter;

/**
 * @author Liutx
 * @date 2020/12/6 22:18
 * @Description
 */

/**
 * 是否需要加密解密
 *
 * @author：溪云阁
 * @date：2020年6月4日
 */
public class NeedDe {

    /**
     * 判断是否需要加密
     *
     * @param returnType
     * @return boolean
     * @author 溪云阁
     */
    public static boolean needEncrypt(MethodParameter returnType) {
        boolean encrypt = false;
        // 获取类上的注解
        final boolean classPresentAnno = returnType.getContainingClass().isAnnotationPresent(ResponseEncrypt.class);
        // 获取方法上的注解
        final boolean methodPresentAnno = returnType.getMethod().isAnnotationPresent(ResponseEncrypt.class);
        if (classPresentAnno) {
            // 类上标注的是否需要加密
            encrypt = returnType.getContainingClass().getAnnotation(ResponseEncrypt.class).value();
            // 类不加密，所有都不加密
            if (!encrypt) {
                return false;
            }
        }
        if (methodPresentAnno) {
            // 方法上标注的是否需要加密
            encrypt = returnType.getMethod().getAnnotation(ResponseEncrypt.class).value();
        }
        return encrypt;
    }

}
