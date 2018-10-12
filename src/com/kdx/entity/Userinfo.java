package com.kdx.entity;

import java.io.Serializable;


/**
 * The persistent class for the userinfo database table.
 * 
 */
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userInfoId;
	
	private int userId;

	private String userAdd;

	private double userBalance;

	private String userSex;

	private String userTel;
	
	public Userinfo() {
	}

	public int getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getUserAdd() {
		return this.userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	public double getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Userinfo(int userInfoId, int userId, String userAdd, double userBalance, String userSex, String userTel) {
		super();
		this.userInfoId = userInfoId;
		this.userId = userId;
		this.userAdd = userAdd;
		this.userBalance = userBalance;
		this.userSex = userSex;
		this.userTel = userTel;
	}

	@Override
	public String toString() {
		return "Userinfo [userInfoId=" + userInfoId + ", userId=" + userId + ", userAdd=" + userAdd + ", userBalance="
				+ userBalance + ", userSex=" + userSex + ", userTel=" + userTel + "]";
	}

	
	
	
	

}