package com.ml.aweb.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.data.annotation.Transient;

import java.util.List;

public class Product {

  private long id;
  private String name;

  @TableField(value = "subTitle")
  private String subTitle;
  @TableField(value = "originalPrice")
  private double originalPrice;
  @TableField(value = "promotePrice")
  private double promotePrice;
  private long stock;
  private long cid;
  @TableField(value = "createDate")
  private java.sql.Timestamp createDate;

  @TableField(exist = false)
  private ProductImage firstProductImage;
  @TableField(exist = false)
  private List<ProductImage> productSingleImages;
  @TableField(exist = false)
  private List<ProductImage> productDetailImages;
  @TableField(exist = false)
  private int reviewCount;
  @TableField(exist = false)
  private int saleCount;

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

  public void setCid(Long cid) {
    this.cid = cid;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }

  public ProductImage getFirstProductImage() {
    return firstProductImage;
  }

  public void setFirstProductImage(ProductImage firstProductImage) {
    this.firstProductImage = firstProductImage;
  }

  public List<ProductImage> getProductSingleImages() {
    return productSingleImages;
  }

  public void setProductSingleImages(List<ProductImage> productSingleImages) {
    this.productSingleImages = productSingleImages;
  }

  public List<ProductImage> getProductDetailImages() {
    return productDetailImages;
  }

  public void setProductDetailImages(List<ProductImage> productDetailImages) {
    this.productDetailImages = productDetailImages;
  }

  public int getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(int reviewCount) {
    this.reviewCount = reviewCount;
  }

  public int getSaleCount() {
    return saleCount;
  }

  public void setSaleCount(int saleCount) {
    this.saleCount = saleCount;
  }
}
