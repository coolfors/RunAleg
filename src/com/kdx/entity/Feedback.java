package com.kdx.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the feedback database table.
 * 
 */
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	private int feedbackId;

	private String feedbackInfo;

	private int userId;

	public Feedback() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackInfo() {
		return this.feedbackInfo;
	}

	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Feedback(int feedbackId, String feedbackInfo, int userId) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackInfo = feedbackInfo;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackInfo=" + feedbackInfo + ", userId=" + userId + "]";
	}

}