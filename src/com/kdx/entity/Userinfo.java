package com.kdx.entity;

import java.io.Serializable;


/**
 * The persistent class for the userinfo database table.
 * 
 */
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userInfoId;//详情信息id
	
	private int userId;//用户id

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
	
	
		
	public Userinfo(int userId, String userAdd, double userBalance, String userSex, String userTel) {
		super();
		this.userId = userId;
		this.userAdd = userAdd;
		this.userBalance = userBalance;
		this.userSex = userSex;
		this.userTel = userTel;
	}

	/**
	 * 前台修改个人信息
	 * @param userId
	 * @param userSex
	 * @param userTel
	 * @param userAdd
	 */
	public Userinfo(int userId,  String userTel, String userAdd,String userSex) {
		super();
		this.userId = userId;
		this.userAdd = userAdd;
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