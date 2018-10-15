package com.kdx.daoImpl;

import java.util.Iterator;
import java.util.List;

import com.kdx.dao.CourierDao;
import com.kdx.entity.Courier;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

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
	//根据id,获取courier全部信息，用于前台显示
	@Override
	public Courier getCourierById(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from courier where userid = ?";
		@SuppressWarnings("unchecked")
		List<Courier> list = (List<Courier>) BaseDao.select(sql, Courier.class, userId);
		Iterator<Courier> it = list.iterator();
		Courier courier = null;
		while(it.hasNext()) {
			courier = it.next();
		}
		return courier;
	}

}
