package com.tl.util;


import com.tl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestRedisUtil {

    @Resource
    private RedisUtil util;

    @Test
    public void testString() throws InterruptedException{
        System.out.println(util.set("hello11", "world11"));
        System.out.println(util.get("hello11"));

        System.out.println(util.set("1", "1", 5));
        System.out.println(util.get("1"));
        Thread.sleep(5000);
        System.out.println(util.get("1"));
    }

    @Test
    public void testStringObject() throws InterruptedException{
        User user = new User();

        user.setUid(9527);
        user.setUsername("zhouxingxing");
        user.setPassword("999999");
        user.setAge(20);

        System.out.println(util.set("zhouxing", user, 5));
        System.out.println(util.get("zhouxing"));
        Thread.sleep(5000);
        System.out.println(util.get("zhouxing"));
    }

    @Test
    public void testStringList(){
        List<User> list = new ArrayList<>();

        for (int i = 0;i < 10; i++){
            list.add(new User(i,"name"+i,"pass"+i,18+i));
        }

        System.out.println(util.set("list", list));
        System.out.println(util.get("list"));
    }

    @Test
    public void testHash(){
        Map<String,Object> users = new HashMap<>();

        users.put("wukong","sundasheng");

        User tangtang = new User(1000,"tangseng","888888",20);

        users.put("tangtang",tangtang);
        users.put("bajie","zhuwuneng");

        System.out.println(util.hmset("xiyouji", users));
        System.out.println(util.hmget("xiyouji"));
        System.out.println(util.hget("xiyouji", "tangtang"));
    }
}
