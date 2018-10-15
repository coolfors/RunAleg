package com.kdx.entity;

import java.io.Serializable;

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

	private String IDcard;

	private String idImg;

	private int sockState;

	private String Tel;

	private int userId;

	private String userName;

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

	public String getIDcard() {
		return this.IDcard;
	}

	public void setIDcard(String IDcard) {
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

	public String getTel() {
		return this.Tel;
	}

	public void setTel(String Tel) {
		this.Tel = Tel;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 显示所有
	 * 
	 * @param courierId
	 * @param ableDistance
	 * @param address
	 * @param balance
	 * @param creditPoint
	 * @param deposit
	 * @param iDcard
	 * @param idImg
	 * @param sockState
	 * @param Tel
	 * @param userId
	 */
	public Courier(int courierId, double ableDistance, String address, double balance, int creditPoint, double deposit,
			String iDcard, String idImg, int sockState, String Tel, int userId) {
		super();
		this.courierId = courierId;
		this.ableDistance = ableDistance;
		this.address = address;
		this.balance = balance;
		this.creditPoint = creditPoint;
		this.deposit = deposit;
		this.IDcard = iDcard;
		this.idImg = idImg;
		this.sockState = sockState;
		this.Tel = Tel;
		this.userId = userId;
	}

	public Courier(int courierId, double ableDistance, String address, double balance, int creditPoint, double deposit,
			String iDcard, int sockState, String Tel, String userName) {
		super();
		this.courierId = courierId;
		this.ableDistance = ableDistance;
		this.address = address;
		this.balance = balance;
		this.creditPoint = creditPoint;
		this.deposit = deposit;
		IDcard = iDcard;
		this.sockState = sockState;
		this.Tel = Tel;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Courier [courierId=" + courierId + ", ableDistance=" + ableDistance + ", address=" + address
				+ ", balance=" + balance + ", creditPoint=" + creditPoint + ", deposit=" + deposit + ", IDcard="
				+ IDcard + ", idImg=" + idImg + ", sockState=" + sockState + ", Tel=" + Tel + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}

}