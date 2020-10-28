package com.ml.aweb.entity;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("productimage")
public class ProductImage {

  private long id;
  private long pid;
  private String type;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
