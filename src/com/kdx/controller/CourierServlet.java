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
import com.kdx.entity.Courier;
import com.kdx.entity.Dispatch;
import com.kdx.entity.Evaluate;
import com.kdx.entity.Receipt;
import com.kdx.entity.Receipt_about;
import com.kdx.entity.Userinfo;
//import com.kdx.entity.Receipt_about;
import com.kdx.service.CourierService;
import com.kdx.service.DispatchService;
import com.kdx.service.EvaluateService;
import com.kdx.service.ReceiptService;
import com.kdx.service.Receipt_aboutService;
import com.kdx.service.UserinfoService;
//import com.kdx.service.Receipt_aboutService;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.serviceImpl.EvaluateServiceImpl;
import com.kdx.serviceImpl.ReceiptServiceImpl;
import com.kdx.serviceImpl.Receipt_aboutServiceImpl;
import com.kdx.serviceImpl.UserinfoServiceImpl;
//import com.kdx.serviceImpl.Receipt_aboutServiceImpl;
import com.kdx.util.MyDataTableData;
import com.kdx.util.PageData;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet("/CourierServlet.do")
public class CourierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DispatchService ds = new DispatchServiceImpl();
	private ReceiptService rs = new ReceiptServiceImpl();
	private EvaluateService es = new EvaluateServiceImpl();
	private CourierService cs = new CourierServiceImpl();
	private UserinfoService uis = new UserinfoServiceImpl();
	private Receipt_aboutService ras = new Receipt_aboutServiceImpl();
	// private Receipt_aboutService ras=new Receipt_aboutServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourierServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op = request.getParameter("op");
		if ("allDispatch".equals(op)) {
			allDispatch(request, response);
		} else if ("waitSendReceipt".equals(op)) {
			waitSendReceipt(request, response);
		} else if ("waitUpdateReceipt".equals(op)) {
			waitUpdateReceipt(request, response);
		} else if ("waitEvaluate".equals(op)) {
			waitEvaluate(request, response);
		} else if ("overEvaluate".equals(op)) {
			overEvaluate(request, response);
		} else if (op.equals("edit")) {
			editCourier(request, response);
		} else if (op.equals("sendReceipt")) {
			sendReceipt(request, response);
		} else if (op.equals("updateAdd")) {
			updateAdd(request, response);
		} else if (op.equals("xiugai")) {
			updateCourierMessage(request, response);
		} else if ("getState".equals(op)) {
			getState(request, response);
		}

		if (op.equals("edit")) {

			String courierId = request.getParameter("courierId");
			String ableDistance = request.getParameter("ableDistance");
			String address = request.getParameter("address");
			String balance = request.getParameter("balance");
			String creditPoint = request.getParameter("creditPoint");
			String deposit = request.getParameter("deposit");
			String iDcard = request.getParameter("IDcard");
			String tel = request.getParameter("tel");

			Courier c = new Courier(courierId, Double.valueOf(ableDistance), address, Double.valueOf(balance),
					Integer.valueOf(creditPoint), Double.valueOf(deposit), iDcard, tel);

			boolean flag = cs.updateCourier(c);

			PrintWriter out = response.getWriter();

			out.print(flag);
		}
		if (op.equals("sock")) {
			String courierId = request.getParameter("courierId");
			String sockState = request.getParameter("sockState");
			boolean flag = cs.updateState(courierId, Integer.valueOf(sockState));
			PrintWriter out = response.getWriter();
			out.print(flag);
		}

	}

	private void getState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String disId = request.getParameter("disId");
		boolean flag = cs.getState(disId);
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

		// 查询并返回所有数据 的格式要注意咯
		List<Courier> list = cs.getCourier();

		MyDataTableData<Courier> mydata = new MyDataTableData<Courier>();
		mydata.setData(list);

		// 返回json对象
		String jsonString = new Gson().toJson(mydata);

		// System.out.println(jsonString);

		PrintWriter out = response.getWriter();

		out.print(jsonString);

		out.close();
	}

	/**
	 * 查询所有派单，dispatch表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void allDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取页码信息
		String pageIndex = request.getParameter("pageIndex");

		String pageSize = request.getParameter("pageSize");
		// 设置初始默认值为1
		if (pageIndex == null) {
			pageIndex = "1";
		}
		if (pageSize == null) {
			pageSize = "10";
		}
		// System.out.println(1);
		// int page = 1;
		// int pageSize = 6;
		/*
		 * if(request.getParameter("page") != null) { page =
		 * Integer.parseInt(request.getParameter("page")); }
		 */
		PageData<Dispatch> pd = ds.queryDispatch(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(pd);
		request.setAttribute("dataJson", data);
		// System.out.println(data);
		// request.getRequestDispatcher("courier-main.jsp").forward(request, response);
		response.getWriter().println(data);
	}

	/**
	 * 查询待送订单，receipt表中state为0
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 * 
	 */
	protected void waitSendReceipt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 10;
		String courierId = request.getParameter("courierId");
		if (request.getParameter("pageIndex") != null) {
			page = Integer.parseInt(request.getParameter("pageIndex"));
		}
		PageData<Receipt_about> pd = ras.waitsendReceipt(page, pageSize, courierId);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}

	/**
	 * 查询待修改订单，receipt表中state为1
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitUpdateReceipt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 10;
		if (request.getParameter("pageIndex") != null) {
			page = Integer.parseInt(request.getParameter("pageIndex"));
		}
		PageData<Receipt> pd = rs.waitUpdateReceipt(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}

	/**
	 * 查询配送中有手机号码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sendReceipt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 10;

		String courierId = request.getParameter("courierId");
		if (request.getParameter("pageIndex") != null) {
			page = Integer.parseInt(request.getParameter("pageIndex"));
		}

		PageData<Receipt_about> pd = ras.sendReceipt(page, pageSize, courierId);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}

	/**
	 * 未评价订单，表evaluate
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitEvaluate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 10;
		String courierId = request.getParameter("courierId");
		if (request.getParameter("pageIndex") != null) {
			page = Integer.parseInt(request.getParameter("pageIndex"));
		}
		PageData<Evaluate> pd = es.waitEvaluate(page, pageSize, courierId);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}

	/**
	 * 已评价订单，表evaluate
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void overEvaluate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 10;

		String courierId = request.getParameter("courierId");

		if (request.getParameter("pageIndex") != null) {
			page = Integer.parseInt(request.getParameter("pageIndex"));
		}
		PageData<Evaluate> pd = es.overEvaluate(page, pageSize, courierId);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		// System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}

	/**
	 * 后台修改腿哥信息，Courier表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void editCourier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取页码信息

	}

	/**
	 * 前台修改腿哥信息，courier表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCourierMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("courierId");
		String tel = request.getParameter("courierTel");
		String userSex = request.getParameter("couriersex");
		@SuppressWarnings("unused")
		// 修改性别
		boolean flagSex = uis.updateUserinfoSex(userSex, userId);
		String address = request.getParameter("courierAdd");
		String ableDistance = request.getParameter("ableDistance");
		Courier cour = new Courier(Double.parseDouble(ableDistance), address, tel, userId);
		boolean flag = cs.updateCourierInForward(cour);
		if (flag) {
			request.getSession().removeAttribute("Courier");
			request.getSession().removeAttribute("Userinfo");
			Courier courier = cs.getCourierById(cour.getUserId());
			request.getSession().setAttribute("Courier", courier);
			Userinfo userInfo = uis.getUserInfo(userId);
			request.getSession().setAttribute("Userinfo", userInfo);
			request.getRequestDispatcher("userMessage.jsp").forward(request, response);
		}
	}

	/**
	 * 用于更新courier的当前位置
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取经纬度和跑腿员id
		String add = request.getParameter("add");
		String courierId = request.getParameter("CourierId");
		// 执行修改语句将位置信息更新到数据库
		cs.updateAdd(courierId, add);
	}

}
