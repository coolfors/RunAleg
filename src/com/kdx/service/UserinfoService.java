package com.kdx.service;

import java.util.List;

import com.kdx.entity.User;
import com.kdx.entity.Userinfo;
import com.kdx.util.PageData;

/**
 * 自定义的UserinfoService接口
 * 
 * @author Administrator
 *
 */
public interface UserinfoService {
	
	List<Userinfo> getUserinfo();
	
	boolean addUserinfo(Userinfo uinfo);// 增加用户信息

	boolean updateUserinfo(Userinfo uinfo);// 更新用户信息

	PageData getUserinfoByPage(int page, int pageSize);// 分页
}
