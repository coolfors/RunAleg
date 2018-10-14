package com.kdx.dao;

import java.util.List;

import com.kdx.entity.Courier;
import com.kdx.util.PageData;

public interface CourierDao {
	
	List<Courier> getCourier();
	
	boolean addCourier(Courier cour);

	boolean updateCourier(Courier cour);

	PageData<Courier> queryCourier(int page, int pageSize);
}
