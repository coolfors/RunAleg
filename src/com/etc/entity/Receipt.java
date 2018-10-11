package com.etc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the receipt database table.
 * 
 */
public class Receipt implements Serializable {
	private static final long serialVersionUID = 1L;

	private int receiptId;

	private String courierAdd;

	private String encryptionKey;

	private String endTime;

	private double getDistance;

	private double sendDistance;

	private String startTime;

	private int state;

	private int courierId;

	private int disId;

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