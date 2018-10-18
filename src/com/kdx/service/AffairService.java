package com.kdx.service;

import com.kdx.entity.Courier;
import com.kdx.entity.User;

public interface AffairService {
	/**
	 * 注册用户后添加用户信息
	 * @param u
	 * @return
	 */
	boolean addUserAndInfo(User u);
	/**
	 * 跑腿员接单后修改派单状态并建立订单信息
	 * @param disId
	 * @param courierId
	 * @return
	 */
	boolean buildeReceipt(String disId,String courierId,double getGoodsDistance,double sendGoodsDistance);

	//升级为Courier
	boolean toBeCourier(Courier cour);
}
