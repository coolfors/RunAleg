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
import com.kdx.entity.Receipt;
import com.kdx.entity.User;
import com.kdx.service.DispatchService;
import com.kdx.service.EvaluateService;
import com.kdx.service.ReceiptService;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.serviceImpl.EvaluateServiceImpl;
import com.kdx.serviceImpl.ReceiptServiceImpl;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.util.MyDataTableData;
import com.kdx.util.PageData;

/**
 * Servlet implementation class ReceiptServlet
 */
@WebServlet("/rs.do")
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建对象
	ReceiptServiceImpl rs = new ReceiptServiceImpl();
	private DispatchService ds = new DispatchServiceImpl();
	private EvaluateService es = new EvaluateServiceImpl();
	private UserService us = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceiptServlet() {
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
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取值
		String op = request.getParameter("op");
		if ("completeorder".equals(op)) {// 用户界面已完成订单
			completeorder(request, response);
		} else if ("dispatching".equals(op)) {// 用户界面正在配送中的订单
			dispatching(request, response);
		} else if ("allDispatch".equals(op)) {// getUsersByPage

			allDispatch(request, response);
		} else if ("waitSendDispatch".equals(op)) {
			waitSendDispatch(request, response);

			/*
			 * } else if ("waitEvaluate".equals(op)) { waitEvaluate(request, response);
			 */
		} else if (op.equals("setGetDistance")) {
			setGetDistance(request, response);
		} else if (op.equals("setSendDistance")) {
			setSendDistance(request, response);
		}
		if (op.equals("sock")) {
			String receiptId = request.getParameter("receiptId");
			String state = request.getParameter("state");
			boolean flag = rs.updateState(receiptId, Integer.valueOf(state));
			PrintWriter out = response.getWriter();
			out.print(flag);
		}
		if ("changState".equals(op)) {
			String receiptId = request.getParameter("receiptId");
			String disId = request.getParameter("disId");
			boolean flag = rs.getState(disId, receiptId);
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
		List<Receipt> list = rs.getReceipt();

		MyDataTableData<Receipt> mydata = new MyDataTableData<Receipt>();
		mydata.setData(list);

		// 返回json对象
		Gson gson = new Gson();
		String jsonString = new Gson().toJson(mydata);

		// System.out.println(jsonString);

		PrintWriter out = response.getWriter();

		out.print(jsonString);

		out.close();
	}

	/**
	 * 用户界面显示已完成订单
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void completeorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 6;
		String userId = request.getParameter("userId");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageData<Evaluate> pd = es.queryEvalByPage(page, pageSize, userId);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// request.setAttribute("pd", data);
		// System.out.println(data);

		response.getWriter().println(data);

	}

	/**
	 * 用户界面配送中的订单
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void dispatching(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 6;
		String userId = request.getParameter("userId");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageData<Receipt> pd = rs.sendReceipt(page, pageSize, userId);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		response.getWriter().println(data);

	}

	/**
	 * 所有订单-dispatch自己的所有订单
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
		String userId = request.getParameter("userId");
		if (request.getParameter("pageIndex") != null) {
			page = Integer.parseInt(request.getParameter("pageIndex"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		PageData<Dispatch> pd = ds.queryDispatch(page, pageSize, userId);
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
		String userId = request.getParameter("userId");
		// 如果用户传递的参数不为空
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		PageData<Dispatch> pd = ds.queryDispatch(page, pageSize, userId);
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
	 *//*
		 * protected void waitEvaluate(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub int page = 1;// 默认第一页 int pageSize = 10;// 默认一页有10条记录 //
		 * 如果用户传递的参数不为空
		 * 
		 * String userId=request.getParameter("userId"); if
		 * (request.getParameter("page") != null) { page =
		 * Integer.parseInt(request.getParameter("page")); } if
		 * (request.getParameter("pageSize") != null) { pageSize =
		 * Integer.parseInt(request.getParameter("pageSize")); } PageData<Evaluate> pd =
		 * es.waitEval(page, pageSize,userId); Gson gson = new Gson(); String data =
		 * gson.toJson(pd); // System.out.println(data);
		 * response.getWriter().println(data);
		 * 
		 * <<<<<<< HEAD }
		 */

	// }
	/**
	 * 设置取货距离
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void setGetDistance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disId = request.getParameter("disId");
		String courierId = request.getParameter("CourierId");
		String distance = request.getParameter("distance");
		rs.setGetDistance(disId, courierId, Double.valueOf(distance));
		/**
		 * 设置送货距离
		 */
	}

	protected void setSendDistance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disId = request.getParameter("disId");
		String courierId = request.getParameter("CourierId");
		String distance = request.getParameter("distance");
		rs.setSendDistance(disId, courierId, Double.valueOf(distance));
	}

}
