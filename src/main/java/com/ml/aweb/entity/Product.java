package com.ml.aweb.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author hanjiawei
 * @date 2020-10-21
 */

@Document(indexName = "how2java",type="product")
public class Product {
//        "code" : "20884472626",
//        "price" : 755,
//        "name" : "loosafe网络监控摄像头720p/960p/1080p数字高清130万红外摄像机",
//        "place" : "广东东莞",
//        "category" : "品质建材"
    private long id;
    private String code;
    private float price;
    private String name;
    private String place;
    private String category;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
