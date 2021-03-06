package com.kdx.serviceImpl;

import java.util.List;

import com.kdx.dao.DispatchDao;
import com.kdx.daoImpl.DispatchDaoImpl;
import com.kdx.entity.Dispatch;
import com.kdx.service.DispatchService;
import com.kdx.util.PageData;

public class DispatchServiceImpl implements DispatchService {
	DispatchDao dd = new DispatchDaoImpl();

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

	@Override
	public PageData<Dispatch> waitSendDispatch(int page, int pageSize) {
		// TODO Auto-generated method stub
		return dd.waitSendDispatch(page, pageSize);
	}

	@Override
	public List<Dispatch> getDispatch() {
		// TODO Auto-generated method stub
		return dd.getDispatch();
	}

	@Override
	public List<String> getBeginAndEnaAdd(String disId) {
		// TODO Auto-generated method stub
		return dd.getBeginAndEnaAdd(disId);
	}
	//user 用户的所有订单(显示自己的所有订单)
		@Override
		public PageData<Dispatch> queryDispatch(int page, int pageSize, String userId) {
			// TODO Auto-generated method stub
			return dd.queryDispatch(page, pageSize, userId);
		}



	@Override
	public boolean updateState(String disId, int disState) {
		// TODO Auto-generated method stub
		return dd.updateState(disId, disState);
	}
	@Override
	public Dispatch getOne(String disId) {
		// TODO Auto-generated method stub
		return dd.getOne(disId);
	}

}
