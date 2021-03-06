package com.kdx.service;

import java.util.List;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchService {

	List<Dispatch> getDispatch();

	boolean addDispatch(Dispatch dis);

	boolean updateDispatch(Dispatch dis);

	PageData<Dispatch> queryDispatch(int page, int pageSize);//courier 所有订单

	PageData<Dispatch> waitSendDispatch(int page, int pageSize);
	
	List<String> getBeginAndEnaAdd(String disId);

	boolean updateState(String disId, int disState);// 改变状态

	PageData<Dispatch> queryDispatch(int page,int pageSize,String userId);//user 用户的所有订单(显示自己的所有订单)

	Dispatch getOne(String disId);//获得一个dispatch对象
}
