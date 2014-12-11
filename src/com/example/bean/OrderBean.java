package com.example.bean;

import java.sql.Date;
import java.util.ArrayList;

public class OrderBean {
  private String orderNo;	
  private ArrayList<ItemBean> itemList = new ArrayList<ItemBean>();
  private Double totalAmount;
  private Date orderdate;
  private String status;
  public String getOrderNo() {
	return orderNo;
  }
  public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
  }
  public ArrayList<ItemBean> getItemList() {
    	return itemList;
  }
  public void setItemList(ArrayList<ItemBean> itemList) {
	  this.itemList = itemList;
  }
  public Double getTotalAmount() {
	 return totalAmount;
  }
  public void setTotalAmount(Double totalAmount) {
	 this.totalAmount = totalAmount;
  }
  public Date getOrderdate() {
	return orderdate;
  }
  public void setOrderdate(Date orderdate) {
	this.orderdate = orderdate;
  }
  public String getStatus() {
	return status;
  }
  public void setStatus(String status) {
	this.status = status;
  }
  
  
}
