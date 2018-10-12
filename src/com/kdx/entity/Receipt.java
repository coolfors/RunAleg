package com.kdx.entity;

import java.io.Serializable;

/**
 * The persistent class for the receipt database table.
 * 
 */
public class Receipt implements Serializable {
	private static final long serialVersionUID = 1L;

	private int receiptId;//接单号

	private int courierId;//配送员id
	
	private int disId;//派单号
	
	private String encryptionKey;//订单号加密码

	private String startTime;//起送时间
	
	private String endTime;//结束时间
	
	private String courierAdd;//配送员位置
	
	private double getDistance;//配送员到起送点的距离

	private double sendDistance;//从起送点到目的地的距离

	private int state;//状态

	public Receipt() {
	}

	public int getReceiptId() {
		return this.receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public String getCourierAdd() {
		return this.courierAdd;
	}

	public void setCourierAdd(String courierAdd) {
		this.courierAdd = courierAdd;
	}

	public String getEncryptionKey() {
		return this.encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public double getGetDistance() {
		return this.getDistance;
	}

	public void setGetDistance(double getDistance) {
		this.getDistance = getDistance;
	}

	public double getSendDistance() {
		return this.sendDistance;
	}

	public void setSendDistance(double sendDistance) {
		this.sendDistance = sendDistance;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	@Override
	public String toString() {
		return "Receipt [receiptId=" + receiptId + ", courierAdd=" + courierAdd + ", encryptionKey=" + encryptionKey
				+ ", endTime=" + endTime + ", getDistance=" + getDistance + ", sendDistance=" + sendDistance
				+ ", startTime=" + startTime + ", state=" + state + ", courierId=" + courierId + ", disId=" + disId
				+ "]";
	}

	public Receipt(String courierAdd, String encryptionKey, String endTime, double getDistance, double sendDistance,
			String startTime, int state, int courierId, int disId) {
		super();
		this.courierAdd = courierAdd;
		this.encryptionKey = encryptionKey;
		this.endTime = endTime;
		this.getDistance = getDistance;
		this.sendDistance = sendDistance;
		this.startTime = startTime;
		this.state = state;
		this.courierId = courierId;
		this.disId = disId;
	}

	public Receipt(int receiptId, int courierId, int disId, String encryptionKey, String startTime, String endTime, int state, String courierAdd, double getDistance,
			double sendDistance) {
		super();
		this.receiptId = receiptId;
		this.courierAdd = courierAdd;
		this.encryptionKey = encryptionKey;
		this.endTime = endTime;
		this.getDistance = getDistance;
		this.sendDistance = sendDistance;
		this.startTime = startTime;
		this.state = state;
		this.courierId = courierId;
		this.disId = disId;
	}
	public Receipt(int receiptId, String courierAdd, String encryptionKey, String endTime, double getDistance,
			double sendDistance, String startTime, int state, int courierId, int disId) {
		super();
		this.receiptId = receiptId;
		this.courierAdd = courierAdd;
		this.encryptionKey = encryptionKey;
		this.endTime = endTime;
		this.getDistance = getDistance;
		this.sendDistance = sendDistance;
		this.startTime = startTime;
		this.state = state;
		this.courierId = courierId;
		this.disId = disId;
	}

}