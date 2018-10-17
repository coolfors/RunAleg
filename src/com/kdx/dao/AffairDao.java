package com.kdx.dao;

import com.kdx.entity.User;

public interface AffairDao {
	boolean addUserAndInfo(User u);
	
	boolean buildeReceipt(String disId,String courierId,double getGoodsDistance,double sendGoodsDistance);
}
