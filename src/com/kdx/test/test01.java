package com.kdx.test;

import java.util.List;

import com.google.gson.Gson;
//import com.kdx.dao.Receipt_aboutDao;
//import com.kdx.daoImpl.Receipt_aboutDaoImpl;
import com.kdx.entity.Dispatch;
//import com.kdx.entity.Receipt_about;
import com.kdx.service.DispatchService;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.util.PageData;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<Userinfo> list=(List<Userinfo>) BaseDao.select("select * from userinfo", Userinfo.class);
		System.out.println(list);*/
		//CourierDao cd=new CourierDaoImpl();
		/*PageData<Courier> pd=cd.queryCourier(2, 3);
		List<Courier> list=pd.getData();
		for (Courier courier : list) {
			System.out.println(courier);
		}*/
		//Courier cour=new Courier(0, 10801.0, "天津", 128.2, 123, 500.0, "352211115599987489", "idImg", 0, 1552, 1);
		//System.out.println(cd.addCourier(cour));
		/*int page =1;
		int pageSize = 10;
		DispatchService ds = new DispatchServiceImpl();
		PageData<Dispatch> pd=ds.queryDispatch(page, pageSize);
    	Gson gson = new Gson();
    	String data = gson.toJson(pd);
    	System.out.println(data);*/	
		
//		Receipt_aboutDao rd=new Receipt_aboutDaoImpl();
//		PageData<Receipt_about> pd=rd.disReceipt(1, 5);
//		List<Receipt_about> list=pd.getData();
//		for (Receipt_about receipt_about : list) {
//			System.out.println(receipt_about);
//		}
		
	
	
	}
}
