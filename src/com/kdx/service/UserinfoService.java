package com.kdx.service;


import com.kdx.entity.Userinfo;
import com.kdx.util.PageData;

public interface UserinfoService {
	boolean addUser(Userinfo uinfo);
	boolean updateUser(Userinfo uinfo);
	PageData getUsersByPage(int page, int pageSize);
}
