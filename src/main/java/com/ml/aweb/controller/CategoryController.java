package com.ml.aweb.controller;

import com.ml.aweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanjiawei
 * @date 2020-10-23
 */

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

//    @GetMapping("/category")
//    public Object list(int category,String sort){
//        categoryService
//    }

}
