package com.kdx.entity;

import java.io.Serializable;

/**
 * The persistent class for the user database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;

	private int sockState;

	private String userdate;

	private String userName;

	private String userPwd;

	private int userType;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSockState() {
		return this.sockState;
	}

	public void setSockState(int sockState) {
		this.sockState = sockState;
	}

	public String getUserdate() {
		return this.userdate;
	}

	public void setUserdate(String userdate) {
		this.userdate = userdate;
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

	public User(int userId,String userName, String userPwd, int userType ,int sockState, String userdate ) {
		super();
		this.userId = userId;
		this.sockState = sockState;
		this.userdate = userdate;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}

	

	public User( String userName, String userPwd, int sockState, int userType,String userdate) {
		super();
		this.sockState = sockState;
		this.userdate = userdate;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", sockState=" + sockState + ", userdate=" + userdate + ", userName="
				+ userName + ", userPwd=" + userPwd + ", userType=" + userType + "]";
	}

	

}