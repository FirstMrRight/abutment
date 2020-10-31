package com.example.abutment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.abutment.Constant.UrlConstant;
import com.example.abutment.entity.User;
import com.example.abutment.entity.Weather;
import com.example.abutment.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AbutmentApplicationTests {

    @Autowired
    public RestTemplate restTemplate;

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Before
//    public void init() {
//        restTemplate = new RestTemplate();
//    }

    @lombok.Data
    static class InnerRes {
        private Status status;
        //        private Data result;
        private Data data;
    }

    @lombok.Data
    static class Status {
        int code;
        String msg;
    }

    @lombok.Data
    static class Data {
        long id;
        String theme;
        String title;
        String dynasty;
        String explain;
        String content;
        String author;
    }


    @Test
    void contextLoads() {
    }

    @Test
    void testGet() {

        String url;

        url = "https://www.tianqiapi.com/api/?appid=57847229&versio=v9&appsecret=jN4fUx1a&city=青岛";
        Map res = restTemplate.getForObject(url, Map.class);
        assert res != null;
        System.out.println(res);

//        BaseInfo dailyWeather = restTemplate.getForObject(url, BaseInfo.class);
//        System.out.println(dailyWeather);

    }

    @Test
    public void testPost() throws IOException {
        String url = "http://localhost:8080/post/post";
        String email = "http://49.232.21.180:8090/";
        String nick = "关忆北_Blog";

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("email", email);
        request.add("nick", nick);

//        String postForm = HttpUtil.postForm(url, request);
        String postForm = restTemplate.postForObject(url, request, String.class);
        System.out.println(postForm);

        User user = new User();
        user.setEmail("111");
        user.setNick("222");
        user.setTime(new Date());
        String postForObject = restTemplate.postForObject(url, user, String.class);
        log.warn(postForObject);

        // 使用方法二
//        URI uri = URI.create(url);
//        String ans = restTemplate.postForObject(uri, request, String.class);
//        System.out.println(ans);
//
//
//        request.clear();
//        request.add("email", email);
//        String postForObject = restTemplate.postForObject(url + "?nick={?}", request, String.class, nick);
//        System.out.println(postForObject);


        //使用方法三
//        Map<String, String> params = new HashMap<>();
//        params.put("nick", nick);
//        String postForObject1 = restTemplate.postForObject(url + "?nick{nick}", request, String.class, params);
//        System.out.println(postForObject1);
    }




    @Test
    public void testByGetUtil() throws IOException {
        String url = "http://localhost:8080/post/post";
        Map<String, String> params = new HashMap<>();
        String email = "test@hhui.top";
        String nick = "一灰灰Blog";
        params.put("email", email);
        params.put("nick", nick);
        String postForm = HttpUtil.postForm(url, params);
        System.out.println(postForm);
        String email1 = JSON.parseObject(postForm).getString("result");

        System.out.println(email1);
    }


    @Test
    void testByPostUtils() throws Exception{
        String simpleUrl = UrlConstant.SimpleUrl;
        String json = HttpUtil.get(simpleUrl);
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject);
    }

    @Test
    void allTest() {
//        String url = "https://story.hhui.top/detail?id={?}";
        String url = "https://www.tianqiapi.com/api/?appid=57847229&versio=v9&appsecret=jN4fUx1a&city=青岛";
        InnerRes res = restTemplate.getForObject(url, InnerRes.class);
        System.out.println(res);

        ResponseEntity<InnerRes> forEntity = restTemplate.getForEntity(url, InnerRes.class,"666106231640");
        System.out.println(forEntity.toString());


        ResponseEntity<Object> forEntitys = restTemplate.getForEntity(url, Object.class);
        Object body = forEntitys.getBody();
        System.out.println(body);
        System.out.println(forEntitys.toString());
    }

    @Test
    void test() throws IOException {
        String url;
        String requestUrl = UrlConstant.WeatherUrl;
        String appid = "57847229";
        String appsecret = "jN4fUx1a";
        String lng = "114.302953";
        String lat = "30.585411";
        url = String.format("%s?appid=%s&appsecret=%s&lng=%s&lat=%s&version=v11",
                requestUrl,
                appid,
                appsecret,
                lng,
                lat);
        log.warn(url);
        //使用httpUtil方式
        String s = HttpUtil.get(url);
        //使用RestTempalate方式
        Weather weather = restTemplate.getForObject(url, Weather.class);
        log.info(weather.toString());
        log.info(s);
    }

    @Test
    void mapTest(){
        // 使用方法二，map传参
        String url = "https://story.hhui.top/detail?id={id}";
        Map<String, Object> params = new HashMap<>();
        params.put("id", 666106231640L);
        InnerRes forObject = restTemplate.getForObject(url, InnerRes.class, params);
        System.out.println(forObject);


//        // 使用方法一，传参替换
//        url = "https://story.hhui.top/detail?id={?}";
//        InnerRes forObject = restTemplate.getForObject(url, InnerRes.class, "666106231640");
//        System.out.println(forObject);

    }
}
