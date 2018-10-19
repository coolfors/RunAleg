package com.kdx.serviceImpl;

import com.kdx.dao.EvalDao;
import com.kdx.daoImpl.EvalDaoImpl;
import com.kdx.entity.Evaluate;
import com.kdx.service.EvaluateService;
import com.kdx.util.PageData;

public class EvaluateServiceImpl implements EvaluateService {
	private EvalDao ed = new EvalDaoImpl();

	@Override
	public boolean addEval(Evaluate e) {
		// TODO Auto-generated method stub
		return ed.addEval(e);
	}

	@Override
	public boolean delEval(int evaluateId) {
		// TODO Auto-generated method stub
		return ed.delEval(evaluateId);
	}

	@Override
	public boolean updateEval(Evaluate e) {
		// TODO Auto-generated method stub
		return ed.updateEval(e);
	}

	@Override
	public PageData<Evaluate> queryEvalByPage(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		return ed.queryEvalByPage(page, pageSize, userId);
	}
	
	/**
	 * courier已评价订单
	 */
	@Override
	public PageData<Evaluate> overEvaluate(int page, int pageSize, String courierId) {
		// TODO Auto-generated method stub
		return ed.overEvaluate(page, pageSize, courierId);
	}
	/**
	 * courier待评价订单
	 */
	@Override
	public PageData<Evaluate> waitEvaluate(int page, int pageSize, String courierId) {
		// TODO Auto-generated method stub
		return ed.waitEvaluate(page, pageSize, courierId);
	}
	

}
