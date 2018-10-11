package com.kdx.dao;

import com.kdx.entity.Evaluate;
import com.kdx.util.PageData;

public interface EvalDao {

	boolean addEval(Evaluate e);
	
	boolean delEval(int evaluateId);
	
	boolean updateEval(Evaluate e);
	
	PageData<Evaluate> queryEvalByPage(int page,int pageSize);
}
