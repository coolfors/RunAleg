package com.kdx.serviceImpl;

import com.kdx.dao.DispatchDao;
import com.kdx.entity.Dispatch;
import com.kdx.util.PageData;

public class DispatchServiceImpl implements DispatchDao {
	DispatchDao dd=new DispatchServiceImpl();
	@Override
	public boolean addDispatch(Dispatch dis) {
		// TODO Auto-generated method stub
		return dd.addDispatch(dis);
	}

	@Override
	public boolean updateDispatch(Dispatch dis) {
		// TODO Auto-generated method stub
		return dd.updateDispatch(dis);
	}

	@Override
	public PageData<Dispatch> queryDispatch(int page, int pageSize) {
		// TODO Auto-generated method stub
		return dd.queryDispatch(page, pageSize);
	}

}
