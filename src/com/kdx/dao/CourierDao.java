package com.kdx.dao;

import com.kdx.entity.Courier;
import com.kdx.util.PageData;

public interface CourierDao {
	boolean addCourier(Courier cour);
	boolean updateCourier(Courier cour);
	PageData<Courier> queryCourier(int page,int pageSize);
}
