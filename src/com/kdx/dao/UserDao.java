package com.kdx.dao;
import java.util.List;

import com.kdx.entity.User;

public interface UserDao {
	boolean addUser(User user);
	boolean updateUser(User user);
	List<User> queryUser();
	User loginUser(String userName,String userPwd);

}
