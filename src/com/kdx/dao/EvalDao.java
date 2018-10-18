package com.kdx.dao;

import com.kdx.entity.Evaluate;
import com.kdx.util.PageData;

public interface EvalDao {

	boolean addEval(Evaluate e);// 新增评价

	boolean delEval(int evaluateId);// 删除评价

	boolean updateEval(Evaluate e);// 修改评价

	PageData<Evaluate> queryEvalByPage(int page, int pageSize,String userId);// 查询所有评价

	PageData<Evaluate> waitEval(int page, int pageSize,String userId);// 待评价订单

	PageData<Evaluate> overEval(int page, int pageSize,String userId);// 已评价订单
}
