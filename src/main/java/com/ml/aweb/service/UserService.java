package com.ml.aweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.aweb.entity.User;
import com.ml.aweb.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanjiawei
 * @date 2020-10-22
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean existName(String username){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", username));
        return (null != user);
    }
    public int register(User user){
        return userMapper.insert(user);
    }


}
