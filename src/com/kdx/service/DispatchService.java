package com.kdx.service;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchService {
	
	boolean addDispatch(Dispatch dis);
	
	boolean updateDispatch(Dispatch dis);
	
	PageData<Dispatch> queryDispatch(int page,int pageSize);
	
	PageData<Dispatch> waitSendDispatch(int page,int pageSize);
}
