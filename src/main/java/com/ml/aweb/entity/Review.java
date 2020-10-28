package com.ml.aweb.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

  private long id;
  private String content;
  @ManyToOne
  @JoinColumn(name="uid")
  private User user;

  @ManyToOne
  @JoinColumn(name="pid")
  private Product product;
  private java.sql.Timestamp createDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }



  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
