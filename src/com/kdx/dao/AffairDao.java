package com.kdx.dao;

import com.kdx.entity.Courier;
import com.kdx.entity.User;
/**
 * 事务
 * @author benny
 *
 */
public interface AffairDao {
	//注册
	boolean addUserAndInfo(User u);
	
	boolean buildeReceipt(String disId,String courierId,double getGoodsDistance,double sendGoodsDistance);

	//升级为Courier
	boolean toBeCourier(Courier cour);
}
