package com.kdx.serviceImpl;

import com.kdx.dao.AffairDao;
import com.kdx.daoImpl.AffairDaoImpl;
import com.kdx.entity.User;
import com.kdx.service.AffairService;

public class AffairServiceImpl implements AffairService {
	AffairDao ad=new AffairDaoImpl();
	@Override
	public boolean addUserAndInfo(User u) {
		// TODO Auto-generated method stub
		return ad.addUserAndInfo(u);
	}

}
