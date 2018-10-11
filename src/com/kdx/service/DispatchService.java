package com.kdx.service;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchService {
	boolean addDispatch(Dispatch dis);
	boolean updateDispatch(Dispatch dis,int disId);
	PageData<Dispatch> queryDispatch(int page,int pageSize);
}