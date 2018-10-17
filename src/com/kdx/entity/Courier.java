package com.kdx.entity;

import java.io.Serializable;

/**
 * The persistent class for the courier database table.
 * 
 */
public class Courier implements Serializable {
	private static final long serialVersionUID = 1L;

	private String courierId;

	private double ableDistance;

	private String address;

	private double balance;

	private int creditPoint;

	private double deposit;

	private String IDcard;

	private String idImg;

	private int sockState;

	private String tel;

	private String userId;

	private String userName;

	public Courier() {
	}

	public String getCourierId() {
		return this.courierId;
	}

	public void setCourierId(String courierId) {
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
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
	public Courier(String courierId, double ableDistance, String address, double balance, int creditPoint, double deposit,
			String iDcard, String idImg, int sockState, String Tel, String userId) {
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
		this.tel = Tel;
		this.userId = userId;
	}

	public Courier(String courierId, double ableDistance, String address, double balance, int creditPoint, double deposit,
			String iDcard, int sockState, String tel, String userName) {
		super();
		this.courierId = courierId;
		this.ableDistance = ableDistance;
		this.address = address;
		this.balance = balance;
		this.creditPoint = creditPoint;
		this.deposit = deposit;
		IDcard = iDcard;
		this.sockState = sockState;
		this.tel = tel;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Courier [courierId=" + courierId + ", ableDistance=" + ableDistance + ", address=" + address
				+ ", balance=" + balance + ", creditPoint=" + creditPoint + ", deposit=" + deposit + ", IDcard="
				+ IDcard + ", idImg=" + idImg + ", sockState=" + sockState + ", tel=" + tel + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}
	/**
	 * 前台修改腿哥信息
	 * @param ableDistance
	 * @param address
	 * @param tel
	 * @param userId
	 */
	public Courier(double ableDistance, String address, String tel, String userId) {
		super();
		this.ableDistance = ableDistance;
		this.address = address;
		this.tel = tel;
		this.userId = userId;
	}
	/**
	 * 用户升级为跑腿
	 * @param courierId
	 * @param address
	 * @param balance
	 * @param iDcard
	 * @param idImg
	 * @param tel
	 * @param userId
	 * @param userName
	 */
	public Courier(String courierId, String address, double balance, String iDcard, String tel,String idImg,
			String userId, String userName) {
		super();
		this.courierId = courierId;
		this.address = address;
		this.balance = balance;
		IDcard = iDcard;
		this.idImg = idImg;
		this.tel = tel;
		this.userId = userId;
		this.userName = userName;
	}
	
	
	
	

}