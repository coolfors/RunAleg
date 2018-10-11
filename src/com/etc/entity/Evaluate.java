package com.etc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evaluate database table.
 * 
 */
public class Evaluate implements Serializable {
	private static final long serialVersionUID = 1L;

	private int evaluateId;

	private String evaInfo;

	private int evaScore;

	private int receiptId;
	
	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public Evaluate() {
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