package com.kdx.dao;

import com.kdx.entity.User;
import com.kdx.entity.Userinfo;
/**
 * 事务
 * @author benny
 *
 */
public interface AffairDao {
	//注册
	boolean addUserAndInfo(User u);
	//升级为Courier
	boolean toBeCourier(Userinfo u);
}
