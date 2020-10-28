package com.ml.aweb.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;


public class Category {

  private long id;
  private String name;

  @TableField(exist = false)
  private List<Product> products;
  @TableField(exist = false)
  private List<List<Product>> productsByRow;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
  public List<List<Product>> getProductsByRow() {
    return productsByRow;
  }

  public void setProductsByRow(List<List<Product>> productsByRow) {
    this.productsByRow = productsByRow;
  }
}
