package com.bird.demo.service.zero.user;

import com.bird.demo.service.zero.user.mapper.UserMapper;
import com.bird.demo.service.zero.user.model.User;
import com.bird.service.common.service.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author liuxx
 * @date 2018/6/21
 */
@Service
@CacheConfig(cacheNames = "zero_user")
@com.alibaba.dubbo.config.annotation.Service(interfaceName = "com.bird.demo.service.zero.user.UserService")
public class UserServiceImpl extends AbstractService<UserMapper,User> implements UserService {

    @Override
    public String test() {
        return "test";
    }
}
