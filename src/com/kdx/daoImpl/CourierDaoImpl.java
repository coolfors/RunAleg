package com.kdx.daoImpl;

import com.kdx.dao.CourierDao;
import com.kdx.entity.Courier;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class CourierDaoImpl implements CourierDao {

	@Override
	public boolean addCourier(Courier cour) {
		// TODO Auto-generated method stub
		return BaseDao.execute("insert into courier values(null,?,?,?,?,?,?,?,?,?,?)", cour.getUserId(),
				cour.getDeposit(),cour.getBalance(),cour.getTel(),cour.getAbleDistance(),cour.getSockState(),
				cour.getIdImg(),cour.getCreditPoint(),cour.getIDcard(),cour.getAddress())>0;
	}

	@Override
	public boolean updateCourier(Courier cour) {
		// TODO Auto-generated method stub
		return BaseDao.execute("update courier set deposit=?,balance=?,Tel=?,ableDistance=?,sockState=?,"
				+ "idImg=?,creditPoint=?,IDcard=?,address=? where courierId=?", cour.getDeposit(),cour.getBalance(),cour.getTel(),
				cour.getAbleDistance(),cour.getSockState(),cour.getIdImg(),cour.getCreditPoint(),cour.getIDcard(),
				cour.getAddress(),cour.getCourierId())>0;
	}

	@Override
	public PageData<Courier> queryCourier(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from courier", page, pageSize, Courier.class);
	}

}
