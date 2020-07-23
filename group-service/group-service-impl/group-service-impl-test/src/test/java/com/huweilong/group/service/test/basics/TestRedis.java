package com.huweilong.group.service.test.basics;

import com.huweilong.group.service.test.entity.UserEntity;
import com.huweilong.group.service.test.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testSet() {
        System.out.println(("----- set redis ------"));
        redisUtil.set("String", "test");
        redisUtil.set("int", 1);
    }

    @Test
    public void testGet() {
        System.out.println(("----- get redis ------"));
        System.out.println(redisUtil.get("String"));;
        System.out.println(redisUtil.get("int"));;
    }

    @Test
    public void testInce() {
        System.out.println(("----- ince redis ------"));
        System.out.println(redisUtil.incr("int", 2));;
    }

    @Test
    public void testDecr() {
        System.out.println(("----- decr redis ------"));
        System.out.println(redisUtil.decr("int", 1));;
    }
}
