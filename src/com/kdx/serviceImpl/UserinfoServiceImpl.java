package com.kdx.serviceImpl;

import com.kdx.dao.UserinfoDao;
import com.kdx.daoImpl.UserinfoDaoImpl;
import com.kdx.entity.Userinfo;
import com.kdx.service.UserinfoService;
import com.kdx.util.PageData;

public class UserinfoServiceImpl implements UserinfoService {
	//创建对象
	UserinfoDao uid= new UserinfoDaoImpl();
	@Override
	public boolean addUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		return uid.addUserinfo(uinfo);
	}

	@Override
	public boolean updateUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		return uid.updateUserinfo(uinfo);
	}

	@Override
	public PageData getUserinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return uid.queryUserinfoByPage(page, pageSize);
		
	}

}
