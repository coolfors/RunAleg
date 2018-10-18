package com.kdx.service;

import java.util.List;

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

	PageData<Userinfo> getUserinfoByPage(int page, int pageSize);// 分页
	
	Userinfo getUserInfo(String userId);//根据useid获取详细信息，前台显示
	
	boolean updateState(String userName, int sockState);// 改变状态
	
	boolean updateUserinfoByQt(Userinfo editInfo);
	
<<<<<<< HEAD
	boolean updateUserinfoBalance(Double balance,String userId);//前台充值
=======
	List<Userinfo> queryUserName();
	
>>>>>>> branch 'master' of https://github.com/coolfors/RunAleg.git
}