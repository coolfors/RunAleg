package com.kdx.dao;

import java.util.List;

import com.kdx.entity.User;
import com.kdx.util.PageData;

/**
 * 自定义的userdao接口
 * 
 * @author Administrator
 *
 */
public interface UserDao {
	List<User> queryUser();

	boolean addUser(User user);// 增加用户

	boolean updateUser(User user);// 更新用户

	PageData<User> queryUserByPage(int page, int pageSize);// 分页

	User loginUser(String userName, String userPwd);// 用户登录

	boolean changeState(int userId, int sockState);// 改变状态

	boolean changeType(int userId, int userType);// 改变类型
	
	User getUserById(String userId);//根据用户id获取用户
	List<User> queryUserName(String userName);//用户名搜索用户

	List<User> queryUserId(int userId);//查询用户id
	
	boolean resetPwd(int userId, String userPwd);//重置密码
	
	List<User> againPwd(String userId);
}
