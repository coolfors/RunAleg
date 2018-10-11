package com.kdx.daoImpl;

import com.kdx.dao.EvalDao;
import com.kdx.entity.Evaluate;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class EvalDaoImpl implements EvalDao {

	@Override
	public boolean addEval(Evaluate e) {
		// TODO Auto-generated method stub
		String sql = "insert into evaluate(receiptId,evaScore,evaInfo) values( ?, ? , ?)";
		return BaseDao.execute(sql, e.getReceiptId(), e.getEvaScore(), e.getEvaInfo()) > 0;
	}

	@Override
	public boolean delEval(int evaluateId) {
		// TODO Auto-generated method stub
		return BaseDao.execute("delete from evaluate where evaluateId = ?", evaluateId) > 0;
	}

	@Override
	public PageData<Evaluate> queryEvalByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from evaluate ", page, pageSize, Evaluate.class);
	}

	@Override
	public boolean updateEval(Evaluate e) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET receiptId = ?,evaScore = ?,evaInfo = ?  where evaluateId = ?  ";
		return BaseDao.execute(sql, e.getReceiptId(), e.getEvaScore(), e.getEvaInfo(), e.getEvaluateId()) > 0;
	}

}
