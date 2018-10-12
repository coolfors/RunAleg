package com.kdx.entity;

import java.io.Serializable;


/**
 * The persistent class for the evaluate database table.
 * 
 */
public class Evaluate implements Serializable {
	private static final long serialVersionUID = 1L;

	private int evaluateId;//评价id

	private String evaInfo;//订单号

	private int evaScore;//评价分

	private int receiptId;//评价信息
	
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
	
	/**
	 * 无参构造
	 */
	public Evaluate() {
	}
	
	/**
	 * 有参构造
	 * @param evaluateId
	 * @param evaInfo
	 * @param evaScore
	 * @param receiptId
	 */
	public Evaluate(int evaluateId, String evaInfo, int evaScore, int receiptId) {
		super();
		this.evaluateId = evaluateId;
		this.evaInfo = evaInfo;
		this.evaScore = evaScore;
		this.receiptId = receiptId;
	}

	@Override
	public String toString() {
		return "Evaluate [evaluateId=" + evaluateId + ", evaInfo=" + evaInfo + ", evaScore=" + evaScore + ", receiptId="
				+ receiptId + "]";
	}

	

	
}