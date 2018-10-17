package com.kdx.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the feedback database table.
 * 
 */
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	private String feedbackId;

	private String feedbackInfo;

	private String userId;

	private String managerAns;

	public Feedback() {
	}

	public String getmanagerAns() {
		return managerAns;
	}

	public void setmanagerAns(String managerAns) {
		this.managerAns = managerAns;
	}

	public String getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackInfo() {
		return this.feedbackInfo;
	}

	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Feedback(String feedbackId, String feedbackInfo, String userId, String managerAns) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackInfo = feedbackInfo;
		this.userId = userId;
		this.managerAns = managerAns;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackInfo=" + feedbackInfo + ", userId=" + userId
				+ ", managerAns=" + managerAns + "]";
	}

	

}