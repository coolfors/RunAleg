package com.kdx.daoImpl;

import com.kdx.dao.UserinfoDao;
import com.kdx.entity.Userinfo;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class UserinfoDaoImpl implements UserinfoDao {

	@Override
	public boolean addUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		String sql="insert into userinfo values(null,?,?,?,?,?)";
		return BaseDao.execute(sql,uinfo.getUserId(),uinfo.getUserTel(),uinfo.getUserAdd(),uinfo.getUserBalance(),uinfo.getUserSex())>0;
	}

	@Override
	public boolean updateUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		
		return BaseDao.execute("update userinfo set userId=?,userTel=?,userAdd=?,userBalance=?,userSex=? where userInfoId=?", 
				uinfo.getUserId(),uinfo.getUserTel(),uinfo.getUserAdd(),uinfo.getUserBalance(),uinfo.getUserSex(),uinfo.getUserInfoId())>0;
	}

	@Override
	public PageData queryUserinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return  BaseDao.getPage("select * from userinfo", page, pageSize, Userinfo.class);
	}

}
