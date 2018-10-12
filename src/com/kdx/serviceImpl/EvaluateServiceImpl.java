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
	public PageData<Evaluate> queryEvalByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return ed.queryEvalByPage(page, pageSize);
	}

	@Override
	public PageData<Evaluate> waitEval(int page, int pageSize) {
		// TODO Auto-generated method stub
		return ed.waitEval(page, pageSize);
	}

	@Override
	public PageData<Evaluate> overEval(int page, int pageSize) {
		// TODO Auto-generated method stub
		return ed.overEval(page, pageSize);
	}

}
