package com.kdx.service;

import com.kdx.entity.User;
import com.kdx.util.PageData;

public interface UserService {
	boolean addUser(User user);
	boolean updateUser(User user);
	PageData getUsersByPage(int page, int pageSize);
	User loginUser(String userName,String userPwd);

}
