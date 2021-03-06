package com.kdx.service;

import java.util.List;

import com.kdx.entity.Evaluate;
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

	boolean updateState(String userId, int sockState);// 改变状态

	boolean updateType(String userId, int userType);// 改变类型

	List<User> queryUsersByName(String userName);

	List<User> queryUsersById(String userId);

	boolean resetPwd(String userId, String userPwd);

	PageData<Evaluate> queryEvalByPage(int page, int pageSize, String userId);

	User getUserById(String userId);

	List<User> againPwd(String userId);

	List<User> findUserType(String userName);// 根据用户名查找用户类型

	boolean changeEval(Evaluate eval);// 增加评价内容

	/**
	 * 用于后台登陆
	 * 
	 * @param username
	 * @param pswsecrite
	 */
	User loginUserAdmin(String username, String pswsecrite);
	
	boolean delWen(String articleId);//临时文章删除
}
