package com.kdx.serviceImpl;

import com.kdx.dao.CourierDao;
import com.kdx.daoImpl.CourierDaoImpl;
import com.kdx.entity.Courier;
import com.kdx.service.CourierService;
import com.kdx.util.PageData;

public class CourierServiceImpl implements CourierService {
	CourierDao cd=new CourierDaoImpl();
	@Override
	public boolean addCourier(Courier cour) {
		// TODO Auto-generated method stub
		return cd.addCourier(cour);
	}

	@Override
	public boolean updateCourier(Courier cour, int courId) {
		// TODO Auto-generated method stub
		return cd.updateCourier(cour, courId);
	}

	@Override
	public PageData<Courier> queryCourier(int page, int pageSize) {
		// TODO Auto-generated method stub
		return cd.queryCourier(page, pageSize);
	}

}
