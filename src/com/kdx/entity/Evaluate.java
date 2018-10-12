package com.kdx.entity;

import java.io.Serializable;


/**
 * The persistent class for the evaluate database table.
 * 
 */
public class Evaluate implements Serializable {
	private static final long serialVersionUID = 1L;

	private int evaluateId;//评价id

	private int receiptId;//订单号
	
	private int evaScore;//评价分
	
	private String evaInfo;//评价信息
	
	private int evaState;//评价状态
	
	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public int getEvaluateId() {
		return this.evaluateId;
	}

	public void setEvaluateId(int evaluateId) {
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
	public Evaluate(int evaluateId, int receiptId, int evaScore, String evaInfo, int evaState) {
		super();
		this.evaluateId = evaluateId;
		this.receiptId = receiptId;
		this.evaScore = evaScore;
		this.evaInfo = evaInfo;
		this.evaState = evaState;
	}

	@Override
	public String toString() {
		return "Evaluate [evaluateId=" + evaluateId + ", evaInfo=" + evaInfo + ", evaScore=" + evaScore + ", receiptId="
				+ receiptId + "]";
	}

	
}