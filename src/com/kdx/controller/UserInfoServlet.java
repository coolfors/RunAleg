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
import com.kdx.entity.Userinfo;
import com.kdx.service.UserinfoService;
import com.kdx.serviceImpl.UserinfoServiceImpl;
import com.kdx.util.MyDataTableData;

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

		if (op.equals("findName")) {

			List<Userinfo> list = uis.queryUserName();

			Gson gson = new Gson();

			String jsonList = gson.toJson(list);

			PrintWriter out = response.getWriter();

			out.print(jsonList);

			out.close();

		}

		if (op.equals("sock")) {
			String userName = request.getParameter("userName");
			String sockState = request.getParameter("sockState");
			boolean flag = uis.updateState(userName, Integer.valueOf(sockState));
			PrintWriter out = response.getWriter();
			out.print(flag);
		}
		if (op.equals("edit")) {

			String userInfoId = request.getParameter("userInfoId");
			String userName = request.getParameter("userName");
			String userTel = request.getParameter("userTel");
			String userAdd = request.getParameter("userAdd");
			String userBalance = request.getParameter("userBalance");
			String userSex = request.getParameter("userSex");

			Userinfo uinfo = new Userinfo(userInfoId, userAdd, Double.valueOf(userBalance), userSex,
					userTel, userName);

			boolean flag = uis.updateUserinfo(uinfo);
			PrintWriter out = response.getWriter();
			out.print(flag);
		}
		
		if ("add".equals(op)) {

			addUser(request, response);
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		response.setCharacterEncoding("utf-8");

		response.setContentType("application/json");

		String userId = request.getParameter("userName");

		String userAdd = request.getParameter("userAdd");

		String userBalance = request.getParameter("userBalance");

		String userSex = request.getParameter("userSex");

		String userTel = request.getParameter("userTel");

		Userinfo uif = new Userinfo(userId, userAdd, Double.valueOf(userBalance), userSex, userTel);

		boolean flag = uis.addUserinfo(uif);

		PrintWriter out = response.getWriter();

		out.print(flag);

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
		String op = request.getParameter("op");
		// 查询并返回所有数据 的格式要注意咯
		List<Userinfo> list = uis.getUserinfo();
		MyDataTableData<Userinfo> mydata = new MyDataTableData<Userinfo>();
		mydata.setData(list);
		// 返回json对象
		String jsonString = new Gson().toJson(mydata);
		PrintWriter out = response.getWriter();
		out.print(jsonString);	
		if (("userinfoEdit").equals(op)){
			request.getSession().removeAttribute("");
			String userInfoId = request.getParameter("userInfoId");
			String userInfoSex = request.getParameter("sexInfo");
			String userTel = request.getParameter("userTelInfo");
			String userAdd = request.getParameter("userAddInfo");		
			Userinfo editInfo = new Userinfo(userInfoId,userTel, userAdd, userInfoSex);		
			// userDate, userName, userPwd,
			// Integer.valueOf(userType));
			boolean flag = uis.updateUserinfoByQt(editInfo);
			if(flag) {
				request.getSession().removeAttribute("Userinfo");
				Userinfo userInfo = uis.getUserInfo(userInfoId);
				request.getSession().setAttribute("Userinfo",userInfo);
				request.getRequestDispatcher("userMessage.jsp").forward(request, response);
			}
		}
	}

}
