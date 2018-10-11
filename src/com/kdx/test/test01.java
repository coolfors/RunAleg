package com.kdx.test;

import java.util.List;

import com.kdx.dao.CourierDao;
import com.kdx.daoImpl.CourierDaoImpl;
import com.kdx.entity.Courier;
import com.kdx.entity.Userinfo;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<Userinfo> list=(List<Userinfo>) BaseDao.select("select * from userinfo", Userinfo.class);
		System.out.println(list);*/
		CourierDao cd=new CourierDaoImpl();
		PageData<Courier> pd=cd.queryCourier(2, 3);
		List<Courier> list=pd.getData();
		for (Courier courier : list) {
			System.out.println(courier);
		}
		
	}

}
