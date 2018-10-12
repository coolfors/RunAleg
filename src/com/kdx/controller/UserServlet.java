package com.kdx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kdx.entity.User;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.util.MyDataTableData;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/us.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		String op = request.getParameter("op");
		if (op.equals("edit")) {
			String userId = request.getParameter("userId");
			String userName = request.getParameter("userName");
			String userPwd = request.getParameter("userPwd");
			String sockState = request.getParameter("sockState");
			String userType = request.getParameter("userType");
			String userDate = request.getParameter("userDate");
			User u = new User(Integer.valueOf(userId), Integer.valueOf(sockState), userDate, userName, userPwd,
					Integer.valueOf(userType));
			boolean flag = us.updateUser(u);
			PrintWriter out = response.getWriter();
			out.print(flag);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		// 查询并返回所有数据 的格式要注意咯
		List<User> list = us.getUser();

		MyDataTableData<User> mydata = new MyDataTableData<User>();
		mydata.setData(list);

		// 返回json对象
		Gson gson = new Gson();
		String jsonString = new Gson().toJson(mydata);

		System.out.println(jsonString);

		PrintWriter out = response.getWriter();

		out.print(jsonString);

		out.close();
	}

}
