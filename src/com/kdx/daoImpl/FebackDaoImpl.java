package com.kdx.daoImpl;

import com.kdx.dao.FebackDao;
import com.kdx.entity.Evaluate;
import com.kdx.entity.Feedback;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class FebackDaoImpl implements FebackDao {

	@Override
	public boolean addFeback(Feedback f) {
		// TODO Auto-generated method stub
		String sql = "insert into feedback(userId,feedbackInfo) values( ?, ? )";
		return BaseDao.execute(sql, f.getUserId(), f.getFeedbackInfo()) > 0;
	}

	@Override
	public boolean delFeback(int feedbackId) {
		// TODO Auto-generated method stub
		return BaseDao.execute("delete from feedback where feedbackId = ?", feedbackId) > 0;
	}

	@Override
	public boolean updateFeback(Feedback f) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET userId = ?,feedbackInfo = ? where feedbackId = ?  ";
		return BaseDao.execute(sql, f.getUserId(), f.getFeedbackInfo(), f.getFeedbackId()) > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageData<Feedback> queryFebackByPage(int page, int pageSize,int userId) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from feedback where userId=?", page, pageSize, Feedback.class,userId);
	}

}
