package com.kdx.dao;

import java.util.List;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchDao {
	List<Dispatch> getDispatch();

	boolean addDispatch(Dispatch dis);

	boolean updateDispatch(Dispatch dis);

	PageData<Dispatch> queryDispatch(int page, int pageSize);// courier所有订单

	PageData<Dispatch> waitSendDispatch(int page, int pageSize);// 待配送订单
	boolean updateState(String disId, int state);// 改变状态
	List<String> getBeginAndEnaAdd(String disId);
	PageData<Dispatch> queryDispatch(int page,int pageSize,String userId);//user 用户的所有订单(显示自己的所有订单)
}
