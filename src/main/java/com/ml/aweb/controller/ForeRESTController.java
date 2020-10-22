package com.ml.aweb.controller;


import com.ml.aweb.entity.Category;
import com.ml.aweb.entity.User;
import com.ml.aweb.service.UserService;
import com.ml.aweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeRESTController{
    @Autowired
    UserService userService;

    @PostMapping("/foreregister")
    public Object register(@RequestBody User user){
        String username = user.getName();

        if(userService.existName(username)){
            return Result.fail("用户名已存在！");
        }
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        if (userService.register(user) == 0) return Result.fail("注册失败！");
        else return Result.success();
    }

    @GetMapping("/forehome")
    public Object forehome(){
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        categoryService.removeCategoryFromProduct(cs);

        return cs;
    }
}