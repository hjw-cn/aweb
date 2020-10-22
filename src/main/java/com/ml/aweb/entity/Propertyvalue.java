package com.ml.aweb.entity;


public class Propertyvalue {

  private long id;
  private long pid;
  private long ptid;
  private String value;


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


  public long getPtid() {
    return ptid;
  }

  public void setPtid(long ptid) {
    this.ptid = ptid;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
