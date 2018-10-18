package com.kdx.entity;

import java.io.Serializable;


/**
 * The persistent class for the evaluate database table.
 * 
 */
public class Evaluate implements Serializable {
	private static final long serialVersionUID = 1L;

	private String evaluateId;//评价id

	private String receiptId;//订单号
	
	private String userId;//订单号
	
	private int evaScore;//评价分
	
	private String evaInfo;//评价信息
	
	private int evaState;//评价状态
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getEvaluateId() {
		return this.evaluateId;
	}

	public void setEvaluateId(String evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getEvaInfo() {
		return this.evaInfo;
	}

	public void setEvaInfo(String evaInfo) {
		this.evaInfo = evaInfo;
	}

	public int getEvaScore() {
		return this.evaScore;
	}

	public void setEvaScore(int evaScore) {
		this.evaScore = evaScore;
	}
	
	public int getEvaState() {
		return evaState;
	}

	public void setEvaState(int evaState) {
		this.evaState = evaState;
	}
	
	/**
	 * 无参构造
	 */
	public Evaluate() {
	}
	
	/**
	 * 有参构造
	 * @param evaluateId
	 * @param receiptId
	 * @param evaScore
	 * @param evaInfo
	 * @param evaState
	 */
	public Evaluate(String evaluateId, String receiptId, int evaScore, String evaInfo, int evaState) {
		super();
		this.evaluateId = evaluateId;
		this.receiptId = receiptId;
		this.evaScore = evaScore;
		this.evaInfo = evaInfo;
		this.evaState = evaState;
	}
	
	

	public Evaluate(String evaluateId, String receiptId, String userId, int evaScore, String evaInfo, int evaState) {
		super();
		this.evaluateId = evaluateId;
		this.receiptId = receiptId;
		this.userId = userId;
		this.evaScore = evaScore;
		this.evaInfo = evaInfo;
		this.evaState = evaState;
	}

	@Override
	public String toString() {
		return "Evaluate [evaluateId=" + evaluateId + ", receiptId=" + receiptId + ", userId=" + userId + ", evaScore="
				+ evaScore + ", evaInfo=" + evaInfo + ", evaState=" + evaState + "]";
	}

	

	
}