package com.kdx.test;

import com.kdx.dao.CourierDao;
import com.kdx.daoImpl.CourierDaoImpl;
import com.kdx.entity.Courier;

public class TestGetCourierByUserId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CourierDao cd = new CourierDaoImpl();
		Courier courier = cd.getCourierById("16");
		System.out.println(courier);
		
	}

}
