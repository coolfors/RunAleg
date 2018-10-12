package com.kdx.dao;
import java.util.List;

import com.kdx.entity.User;
import com.kdx.util.PageData;

public interface UserDao {
	boolean addUser(User user);
	boolean updateUser(User user);
	PageData queryUserByPage(int page, int pageSize);
	User loginUser(String userName,String userPwd);
	List<User> queryUser();

}
