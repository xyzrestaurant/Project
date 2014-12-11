package com.example.bean;

public class ItemBean {
    private String itemNo;
    private String itemName;
    private String description;
    private Double price;
    private String status;
    private int qty;
    
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemno) {
		itemNo = itemno;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemname) {
		itemName = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String Description) {
		description = Description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double Price) {
		price = Price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String Status) {
		status = Status;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
    
    
}
