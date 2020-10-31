package com.example.abutment;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @author Liutx
 * @date 2020/10/11 20:57
 * @Description
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class hutoolHttpUtils {
    @Test
    public void getTest() {
        String s = HttpUtil.get("https://story.hhui.top/detail?id=666106231640", CharsetUtil.CHARSET_UTF_8);
        log.info(s);
    }

    @Test
    public void getParamTest() {
        HashMap<String, Object> param = new HashMap<>();
        param.put("id", "666106231640");
        String s = HttpUtil.get("https://story.hhui.top/detail", param);
        log.warn(s);
    }

    @Test
    public void testPost() {
        HashMap<String, Object> postParam = new HashMap<>();
        postParam.put("city", "北京");
        String post = HttpUtil.post("https://www.baidu.com", postParam);
        log.warn(post);
    }


    @Test
    public void testFileUpload() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("file", FileUtil.file("D:\\resource\\Pic\\下载.jpg"));
        String result = HttpUtil.post("https://www.baidu.com", paramMap);
        log.warn(result);
    }

    @Test
    public void testRequest() {

//链式构建请求
        HashMap<String, Object> param = new HashMap<>();
        param.put("id", "666106231640");
        String result2 = HttpRequest.post("https://story.hhui.top/detail")

//                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                .form(param)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        log.warn(result2);

        HttpResponse res = HttpRequest.post("https://story.hhui.top/detail").execute();
        Console.log(res.getStatus());
    }
}
