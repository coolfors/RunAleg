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
	Courier getCourierById(int userId);
}
