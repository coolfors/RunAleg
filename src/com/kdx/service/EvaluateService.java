package com.kdx.service;

import com.kdx.entity.Evaluate;
import com.kdx.util.PageData;

public interface EvaluateService {
	
	boolean addEval(Evaluate e);// 新增评价

	boolean delEval(int evaluateId);// 删除评价

	boolean updateEval(Evaluate e);// 修改评价1

	PageData<Evaluate> queryEvalByPage(int page, int pageSize);// 查询所有评价

	PageData<Evaluate> waitEval(int page, int pageSize);// 待评价订单

	PageData<Evaluate> overEval(int page, int pageSize,String userId);// 已评价订单
	PageData<Evaluate> waitEvaluate(int page, int pageSize,String courierId);// courier待评价订单
	PageData<Evaluate> overEvaluate(int page, int pageSize,String courierId);// courier已评价订单
	
}
