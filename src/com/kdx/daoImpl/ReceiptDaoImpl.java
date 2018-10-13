package com.kdx.daoImpl;

import com.kdx.dao.ReceiptDao;
import com.kdx.entity.Receipt;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class ReceiptDaoImpl implements ReceiptDao {
	/**
	 * 查询订单所有信息
	 */
	@Override
	public PageData<Receipt> queryReceipt(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from receipt";
		@SuppressWarnings("unchecked")
		PageData<Receipt> pd = BaseDao.getPage(sql, page, pageSize, Receipt.class);
		return pd;
	}
	
	/**
	 * 查询已完成订单
	 */
	@Override
	public PageData<Receipt> queryReceiptcom(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from receipt where state=2";
		@SuppressWarnings("unchecked")
		PageData<Receipt> pd = BaseDao.getPage(sql, page, pageSize, Receipt.class);
		return pd;
	}

	/**
	 * 根据接单号修改，订单信息
	 */

	@Override
	public boolean updateReceipt(Receipt r) {
		// TODO Auto-generated method stub
		String sql = "update receipt set courierId=?,disId=?,encryptionKey=?,startTime=?,endTime=?,state=?,courierAdd=?,getDistance=?,sendDistance=? where receiptId=?";
		return BaseDao.execute(sql, r.getCourierId(), r.getDisId(), r.getEncryptionKey(), r.getStartTime(),
				r.getEndTime(), r.getState(), r.getCourierAdd(), r.getGetDistance(), r.getSendDistance(),
				r.getReceiptId()) > 0;

	}

	/**
	 * 增加订单信息
	 */
	@Override
	public boolean addReceipt(Receipt r) {
		// TODO Auto-generated method stub
		String sql = "insert into receipt values(null,?,?,?,?,?,?,?,?,?)";
		return BaseDao.execute(sql, r.getCourierId(), r.getDisId(), r.getEncryptionKey(), r.getStartTime(),
				r.getEndTime(), r.getState(), r.getCourierAdd(), r.getGetDistance(), r.getSendDistance()) > 0;
	}

	/**
	 * 根据接单号删除订单信息
	 */
	@Override
	public boolean delReceipt(int receiptId) {
		// TODO Auto-generated method stub
		String sql = "delete from receipt where receiptId=?";
		return BaseDao.execute(sql, receiptId) > 0;
	}
	/**
	 * 待送订单，订单状态为0
	 */
	@Override
	public PageData<Receipt> waitSendReceipt(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from receipt where state = 0";
		@SuppressWarnings("unchecked")
		PageData<Receipt> pd = BaseDao.getPage(sql, page, pageSize, Receipt.class);
		return pd;
	}
	/**
	 * 待修改订单，订单状态为1
	 */
	@Override
	public PageData<Receipt> waitUpdateReceipt(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from receipt where state = 1";
		@SuppressWarnings("unchecked")
		PageData<Receipt> pd = BaseDao.getPage(sql, page, pageSize, Receipt.class);
		return pd;
	}
	/**
	 * 待配送订单 state=1
	 */
	@Override
	public PageData<Receipt> Receiptdispatch(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from receipt where state = 1";
		@SuppressWarnings("unchecked")
		PageData<Receipt> pd = BaseDao.getPage(sql, page, pageSize, Receipt.class);
		return pd;
	}

}
