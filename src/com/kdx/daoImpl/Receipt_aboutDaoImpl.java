package com.kdx.daoImpl;

import com.kdx.dao.Receipt_aboutDao;
import com.kdx.entity.Receipt_about;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class Receipt_aboutDaoImpl implements Receipt_aboutDao {

	@Override
	public PageData<Receipt_about> sendReceipt(int page, int pageSize,String courierId) {
		// TODO Auto-generated method stub
		/**
		 * courier配送中
		 * 	 
		 */
		
		String sql="SELECT receipt.disId, userinfo.userTel, dispatch.disTel, receipt.startTime, receipt.encryptionKey, receipt.endTime, receipt.state, receipt.courierAdd, receipt.getDistance, receipt.sendDistance FROM userinfo, dispatch, receipt WHERE receipt.disId = dispatch.disId AND dispatch.userId = userinfo.userId AND dispatch.disState=1 and receipt.state = 1 and  courierId=?";
		return BaseDao.getPage(sql, page, pageSize, Receipt_about.class,courierId);
	}
	/**
	 * courier待配送
	 */
	@Override
	public PageData<Receipt_about> waitsendReceipt(int page, int pageSize, String courierId) {
		// TODO Auto-generated method stub
		String sql="SELECT receipt.disId, userinfo.userTel, dispatch.disTel, receipt.startTime, receipt.encryptionKey, receipt.endTime, receipt.state, receipt.courierAdd, receipt.getDistance, receipt.sendDistance FROM userinfo, dispatch, receipt WHERE receipt.disId = dispatch.disId AND dispatch.userId = userinfo.userId AND dispatch.disState=1 and receipt.state = 0 and  courierId=?";
		return BaseDao.getPage(sql, page, pageSize, Receipt_about.class,courierId);
	}

}
