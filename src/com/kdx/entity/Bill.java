package com.kdx.entity;

import java.sql.Date;

public class Bill {
	private String billId;
	private String payerId;
	private String runnerId;
	private double money;
	private Date endDate;
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getPayerId() {
		return payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	public String getRunnerId() {
		return runnerId;
	}
	public void setRunnerId(String runnerId) {
		this.runnerId = runnerId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", payerId=" + payerId + ", runnerId=" + runnerId + ", money=" + money
				+  ", endDate=" + endDate + "]";
	}
	public Bill(String billId, String payerId, String runnerId, double money) {
		super();
		this.billId = billId;
		this.payerId = payerId;
		this.runnerId = runnerId;
		this.money = money;
	}
	public Bill() {
		
	}
}
