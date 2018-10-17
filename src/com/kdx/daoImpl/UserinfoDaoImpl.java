package com.kdx.daoImpl;

import java.util.Iterator;
import java.util.List;

import com.kdx.dao.UserinfoDao;
import com.kdx.entity.Userinfo;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;
/**
 * 实现UserinfoDao接口的类
 * @author Administrator
 *
 */
public class UserinfoDaoImpl implements UserinfoDao {
	
	//增加用户信息
	@Override
	public boolean addUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		String sql="insert into userinfo values(null,?,?,?,?,?)";
		return BaseDao.execute(sql,uinfo.getUserId(),uinfo.getUserTel(),uinfo.getUserAdd(),uinfo.getUserBalance(),uinfo.getUserSex())>0;
	}
	
	//更新用户信息
	@Override
	public boolean updateUserinfo(Userinfo uinfo) {
		// TODO Auto-generated method stub
		
		return BaseDao.execute("update userinfo set userId=?,userTel=?,userAdd=?,userBalance=?,userSex=? where userInfoId=?", 
				uinfo.getUserId(),uinfo.getUserTel(),uinfo.getUserAdd(),uinfo.getUserBalance(),uinfo.getUserSex(),uinfo.getUserInfoId())>0;
	}
	//更新前台用户信息
	@Override
	public boolean updateUserinfoByQt(Userinfo uinfo) {
		// TODO Auto-generated method stub
		
		return BaseDao.execute("update userinfo set userSex=?,userTel=?,userAdd=? where userId=?", 
				uinfo.getUserSex(),uinfo.getUserTel(),uinfo.getUserAdd(),uinfo.getUserId())>0;
	}
	
	
	//分页
	@SuppressWarnings("unchecked")
	@Override
	public PageData<Userinfo> queryUserinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return  BaseDao.getPage("select * from userinfo", page, pageSize, Userinfo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> queryUserinfo() {
		// TODO Auto-generated method stub
		String sql = "SELECT userinfo.userInfoId,user.userName,userinfo.userTel,userinfo.userAdd,userinfo.userBalance,userinfo.userSex,user.sockState FROM userinfo INNER JOIN user ON userinfo.userId=user.userId";
		return (List<Userinfo>) BaseDao.select(sql, Userinfo.class);
	}
	//根据id获取userinfo详细信息  用于前台显示
	@Override
	public Userinfo getUserInfo(int userId) {
		// TODO Auto-generated method stub
		String sql="select * from userinfo where userid = ?";
		@SuppressWarnings("unchecked")
		List<Userinfo> list = (List<Userinfo>) BaseDao.select(sql, Userinfo.class, userId);
		Iterator<Userinfo> it = list.iterator();
		Userinfo userInfo = null;
		if (it.hasNext()) {
			userInfo = it.next();
		}
		return userInfo;
	}

	@Override
	public boolean changeState(String userName, int sockState) {
		// TODO Auto-generated method stub
		String sql = "update user set sockState=? where userName=?";
		return BaseDao.execute(sql, sockState, userName) > 0;
	}

}
