package com.ml.aweb.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import org.apache.ibatis.annotations.Many;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Orderitem {

  private long id;
  private long pid;
  private long oid;
  private long uid;


  @ManyToOne
  @JoinColumn(name="pid")
  private Product product;

  @ManyToOne
  @JoinColumn(name="oid")
  private Order order;

  @ManyToOne
  @JoinColumn(name="uid")
  private User user;
  private long number;

  public Orderitem() {
  }


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


  public long getOid() {
    return oid;
  }

  public void setOid(long oid) {
    this.oid = oid;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
