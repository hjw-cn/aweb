package com.ml.aweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanjiawei
 * @date 2020-09-25
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello,Client";
    }
}
