package com.ml.aweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.aweb.entity.User;
import com.ml.aweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    HttpServletRequest request;


    @Override
    public UserDetails loadUserByUsername(@RequestParam String name) throws UsernameNotFoundException {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("name",name);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("sessusername",name);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorities);
    }
}
