package com.kdx.dao;

import com.kdx.entity.Userinfo;
import com.kdx.util.PageData;
/**
 * 自定义的UserinfoDao接口 
 * @author Administrator
 *
 */
public interface UserinfoDao {
	boolean addUserinfo(Userinfo uinfo);//增加用户信息
	boolean updateUserinfo(Userinfo uinfo);//更新用户信息
	//PageData queryUserinfoByPageLike(int page, int pageSize, String userName);
	PageData queryUserinfoByPage(int page, int pageSize);//分页
}
