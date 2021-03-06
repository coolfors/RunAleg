package com.kdx.serviceImpl;

import java.util.List;

import com.kdx.dao.CourierDao;
import com.kdx.daoImpl.CourierDaoImpl;
import com.kdx.entity.Courier;
import com.kdx.service.CourierService;
import com.kdx.util.PageData;

public class CourierServiceImpl implements CourierService {
	CourierDao cd = new CourierDaoImpl();

	@Override
	public boolean addCourier(Courier cour) {
		// TODO Auto-generated method stub
		return cd.addCourier(cour);
	}

	@Override
	public boolean updateCourier(Courier cour) {
		// TODO Auto-generated method stub
		return cd.updateCourier(cour);
	}

	@Override
	public PageData<Courier> queryCourier(int page, int pageSize) {
		// TODO Auto-generated method stub
		return cd.queryCourier(page, pageSize);
	}

	@Override
	public List<Courier> getCourier() {
		// TODO Auto-generated method stub
		return cd.getCourier();
	}

	@Override
	public Courier getCourierById(String userId) {
		// TODO Auto-generated method stub
		return cd.getCourierById(userId);
	}

	@Override
	public String getCourierAdd(String courierId) {
		// TODO Auto-generated method stub
		return cd.getCourierAdd(courierId);
	}

	@Override
	public boolean updateAdd(String courierId, String add) {
		// TODO Auto-generated method stub
		return cd.updateAdd(courierId, add);
	}

	@Override
	public boolean updateCourierInForward(Courier cour) {
		// TODO Auto-generated method stub
		return cd.updateCourierInForward(cour);
	}

	@Override
	public boolean updateState(String courierId, int sockState) {
		// TODO Auto-generated method stub
		return cd.changeState(courierId, sockState);
	}

	@Override
	public Courier getCourierByCourierId(String courierId) {
		// TODO Auto-generated method stub
		return cd.getCourierByCourierId(courierId);
	}

	@Override
	public boolean topUpBalance(Double balance, String userId) {
		// TODO Auto-generated method stub
		return cd.topUpBalance(balance, userId);
	}

	@Override
	public boolean getState(String disId) {
		// TODO Auto-generated method stub
		return cd.getState(disId);
	}
}
