package com.kdx.service;

import com.kdx.entity.Courier;
import com.kdx.util.PageData;

public interface CourierService {
	boolean addCourier(Courier cour);
	boolean updateCourier(Courier cour);
	PageData<Courier> queryCourier(int page,int pageSize);
}
