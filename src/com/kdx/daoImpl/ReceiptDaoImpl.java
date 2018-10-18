package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdx.dao.ReceiptDao;
import com.kdx.entity.Dispatch;
import com.kdx.entity.Receipt;
import com.kdx.entity.User;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;
import com.kdx.util.UUIDUtils;

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
	 * user待送订单(根据用户自己的userId来查询)
	 */
	@Override
	public PageData<Receipt> waitSendReceipt(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		String sql="SELECT receipt.disId, courier.tel, receipt.encryptionKey, receipt.startTime, receipt.endTime, receipt.courierAdd, receipt.state, receipt.getDistance, receipt.sendDistance FROM receipt INNER JOIN courier ON receipt.courierId = courier.courierId WHERE receipt.state=0 and courier.userId=?";
		return BaseDao.getPage(sql, page, pageSize, Receipt.class, userId);
	}
	/**
	 *  user配送中的订单(根据用户自己的userId来查询)
	 *   
	 */
	@Override
	public PageData<Receipt> sendReceipt(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		String sql="SELECT receipt.disId, courier.tel, receipt.encryptionKey, receipt.startTime, receipt.endTime, receipt.courierAdd, receipt.state, receipt.getDistance, receipt.sendDistance FROM receipt INNER JOIN courier ON receipt.courierId = courier.courierId WHERE receipt.state=1 and courier.userId=?";
		
		return BaseDao.getPage(sql, page, pageSize, Receipt.class, userId);
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

	@Override
	public List<Receipt> getReceipt() {
		// TODO Auto-generated method stub
		String sql = "SELECT receipt.receiptId,receipt.encryptionKey,user.userName,receipt.disId,receipt.startTime,receipt.endTime,receipt.state,receipt.courierAdd,receipt.getDistance,receipt.sendDistance FROM (receipt,user) INNER JOIN courier ON courier.userId=user.userId AND receipt.courierId=courier.courierId";
		return (List<Receipt>) BaseDao.select(sql, Receipt.class);
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@Override
	public boolean changeState(String disId, String receiptId) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();

		boolean flag = false;
		try {
			// 在java中可以对支持事务的数据库完成事务的处理
			conn.setAutoCommit(false);

			// 执行更新receipt的操作
			String sql1 = "update receipt set state='2' where disId =  ?";
			BaseDao.execute(sql1, conn, disId);

			// 执行更新receipt的操作
			String sql2 = "update dispatch set disState='2' where disId =  ?";
			BaseDao.execute(sql2, conn, disId);
			// 生成待评价订单
			String evaluateId = UUIDUtils.getUUID();
			System.out.println(evaluateId);
			String sql3 = "insert into evaluate(evaluateId,receiptId,evaState) values (?,?,0)";
			BaseDao.execute(sql3, conn, evaluateId, receiptId);
			String sql4 = "SELECT * FROM dispatch where disId = ?";
			// dispatch.disPrice
			List<Dispatch> list = (List<Dispatch>) BaseDao.select(sql4, conn, Dispatch.class, disId);

			double price = list.get(0).getDisPrice();

			String userId = list.get(0).getUserId();

			// 完成转账
			String sql5 = "update userinfo set userBalance= userBalance - ? where userId =  ? ";
			BaseDao.execute(sql5, conn, price, userId);

			String sql6 = "update courier set balance= balance + ? where userId =  ? ";
			BaseDao.execute(sql6, conn, price, userId);
			// 手动提交
			conn.commit();
			flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			conn.rollback();
			e.printStackTrace();
		} finally {
			return flag;
		}
	}

}
