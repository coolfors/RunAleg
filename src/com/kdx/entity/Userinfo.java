package com.kdx.entity;

import java.io.Serializable;


/**
 * The persistent class for the userinfo database table.
 * 
 */
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userInfoId;//详情信息id
	
	private String userId;//用户id

	private String userAdd;//用户地址

	private double userBalance;//用户余额

	private String userSex;//用户性别

	private String userTel;//用户手机
	
	private String userName;//用户名
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Userinfo() {
	}

	public String getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(String userInfoId) {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Userinfo(String userInfoId, String userId, String userAdd, double userBalance, String userSex, String userTel) {
		super();
		this.userInfoId = userInfoId;
		this.userId = userId;
		this.userAdd = userAdd;
		this.userBalance = userBalance;
		this.userSex = userSex;
		this.userTel = userTel;
	}
	
	
		
	public Userinfo(String userId, String userAdd, double userBalance, String userSex, String userTel) {
		super();
		this.userId = userId;
		this.userAdd = userAdd;
		this.userBalance = userBalance;
		this.userSex = userSex;
		this.userTel = userTel;
	}

	@Override
	public String toString() {
		return "Userinfo [userInfoId=" + userInfoId + ", userId=" + userId + ", userAdd=" + userAdd + ", userBalance="
				+ userBalance + ", userSex=" + userSex + ", userTel=" + userTel + ", userName=" + userName
				+ "]";
	}
}