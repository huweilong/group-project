package com.huweilong.group.service.test.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.test.input.TestInput;
import com.huweilong.group.service.dto.test.output.TestOutput;
import com.huweilong.group.service.test.TestService;
import com.huweilong.group.service.test.entity.UserEntity;
import com.huweilong.group.service.test.entity.em.UserSexEnum;
import com.huweilong.group.service.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 测试服务
 * @author Alex
 */
@RestController
public class TestServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements TestService {

    /**
     * 用户接口
     */
    private final UserMapper userMapper;

    /**
     * 构造器
     * @param userMapper
     */
    @Autowired
    public TestServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * path风格接口
     * @param id 编号
     * @return 返回结果
     */
    @Override
    public Results<TestOutput> testPathApi(Integer id) {
        System.out.println(("----- selectAll method test ------"));
        List<UserEntity> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

        UserEntity user = new UserEntity();
        user.setName("test");
        user.setType((byte) 1);
        user.setSex(UserSexEnum.MAN1);
        user.setEmail("Alex_2713@126.com");
        userMapper.insert(user);

        TestOutput testOutput = new TestOutput();
        testOutput.setId(Long.valueOf(id));
        testOutput.setName(UUID.randomUUID().toString());
        return Results.SUCCESS(testOutput);
    }

    /**
     * post请求接口
     * @param testInput 参数
     * @return 返回结果
     */
    @Override
    public Results<TestOutput> testPostApi(TestInput testInput) {
        List<Map<String, Object>> maps = this.listMaps();

        TestOutput testOutput = new TestOutput();
        testOutput.setId(testInput.getId());
        testOutput.setName(testInput.getName());
        return Results.SUCCESS(testOutput);
    }
}
