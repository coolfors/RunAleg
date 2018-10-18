package com.kdx.service;

import com.kdx.entity.Feedback;
import com.kdx.util.PageData;

public interface FebackService {
	boolean addFeback(Feedback f);
	
	boolean delFeback(int feedbackId);
	
	boolean updateFeback(Feedback f);
	
	PageData<Feedback> queryFebackByPage(int page,int pageSize,String userId);
}
