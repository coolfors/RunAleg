package com.kdx.test;

import java.util.List;

import com.kdx.entity.User;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.util.PageData;

/**
 * 测试User的增加，修改，以及登录和分页的功能
 * @author Administrator
 *
 */
public class testusers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * User u=new User(12,"April","13",1,1,"2018-10-11 14:14:27");
		 * 
		 * UserServiceImpl usi=new UserServiceImpl();
		 * 
		 * //boolean flag=usi.addUser(u); boolean flag=usi.updateUser(u);
		 * 
		 * System.out.println(flag);
		 */
		UserService us = new UserServiceImpl();
		/*
		 * PageData<User> pd=us.getUsersByPage(3, 4); List<User> list=pd.getData(); for
		 * (User user : list) { System.out.println(user); }
		 */
		User u=us.loginUser("老王", "12345");
		System.out.println(u);

	}

}
