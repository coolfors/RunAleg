package com.etc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the dispatch database table.
 * 
 */
public class Dispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	private int disId;

	private int userId;

	private String beginAdd;

	private double disPrice;

	private String disPS;

	private int disState;

	private int disTel;

	private String endAdd;

	private String goodsType;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Dispatch() {
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

	public int getDisTel() {
		return this.disTel;
	}

	public void setDisTel(int disTel) {
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


	public Dispatch(int disId, int userId, String beginAdd, double disPrice, String disPS, int disState, int disTel,
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

	@Override
	public String toString() {
		return "Dispatch [disId=" + disId + ", userId=" + userId + ", beginAdd=" + beginAdd + ", disPrice=" + disPrice
				+ ", disPS=" + disPS + ", disState=" + disState + ", disTel=" + disTel + ", endAdd=" + endAdd
				+ ", goodsType=" + goodsType + "]";
	}

}