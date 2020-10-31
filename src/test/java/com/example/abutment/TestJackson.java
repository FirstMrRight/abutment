package com.example.abutment;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.testjackjson.entity.MyEmptyObject;
import com.testjackjson.entity.PlayerStar;
import com.testjackjson.entity.PlayerStar2;
import com.testjackjson.entity.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Liutx
 * @date 2020/10/7 22:21
 * @Description
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestJackson {
    @Test
    public void testObject2JSON() throws IOException {
        PlayerStar player = PlayerStar.getInstance();
        //ObjectMapper作为Jackson的API工具类存在
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("D:\\logs\\player.json"), player);

        //将player对象以JSON格式进行序列化为String对象
        String s = mapper.writeValueAsString(player);
        String test = "111";
        boolean equals = Objects.equals(s, test);
        if (equals) {
            log.info("yes");
        } else {
            log.info("no");
        }
        log.info(s);

        //将player对象以JSON格式进行序列化为String对象(格式美化)
        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(player);
        System.out.println(jsonInString2);
    }

    @Test
    public void testJSON2Object() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PlayerStar playerStar = mapper.readValue(new File("D:\\logs\\player.json"), PlayerStar.class);
        System.out.println(playerStar);


        log.info("=======================");
        //将JSON字符串反序列化为java对象
        String jsonInString = "{\"playerName\":\"乔丹\",\"age\":45,\"hobbies\":[\"高尔夫球\",\"棒球\"]}";
        PlayerStar jordan = mapper.readValue(jsonInString, PlayerStar.class);
        log.info(String.valueOf(jordan));
    }

    @Test
    public void testUrl() throws IOException {
        //调用远程服务
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
        ObjectMapper mapper = new ObjectMapper();
        Map postDTO = mapper.readValue(url, Map.class);
        Object title = postDTO.get("title");
        Object body = postDTO.get("body");
//        PostDTO postDTO = mapper.readValue(url, PostDTO.class);
        System.out.println(postDTO);
    }

    @Test
    public void testUnKnowProperties() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PlayerStar player = PlayerStar.getInstance();

        //将PlayerStar序列化为对象
        String valueAsString = mapper.writeValueAsString(player);
        log.info(valueAsString);

        //报错：JSON字符串所包含的属性，多余的Java类的定义（多出一个阿年龄，赋值时找不到setAge方法）
        //忽略掉age属性，不接受我们的java类未定义的成员变量数据
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        PlayerStar2 playerStar2 = mapper.readValue(valueAsString, PlayerStar2.class);
        log.info(playerStar2.toString());
    }

    @Test
    public void testEmpty() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String s = mapper.writeValueAsString(MyEmptyObject.class);
        log.info(s);
    }

    @Test
    public void timeTest() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map temp = new HashMap();
        temp.put("now", new Date());
        String s = mapper.writeValueAsString(temp);
        System.out.println(s);
    }


}
