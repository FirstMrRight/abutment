package com.example.abutment;

import com.alibaba.fastjson.JSON;
import com.common.enums.ResponseEnum;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Liutx
 * @date 2020/10/3 21:20
 * @Description
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/post")
public class RestController {
    @PostMapping("/post")
    public Boolean post(HttpServletRequest request,
                        @RequestParam(value = "email", required = false) String email,
                        @RequestParam(value = "nick", required = false) String nick) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("result", "add " + email + " # " + nick + " success!");
        map.put("time", new Date());
        ResponseEnum.CLIENT_USER_SAVE_PARAM_NULL.assertEquals(true, 1 > 2);
//        return JSON.toJSONString(map);
        return true;
    }


    @GetMapping("/get")
    public Boolean get() {
        ResponseEnum.CLIENT_USER_SAVE_PARAM_NULL.assertNotNull(null);
//        return JSON.toJSONString(map);
        return true;
    }

}
