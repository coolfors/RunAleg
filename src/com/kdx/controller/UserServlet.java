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
import com.kdx.entity.User;
import com.kdx.service.DispatchService;
import com.kdx.service.EvaluateService;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.serviceImpl.EvaluateServiceImpl;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.util.MyDataTableData;
import com.kdx.util.PageData;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/us.action" })

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建UserService对象
	private DispatchService ds = new DispatchServiceImpl();
	private EvaluateService es = new EvaluateServiceImpl();
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
		// 处理请求编码:切记，处理请求第一件事情就是设置请求编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");// 相应编码
		// String v=request.getParameter("表单中的文本名，select名字等等/参数名"); 接收请求参数的值
		String op = request.getParameter("op");
		response.setContentType("application/json");
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
		if ("allDispatch".equals(op)) {// getUsersByPage

			allDispatch(request, response);
		} else if ("waitSendDispatch".equals(op)) {
			waitSendDispatch(request, response);
		} else if ("waitEvaluate".equals(op)) {
			waitEvaluate(request, response);
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
		List<User> list = us.getUser();

		MyDataTableData<User> mydata = new MyDataTableData<User>();
		mydata.setData(list);

		// 返回json对象
		@SuppressWarnings("unused")
		Gson gson = new Gson();
		String jsonString = new Gson().toJson(mydata);

		System.out.println(jsonString);

		PrintWriter out = response.getWriter();

		out.print(jsonString);

		out.close();
	}

	/**
	 * 所有订单-dispatch所有内容
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void allDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;// 默认第一页
		int pageSize = 10;// 默认一页有10条记录
		// 如果用户传递的参数不为空
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		PageData<Dispatch> pd = ds.queryDispatch(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		response.getWriter().println(data);
	}

	/**
	 * 待配送订单-dispatch中disState为0 的内容
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitSendDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;// 默认第一页
		int pageSize = 10;// 默认一页有10条记录
		// 如果用户传递的参数不为空
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		PageData<Dispatch> pd = ds.waitSendDispatch(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		response.getWriter().println(data);
	}

	/**
	 * 待评价订单：evaluate表中evaState为0的内容
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitEvaluate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;// 默认第一页
		int pageSize = 10;// 默认一页有10条记录
		// 如果用户传递的参数不为空
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		PageData<Evaluate> pd = es.waitEval(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		response.getWriter().println(data);

	}

}
