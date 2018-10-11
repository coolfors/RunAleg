package com.kdx.service;


import com.kdx.entity.Userinfo;
import com.kdx.util.PageData;

public interface UserinfoService {
	boolean addUserinfo(Userinfo uinfo);
	boolean updateUserinfo(Userinfo uinfo);
	PageData getUserinfoByPage(int page, int pageSize);
}
