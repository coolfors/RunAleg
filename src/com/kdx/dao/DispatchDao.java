package com.kdx.dao;

import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public interface DispatchDao {
	boolean addDispatch(Dispatch dis);
	boolean updateDispatch(Dispatch dis);
	PageData<Dispatch> queryDispatch(int page,int pageSize);
}
