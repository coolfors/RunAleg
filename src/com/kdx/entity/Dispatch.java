package com.kdx.entity;

import java.io.Serializable;

/**
 * The persistent class for the dispatch database table.
 * 
 */
public class Dispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	private int disId;// 派单id

	private int userId;// 用户id

	private String userName;// 用户名

	private String beginAdd;// 起送地点

	private String endAdd;// 目的地点

	private String disTel;// 用户联系电话

	private double disPrice;// 配送价格

	private String goodsType;// 物品类型

	private String disPS;// 物品介绍

	private int disState;// 派单状态

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDisId() {
		return this.disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	public String getBeginAdd() {
		return this.beginAdd;
	}

	public void setBeginAdd(String beginAdd) {
		this.beginAdd = beginAdd;
	}

	public double getDisPrice() {
		return this.disPrice;
	}

	public void setDisPrice(double disPrice) {
		this.disPrice = disPrice;
	}

	public String getDisPS() {
		return this.disPS;
	}

	public void setDisPS(String disPS) {
		this.disPS = disPS;
	}

	public int getDisState() {
		return this.disState;
	}

	public void setDisState(int disState) {
		this.disState = disState;
	}

	

	public String getDisTel() {
		return disTel;
	}

	public void setDisTel(String disTel) {
		this.disTel = disTel;
	}

	public String getEndAdd() {
		return this.endAdd;
	}

	public void setEndAdd(String endAdd) {
		this.endAdd = endAdd;
	}

	public String getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	
	
	/**
	 * 无参构造
	 */
	public Dispatch() {
	}

	/**
	 * 有参构造
	 * 
	 * @param disId
	 * @param userId
	 * @param beginAdd
	 * @param disPrice
	 * @param disPS
	 * @param disState
	 * @param disTel
	 * @param endAdd
	 * @param goodsType
	 */
	public Dispatch(int disId, int userId, String beginAdd, double disPrice, String disPS, int disState, String disTel,
			String endAdd, String goodsType) {
		super();
		this.disId = disId;
		this.userId = userId;
		this.beginAdd = beginAdd;
		this.disPrice = disPrice;
		this.disPS = disPS;
		this.disState = disState;
		this.disTel = disTel;
		this.endAdd = endAdd;
		this.goodsType = goodsType;
	}

	/**
	 * 有参构造 用于用户下订单
	 * @param userId
	 * @param userName
	 * @param beginAdd
	 * @param endAdd
	 * @param disTel
	 * @param disPrice
	 * @param goodsType
	 * @param disPS
	 * @param disState
	 */
	public Dispatch(int userId, String beginAdd,String endAdd,String disPS,String disTel,String goodsType,double disPrice,
			 int disState) {
		super();
		this.userId = userId;

		this.beginAdd = beginAdd;
		this.endAdd = endAdd;
		this.disTel = disTel;
		this.disPrice = disPrice;
		this.goodsType = goodsType;
		this.disPS = disPS;
		this.disState = disState;
	}

	@Override
	public String toString() {
		return "Dispatch [disId=" + disId + ", userId=" + userId + ", userName=" + userName + ", beginAdd=" + beginAdd
				+ ", endAdd=" + endAdd + ", disTel=" + disTel + ", disPrice=" + disPrice + ", goodsType=" + goodsType
				+ ", disPS=" + disPS + ", disState=" + disState + "]";
	}

	

}