package com.kdx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the courier database table.
 * 
 */
public class Courier implements Serializable {
	private static final long serialVersionUID = 1L;

	private int courierId;

	private double ableDistance;

	private String address;

	private double balance;

	private int creditPoint;

	private double deposit;

	private int IDcard;

	private String idImg;

	private int sockState;

	private int tel;
	
	private int userId;
	

	public Courier() {
	}

	public int getCourierId() {
		return this.courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public double getAbleDistance() {
		return this.ableDistance;
	}

	public void setAbleDistance(double ableDistance) {
		this.ableDistance = ableDistance;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCreditPoint() {
		return this.creditPoint;
	}

	public void setCreditPoint(int creditPoint) {
		this.creditPoint = creditPoint;
	}

	public double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getIDcard() {
		return this.IDcard;
	}

	public void setIDcard(int IDcard) {
		this.IDcard = IDcard;
	}

	public String getIdImg() {
		return this.idImg;
	}

	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}

	public int getSockState() {
		return this.sockState;
	}

	public void setSockState(int sockState) {
		this.sockState = sockState;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public Courier(int courierId, double ableDistance, String address, double balance, int creditPoint, double deposit,
			int iDcard, String idImg, int sockState, int tel, int userId) {
		super();
		this.courierId = courierId;
		this.ableDistance = ableDistance;
		this.address = address;
		this.balance = balance;
		this.creditPoint = creditPoint;
		this.deposit = deposit;
		IDcard = iDcard;
		this.idImg = idImg;
		this.sockState = sockState;
		this.tel = tel;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Courier [courierId=" + courierId + ", ableDistance=" + ableDistance + ", address=" + address
				+ ", balance=" + balance + ", creditPoint=" + creditPoint + ", deposit=" + deposit + ", IDcard="
				+ IDcard + ", idImg=" + idImg + ", sockState=" + sockState + ", tel=" + tel + ", userId=" + userId
				+ "]";
	}

	
	
	


}