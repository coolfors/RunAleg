package com.kdx.entity;

import java.io.Serializable;

/**
 * The persistent class for the user database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;//用户id，唯一，无论派单还是跑腿都是唯一的

	private int sockState;//跑腿用户权限

	private String userDate;//注册日期

	private String userName;//用户名

	private String userPwd;//密码

	private int userType;//注册类型
	
	/*private int userTel;//用户手机*/
	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSockState() {
		return this.sockState;
	}

	public void setSockState(int sockState) {
		this.sockState = sockState;
	}

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserType() {
		return this.userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
/*	public int getUserTel() {
		return userTel;
	}

	public void setUserTel(int userTel) {
		this.userTel = userTel;
	}*/
	/**
	 * 
	 * @param userId
	 * @param sockState
	 * @param userDate
	 * @param userName
	 * @param userPwd
	 * @param userType
	 */
	public User(String userId, int sockState, String userDate, String userName, String userPwd, int userType) {
		super();
		this.userId = userId;
		this.sockState = sockState;
		this.userDate = userDate;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}
	/**
	 * 
	 * @param sockState
	 * @param userDate
	 * @param userName
	 * @param userPwd
	 * @param userType
	 */
	public User(int sockState, String userDate, String userName, String userPwd, int userType) {
		super();
		this.sockState = sockState;
		this.userDate = userDate;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}

	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", sockState=" + sockState + ", userDate=" + userDate + ", userName="
				+ userName + ", userPwd=" + userPwd + ", userType=" + userType + "]";
	}

	/**
	 * 用户注册
	 * @param userDate  注册时间	
	 * @param userName	用户名	
	 * @param userPwd	密码
	 * @param userType	注册类型
	 */
	public User(String userName, String userPwd, int userType,String userDate) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.userDate = userDate;
	}

	public User(String userId, String userDate, String userName) {
		super();
		this.userId = userId;
		this.userDate = userDate;
		this.userName = userName;
	}

	
}