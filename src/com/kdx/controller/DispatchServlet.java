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
import com.kdx.entity.Dispatch;
import com.kdx.entity.User;
import com.kdx.service.DispatchService;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.util.IDNumber;
import com.kdx.util.MD5Util;
import com.kdx.util.MyDataTableData;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/DispatchServlet" })

public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建UserService对象
	private DispatchService ds = new DispatchServiceImpl();
	private UserService us = new UserServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatchServlet() {
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
		// 处理请求编码:切记，处理请求第一件事情就是设置请求编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");// 相应编码
		// String v=request.getParameter("表单中的文本名，select名字等等/参数名"); 接收请求参数的值
		String op = request.getParameter("op");
		response.setContentType("application/json");

		if (op.equals("sock")) {
			String disId = request.getParameter("disId");
			String disState = request.getParameter("disState");
			boolean flag = ds.updateState(disId, Integer.valueOf(disState));
			PrintWriter out = response.getWriter();
			out.print(flag);
		}
		
		if ("suPwd".equals(op)) {
			String userId = request.getParameter("userId");// 用户id
			
			String userPwd = request.getParameter("surepwd");// 用户输入的支付密码
			
			userPwd = MD5Util.getEncodeByMd5(userPwd);
			
			List<User> list = us.againPwd(userId);
			
			boolean flag = false;
			
			if((list.get(0).getUserPwd()).equals(userPwd)) {
				
				flag = true;
				
			}
			PrintWriter out = response.getWriter();
			
			out.print(flag);
		}
		if (op.equals("edit")) {
//			 String userId = request.getParameter("userId");
//			 String userName = request.getParameter("userName");
//			 String userPwd = request.getParameter("userPwd");
//			 String sockState = request.getParameter("sockState");
//			 String userType = request.getParameter("userType");
//			 String userDate = request.getParameter("userDate");
//			 User u = new User(Integer.valueOf(userId), Integer.valueOf(sockState),
//			 userDate, userName, userPwd,
//			 Integer.valueOf(userType));
//			 boolean flag = us.updateUser(u);
//			 PrintWriter out = response.getWriter();
//			 out.print(flag);
		}
		else if (op.equals("addDispatch")) {
			
			String disId = IDNumber.getIDNumber();//得到编号
			
			String userId = request.getParameter("userId");// 用户id

			String beginAdd = request.getParameter("beginAdd");// 起送地点

			String endAdd = request.getParameter("endAdd");// 目的 地点

			String disTel = request.getParameter("disTel");// 用户联系电话

			String disPrice = request.getParameter("disPrice");// 配送价格

			String goodsType = request.getParameter("goodsType");// 物品类型

			String disPS = request.getParameter("disPS");// 物品介绍

			//String disState = request.getParameter("disState");// 派单状态
			
			//String surepwd = request.getParameter("surepwd");// 用户输入的支付密码
			// 创建对象
			Dispatch dis = new Dispatch(disId, userId, beginAdd, endAdd, disTel, Double.parseDouble(disPrice),
					goodsType, disPS, 0);
			boolean flag = ds.addDispatch(dis);
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		// 查询并返回所有数据 的格式要注意咯
		List<Dispatch> list = ds.getDispatch();

		MyDataTableData<Dispatch> mydata = new MyDataTableData<Dispatch>();
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
