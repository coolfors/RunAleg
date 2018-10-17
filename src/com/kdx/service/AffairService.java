package com.kdx.service;

import com.kdx.entity.Courier;
import com.kdx.entity.User;

public interface AffairService {
	boolean addUserAndInfo(User u);
	//升级为Courier
		boolean toBeCourier(Courier cour);
}
