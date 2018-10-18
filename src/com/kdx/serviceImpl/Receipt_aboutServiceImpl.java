package com.kdx.serviceImpl;

import com.kdx.dao.Receipt_aboutDao;
import com.kdx.daoImpl.Receipt_aboutDaoImpl;
import com.kdx.entity.Receipt_about;
import com.kdx.service.Receipt_aboutService;
import com.kdx.util.PageData;

public class Receipt_aboutServiceImpl implements Receipt_aboutService {
		Receipt_aboutDao rad=new Receipt_aboutDaoImpl();
	/**
	 * courier配送中	
	 */
	@Override
	public PageData<Receipt_about> sendReceipt(int page, int pageSize,String  courierId) {
		// TODO Auto-generated method stub
		return rad.sendReceipt(page, pageSize,courierId);
	}
	/**
	 * courier待配送
	 */
	@Override
	public PageData<Receipt_about> waitsendReceipt(int page, int pageSize, String courierId) {
	// TODO Auto-generated method stub
	return rad.waitsendReceipt(page, pageSize, courierId);
	}

}
