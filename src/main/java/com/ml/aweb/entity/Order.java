package com.ml.aweb.entity;


public class Order {

  private long id;
  private String orderCode;
  private String address;
  private String post;
  private String receiver;
  private String mobile;
  private String userMessage;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp payDate;
  private java.sql.Timestamp deliveryDate;
  private java.sql.Timestamp confirmDate;
  private long uid;
  private String status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }


  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public java.sql.Timestamp getPayDate() {
    return payDate;
  }

  public void setPayDate(java.sql.Timestamp payDate) {
    this.payDate = payDate;
  }


  public java.sql.Timestamp getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(java.sql.Timestamp deliveryDate) {
    this.deliveryDate = deliveryDate;
  }


  public java.sql.Timestamp getConfirmDate() {
    return confirmDate;
  }

  public void setConfirmDate(java.sql.Timestamp confirmDate) {
    this.confirmDate = confirmDate;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
