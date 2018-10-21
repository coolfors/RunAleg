package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.kdx.dao.CourierDao;
import com.kdx.entity.Courier;
import com.kdx.entity.Dispatch;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;
import com.kdx.util.UUIDUtils;

public class CourierDaoImpl implements CourierDao {

	@Override
	public boolean addCourier(Courier cour) {
		// TODO Auto-generated method stub
		return BaseDao.execute("insert into courier values(null,?,?,?,?,?,?,?,?,?,?)", cour.getUserId(),
				cour.getDeposit(), cour.getBalance(), cour.getTel(), cour.getAbleDistance(), cour.getSockState(),
				cour.getIdImg(), cour.getCreditPoint(), cour.getIDcard(), cour.getAddress()) > 0;
	}

	@Override
	public boolean updateCourier(Courier cour) {
		// TODO Auto-generated method stub
		return BaseDao.execute(
				"update courier set deposit=?,balance=?,Tel=?,ableDistance=?,sockState=?,"
						+ "idImg=?,creditPoint=?,IDcard=?,address=? where courierId=?",
				cour.getDeposit(), cour.getBalance(), cour.getTel(), cour.getAbleDistance(), cour.getSockState(),
				cour.getIdImg(), cour.getCreditPoint(), cour.getIDcard(), cour.getAddress(), cour.getCourierId()) > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageData<Courier> queryCourier(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from courier", page, pageSize, Courier.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Courier> getCourier() {
		// TODO Auto-generated method stub
		String sql = "SELECT courier.courierId,user.userName,courier.deposit,courier.balance,courier.tel,courier.ableDistance,courier.sockState,courier.creditPoint,courier.IDcard,courier.address FROM courier INNER JOIN user ON courier.userId=user.userId";
		return (List<Courier>) BaseDao.select(sql, Courier.class);
	}

	// 根据id,获取courier全部信息，用于前台显示
	@Override
	public Courier getCourierById(String userId) {
		// TODO Auto-generated method stub
		String sql = "select * from courier where userId = ?";
		@SuppressWarnings("unchecked")
		List<Courier> list = (List<Courier>) BaseDao.select(sql, Courier.class, userId);
		Iterator<Courier> it = list.iterator();
		Courier courier = null;
		while (it.hasNext()) {
			courier = it.next();
			System.out.println("daoimpl:" + courier);
		}
		return courier;
	}

	@Override
	public String getCourierAdd(String courierId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Courier> list = (List<Courier>) BaseDao.select("select * from courier where courierId=?", Courier.class,
				courierId);
		Courier cour = null;
		Iterator<Courier> it = list.iterator();
		if (it.hasNext()) {
			cour = it.next();
		}
		return cour.getAddress();
	}

	@Override
	public boolean updateAdd(String courierId, String add) {
		// TODO Auto-generated method stub
		return BaseDao.execute("update courier set address=? where courierId=?", add, courierId) > 0;
	}

	/**
	 * 跑腿前台修改
	 */
	@Override
	public boolean updateCourierInForward(Courier cour) {
		// TODO Auto-generated method stub
		String sql = "update courier set Tel=?,ableDistance=?,address=? where userId=?";
		return BaseDao.execute(sql, cour.getTel(), cour.getAbleDistance(), cour.getAddress(), cour.getUserId()) > 0;

	}

	@Override
	public boolean changeState(String courierId, int sockState) {
		// TODO Auto-generated method stub
		String sql = "update courier set sockState=? where courierId=?";
		return BaseDao.execute(sql, sockState, courierId) > 0;
	}

	@Override
	public Courier getCourierByCourierId(String courierId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Courier> list = (List<Courier>) BaseDao.select("select * from courier where courierId=?", Courier.class,
				courierId);
		Iterator<Courier> it = list.iterator();
		Courier cour = null;
		cour = it.next();
		return cour;
	}

	@Override
	public boolean topUpBalance(Double balance, String userId) {
		// TODO Auto-generated method stub
		String sql = "update courier set balance = balance + ? where userId = ?";
		return BaseDao.execute(sql, balance, userId) > 0;
	}

	@SuppressWarnings("finally")
	@Override
	public boolean getState(String disId) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();

		boolean flag = false;
		try {
			// 在java中可以对支持事务的数据库完成事务的处理
			conn.setAutoCommit(false);

			// 执行更新receipt的操作
			String sql1 = "update receipt set state='1' where disId =  ?";
			BaseDao.execute(sql1, conn, disId);

			// 执行更新receipt的操作
			String sql2 = "update dispatch set disState='1' where disId =  ?";
			BaseDao.execute(sql2, conn, disId);

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
