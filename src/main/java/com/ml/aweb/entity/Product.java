package com.ml.aweb.entity;


public class Product {

  private long id;
  private String name;
  private String subTitle;
  private double originalPrice;
  private double promotePrice;
  private long stock;
  private long cid;
  private java.sql.Timestamp createDate;


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


  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }


  public double getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(double originalPrice) {
    this.originalPrice = originalPrice;
  }


  public double getPromotePrice() {
    return promotePrice;
  }

  public void setPromotePrice(double promotePrice) {
    this.promotePrice = promotePrice;
  }


  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
  }


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }

}
