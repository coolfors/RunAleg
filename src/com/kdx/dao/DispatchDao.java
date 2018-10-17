package com.kdx.dao;

import java.util.List;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchDao {
	List<Dispatch> getDispatch();

	boolean addDispatch(Dispatch dis);//添加订单

	boolean updateDispatch(Dispatch dis);

	PageData<Dispatch> queryDispatch(int page, int pageSize);// 所有订单

	PageData<Dispatch> waitSendDispatch(int page, int pageSize);// 待配送订单
}
