package com.kdx.test;

import com.kdx.entity.Courier;
import com.kdx.service.AffairService;
import com.kdx.serviceImpl.AffairServiceImpl;
import com.kdx.util.IDNumber;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AffairService as = new AffairServiceImpl();
		String courierId = IDNumber.getIDNumber();//生成跑腿编号
		String userId = "KDX2018101733697";
		String balance = "0.00";
		String tel = "18888888888";
		String address = "大北京";
		String realIDcard = null; 
		String userName = "sadjki";
		Courier cour = new Courier(courierId, address,Double.parseDouble(balance), realIDcard,tel, userId, userName);
		boolean flag = as.toBeCourier(cour);
		System.out.println(flag);
	}
}
