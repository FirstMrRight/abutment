package com.example.abutment;

import cn.shuibo.annotation.Encrypt;
import com.common.enums.ResponseEnum;
import com.common.enums.ResultCode;
import com.common.resp.ResultMessage;
import com.example.aop.Person;
import com.example.aop.testAround;
import com.example.check.Foo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
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
                        @RequestParam(value = "nick", required = false) String nick) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("result", "add " + email + " # " + nick + " success!");
        map.put("time", new Date());
        ResponseEnum.CLIENT_USER_SAVE_PARAM_NULL.assertEquals(true, false);
//        return JSON.toJSONString(map);
        throw new Exception("测试");
//        return false;
    }


    @GetMapping("/get")
    public Boolean get() {
        ResponseEnum.CLIENT_USER_SAVE_PARAM_NULL.assertNotNull(null, "异常");
//        return JSON.toJSONString(map);
        return true;
    }

    @RequestMapping("/foo")
    public String foo(@Validated Foo foo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                //...
            }
            return "fail";
        }
        return "success";
    }

    @GetMapping("/aop")
    public void aopPerson() {
        Person person = new Person();
        person.sayHi();
    }


    @Encrypt
    @testAround(value = "1")
    @GetMapping("/aopAround")
    public ResultMessage aopAround() {
        String test = "rsa";
        //ResultMessage类使用@Accessors(chain = true)实现链式调用set方法
        return ResultMessage.success().setMsg("成功").setData("over").setCode(200).setSign(test);
    }
}
