package com.kdx.serviceImpl;

import com.kdx.dao.FebackDao;
import com.kdx.daoImpl.FebackDaoImpl;
import com.kdx.entity.Feedback;
import com.kdx.service.FebackService;
import com.kdx.util.PageData;

public class FebackServiceImpl implements FebackService {
	private FebackDao fd=new FebackDaoImpl();
	@Override
	public boolean addFeback(Feedback f) {
		// TODO Auto-generated method stub
		return fd.addFeback(f);
	}

	@Override
	public boolean delFeback(int feedbackId) {
		// TODO Auto-generated method stub
		return fd.delFeback(feedbackId);
	}

	@Override
	public boolean updateFeback(Feedback f) {
		// TODO Auto-generated method stub
		return fd.updateFeback(f);
	}

	@Override
	public PageData<Feedback> queryFebackByPage(int page, int pageSize,String userId) {
		// TODO Auto-generated method stub
		return fd.queryFebackByPage(page, pageSize,userId);
	}

}
