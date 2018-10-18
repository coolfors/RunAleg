package com.kdx.serviceImpl;

import java.util.List;

import com.kdx.dao.UserinfoDao;
import com.kdx.daoImpl.UserinfoDaoImpl;
import com.kdx.entity.Userinfo;
import com.kdx.service.UserinfoService;
import com.kdx.util.PageData;

/**
 * UserinfoService接口的实现类
 * 
 * @author Administrator
 *
 */
public class UserinfoServiceImpl implements UserinfoService {
	// 创建对象
	UserinfoDao uid = new UserinfoDaoImpl();

	// 增加用户信息
	@Override
	public boolean addUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		return uid.addUserinfo(uinfo);
	}

	// 更新用户信息
	@Override
	public boolean updateUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		return uid.updateUserinfo(uinfo);
	}

	// 分页
	@Override
	public PageData<Userinfo> getUserinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return uid.queryUserinfoByPage(page, pageSize);

	}

	@Override
	public List<Userinfo> getUserinfo() {
		// TODO Auto-generated method stub
		return uid.queryUserinfo();
	}

	@Override
	public Userinfo getUserInfo(String userId) {
		// TODO Auto-generated method stub
		return uid.getUserInfo(userId);
	}

	@Override
	public boolean updateState(String userName, int sockState) {
		// TODO Auto-generated method stub
		return uid.changeState(userName, sockState);
	}

	@Override
	public boolean updateUserinfoByQt(Userinfo editInfo) {
		// TODO Auto-generated method stub
		return uid.updateUserinfoByQt(editInfo);
	}

	@Override
	public List<Userinfo> queryUserName() {
		// TODO Auto-generated method stub
		return uid.queryUserName();
	}

}
