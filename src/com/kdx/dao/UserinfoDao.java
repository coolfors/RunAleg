package com.kdx.dao;

import java.util.List;

import com.kdx.entity.Userinfo;
import com.kdx.util.PageData;

/**
 * 自定义的UserinfoDao接口
 * 
 * @author Administrator
 *
 */
public interface UserinfoDao {
	
	List<Userinfo> queryUserinfo();
	
	boolean addUserinfo(Userinfo uinfo);// 增加用户信息

	boolean updateUserinfo(Userinfo uinfo);// 更新用户信息
	// PageData queryUserinfoByPageLike(int page, int pageSize, String userName);

	PageData<Userinfo> queryUserinfoByPage(int page, int pageSize);// 分页
	
	Userinfo getUserInfo(int userId);//根据userId获取详细,用于前台显示
}
