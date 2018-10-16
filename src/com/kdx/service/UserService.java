package com.kdx.service;

import java.util.List;

import com.kdx.entity.User;
import com.kdx.util.PageData;

/**
 * 自定义的UserService接口
 * 
 * @author Administrator
 *
 */
public interface UserService {
	List<User> getUser();

	boolean addUser(User user);// 增加用户

	boolean updateUser(User user);// 更新用户

	PageData<User> getUsersByPage(int page, int pageSize);// 分页

	User loginUser(String userName, String userPwd);// 用户登录
	

}
