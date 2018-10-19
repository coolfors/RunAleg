package com.kdx.test;

import java.util.List;

import com.kdx.dao.DispatchDao;
import com.kdx.daoImpl.DispatchDaoImpl;
import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		AffairService as = new AffairServiceImpl();
		String courierId = IDNumber.getIDNumber();//生成跑腿编号
		String userId = "KDX2018101733697";
		String balance = "0.00";
		String tel = "18888888888";
		String address = "大北京";
		String realIDcard = null; 
		String userName = "sadjki";
		Courier cour = new Courier(courierId, address,Double.parseDouble(balance), realIDcard,tel, userId, userName);
		boolean flag = as.toBeCourier(cour);
		System.out.println(flag);*/
		DispatchDao dd=new DispatchDaoImpl();
		PageData<Dispatch> pd=dd.queryDispatch(1, 5, "KDX2018101881846");
		List<Dispatch> list=pd.getData();
		for (Dispatch dispatch : list) {
			System.out.println(dispatch);
		}
	}
}
