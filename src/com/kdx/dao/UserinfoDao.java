package com.kdx.dao;

import com.kdx.entity.Userinfo;
import com.kdx.util.PageData;

public interface UserinfoDao {
	boolean addUserinfo(Userinfo uinfo);
	boolean updateUserinfo(Userinfo uinfo);
	//PageData queryUserinfoByPageLike(int page, int pageSize, String userName);
	PageData queryUserinfoByPage(int page, int pageSize);
}
