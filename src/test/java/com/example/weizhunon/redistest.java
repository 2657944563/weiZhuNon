package com.example.weizhunon;

import com.example.weizhunon.Pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class redistest {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test1() {
        redisTemplate.opsForValue().set("userTest", new User(1,"2","3",4,"5"));
        System.out.println(redisTemplate.opsForValue().get("userTest"));
    }
}
