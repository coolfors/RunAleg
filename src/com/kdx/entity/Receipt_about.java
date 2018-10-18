package com.kdx.entity;

public class Receipt_about {
	private int disId;// 派单号
	
	private String disTel;//收货人电话
	
	private String userName;// 配送员名称

	private String userTel;// 用户电话

	private String encryptionKey;// 订单号加密码

	private String startTime;// 起送时间

	private String endTime;// 结束时间

	private String courierAdd;// 配送员位置

	private double getDistance;// 配送员到起送点的距离

	private double sendDistance;// 从起送点到目的地的距离

	private int state;// 状态

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	public String getDisTel() {
		return disTel;
	}

	public void setDisTel(String disTel) {
		this.disTel = disTel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCourierAdd() {
		return courierAdd;
	}

	public void setCourierAdd(String courierAdd) {
		this.courierAdd = courierAdd;
	}

	public double getGetDistance() {
		return getDistance;
	}

	public void setGetDistance(double getDistance) {
		this.getDistance = getDistance;
	}

	public double getSendDistance() {
		return sendDistance;
	}

	public void setSendDistance(double sendDistance) {
		this.sendDistance = sendDistance;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Receipt_about(int disId, String disTel, String userName, String userTel, String encryptionKey,
			String startTime, String endTime, String courierAdd, double getDistance, double sendDistance, int state) {
		super();
		this.disId = disId;
		this.disTel = disTel;
		this.userName = userName;
		this.userTel = userTel;
		this.encryptionKey = encryptionKey;
		this.startTime = startTime;
		this.endTime = endTime;
		this.courierAdd = courierAdd;
		this.getDistance = getDistance;
		this.sendDistance = sendDistance;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Receipt_about [disId=" + disId + ", disTel=" + disTel + ", userName=" + userName + ", userTel="
				+ userTel + ", encryptionKey=" + encryptionKey + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", courierAdd=" + courierAdd + ", getDistance=" + getDistance + ", sendDistance=" + sendDistance
				+ ", state=" + state + "]";
	}

	public Receipt_about() {
		
	}

}
