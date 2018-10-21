package com.kdx.service;

import java.util.List;

import com.kdx.entity.Courier;
import com.kdx.util.PageData;

public interface CourierService {
	boolean addCourier(Courier cour);

	boolean updateCourier(Courier cour);

	PageData<Courier> queryCourier(int page, int pageSize);

	List<Courier> getCourier();
	
	boolean updateState(String courierId, int sockState);// 改变状态
	
	Courier getCourierById(String userId);//根据id,获取courier全部信息，用于前台显示
	
	String getCourierAdd(String courierId);
	
	boolean updateAdd(String courierId,String add);//更新courier的当前位置信息

	//前台修改腿哥信息
	boolean updateCourierInForward(Courier cour);
	
	Courier getCourierByCourierId(String courierId);
	
	boolean topUpBalance(Double balance,String userId);//跑腿充值余额
	
	boolean getState(String disId);
}
