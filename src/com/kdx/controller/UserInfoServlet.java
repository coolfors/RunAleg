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
import com.kdx.entity.Evaluate;
import com.kdx.entity.Userinfo;
import com.kdx.service.UserinfoService;
import com.kdx.serviceImpl.UserinfoServiceImpl;
import com.kdx.util.MyDataTableData;
import com.kdx.util.PageData;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserInfoServlet" })

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建UserService对象
	private UserinfoService uis = new UserinfoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
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
			String userName = request.getParameter("userName");
			String sockState = request.getParameter("sockState");
			boolean flag = uis.updateState(userName, Integer.valueOf(sockState));
			PrintWriter out = response.getWriter();
			out.print(flag);
		}
		if (op.equals("edit")) {
			String userInfoId = request.getParameter("userInfoId");
			String userTel = request.getParameter("userTel");
			String userAdd = request.getParameter("userAdd");
			String userBalance = request.getParameter("userBalance");
			String userSex = request.getParameter("userSex");

			Userinfo uinfo = new Userinfo(Integer.valueOf(userInfoId), userAdd, Double.valueOf(userBalance), userSex,
					userTel);

			// userDate, userName, userPwd,
			// Integer.valueOf(userType));
			boolean flag = uis.updateUserinfo(uinfo);
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
		List<Userinfo> list = uis.getUserinfo();

		MyDataTableData<Userinfo> mydata = new MyDataTableData<Userinfo>();
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
