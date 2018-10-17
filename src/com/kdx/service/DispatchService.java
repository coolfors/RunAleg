package com.kdx.service;

import java.util.List;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchService {

	List<Dispatch> getDispatch();
	//添加订单
	boolean addDispatch(Dispatch dis);

	boolean updateDispatch(Dispatch dis);

	PageData<Dispatch> queryDispatch(int page, int pageSize);

	PageData<Dispatch> waitSendDispatch(int page, int pageSize);
}
