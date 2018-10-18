package com.kdx.dao;

import com.kdx.entity.Feedback;
import com.kdx.util.PageData;

public interface FebackDao {

	boolean addFeback(Feedback f);
	
	boolean delFeback(int feedbackId);
	
	boolean updateFeback(Feedback f);
	
	PageData<Feedback> queryFebackByPage(int page,int pageSize,String userId);
}
