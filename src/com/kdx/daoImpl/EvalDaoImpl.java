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
	/**
	 * // user查询已完成订单(评价)
	 * 
	 */
	@Override
	public PageData<Evaluate> queryReceiptcom(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		String sql="SELECT evaluate.evaluateId, evaluate.receiptId, evaluate.evaScore, evaluate.evaInfo, evaluate.evaState FROM evaluate where evaState=1 and userId=?";
		return BaseDao.getPage(sql, page, pageSize,Evaluate.class , userId);
	}

	@Override
	public boolean delEval(int evaluateId) {
		// TODO Auto-generated method stub
		return BaseDao.execute("delete from evaluate where evaluateId = ?", evaluateId) > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageData<Evaluate> queryEvalByPage(int page, int pageSize,String userId) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from evaluate where userId = ?", page, pageSize, Evaluate.class,userId);
	}

	@Override
	public boolean updateEval(Evaluate e) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET receiptId = ?,evaScore = ?,evaInfo = ?  where evaluateId = ?  ";
		return BaseDao.execute(sql, e.getReceiptId(), e.getEvaScore(), e.getEvaInfo(), e.getEvaluateId()) > 0;
	}
	
	/**
	 * courier待评价订单
	 *  
	 */
	@Override
	public PageData<Evaluate> waitEvaluate(int page, int pageSize, String courierId) {
		// TODO Auto-generated method stub
		String sql="SELECT evaluate.evaluateId, evaluate.receiptId, evaluate.evaState FROM evaluate INNER JOIN receipt ON evaluate.receiptId = receipt.receiptId WHERE evaState=0 and courierId=?";
		return BaseDao.getPage(sql, page, pageSize, Evaluate.class, courierId);
	}
	/**
	 * courier已评价订单
	 */
	@Override
	public PageData<Evaluate> overEvaluate(int page, int pageSize, String courierId) {
		// TODO Auto-generated method stub
		String sql="SELECT evaluate.evaluateId, evaluate.receiptId, evaluate.evaState ,evaluate.evaInfo FROM evaluate INNER JOIN receipt ON evaluate.receiptId = receipt.receiptId WHERE evaState=1 and courierId=?";
		return BaseDao.getPage(sql, page, pageSize, Evaluate.class, courierId);
	}
	

}
