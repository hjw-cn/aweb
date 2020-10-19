package com.ml.aweb.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ml.aweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author hanjiawei
 * @date 2020-10-19
 */

public interface UserMapper extends BaseMapper<User> {
}
