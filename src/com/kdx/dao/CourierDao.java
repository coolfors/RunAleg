package com.kdx.dao;

import java.util.List;

import com.kdx.entity.Courier;
import com.kdx.util.PageData;

public interface CourierDao {
	
	List<Courier> getCourier();
	
	boolean addCourier(Courier cour);

	boolean updateCourier(Courier cour);

	PageData<Courier> queryCourier(int page, int pageSize);
	
	//根据id,获取courier全部信息，用于前台显示
	Courier getCourierById(String userId);
	
	String getCourierAdd(String courierId);
	
	boolean updateAdd(String courierId,String add);
	//前台修改腿哥信息
	boolean updateCourierInForward(Courier cour);
	

}
