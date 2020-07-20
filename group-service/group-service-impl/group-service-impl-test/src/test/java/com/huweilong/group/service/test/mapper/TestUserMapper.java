package com.huweilong.group.service.test.mapper;

import com.huweilong.group.service.test.entity.UserEntity;
import com.huweilong.group.service.test.entity.em.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserEntity> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        UserEntity user = new UserEntity();
        user.setName("test");
        user.setType((byte) 1);
        user.setSex(UserSexEnum.MAN1);
        user.setEmail("Alex_2713@126.com");
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        List<UserEntity> userList = userMapper.selectList(null);
        userList.forEach(item -> {
            userMapper.updateById(item);
        });
    }

    @Test
    public void testDelete() {
        List<UserEntity> userList = userMapper.selectList(null);
        userList.forEach(item -> {
            userMapper.deleteById(item.getId());
        });
    }
}
