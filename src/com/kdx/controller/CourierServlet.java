package com.kdx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kdx.entity.Dispatch;
import com.kdx.entity.Evaluate;
import com.kdx.entity.Receipt;
import com.kdx.service.DispatchService;
import com.kdx.service.EvaluateService;
import com.kdx.service.ReceiptService;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.serviceImpl.EvaluateServiceImpl;
import com.kdx.serviceImpl.ReceiptServiceImpl;
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
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op = request.getParameter("op");
		if("allDispatch".equals(op)) {
			allDispatch(request,response);
		}
		else if("waitSendReceipt".equals(op)) {
			waitSendReceipt(request,response);
		}
		else if("waitUpdateReceipt".equals(op)) {
			waitUpdateReceipt(request,response);
		}
		else if("waitEvaluate".equals(op)) {
			waitEvaluate(request,response);
		}
		else if("overEvaluate".equals(op)) {
			overEvaluate(request,response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 查询所有派单，dispatch表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void allDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取页码信息
		String pageIndex=request.getParameter("pageIndex");
		
		String pageSize=request.getParameter("pageSize");
		//设置初始默认值为1
		if(pageIndex==null) {
			pageIndex="1";
		}
		if(pageSize==null) {
			pageSize="4";
		}
		System.out.println(1);
		//int page = 1;
		//int pageSize = 6;
		/*if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}*/
		PageData<Dispatch> pd = ds.queryDispatch(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		System.out.println(pd);
		request.setAttribute("dataJson", data);
		response.getWriter().print(data);
	}
	/**
	 * 查询待送订单，receipt表中state为0
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitSendReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 6;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageData<Receipt> pd = rs.waitSendReceipt(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		//System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}
	/**
	 * 查询待修改订单，receipt表中state为1
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitUpdateReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 6;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageData<Receipt> pd = rs.waitUpdateReceipt(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		//System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}
	/**
	 * 未评价订单，表evaluate
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void waitEvaluate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 6;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageData<Evaluate> pd = es.waitEval(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		//System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}
	/**
	 * 已评价订单，表evaluate
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void overEvaluate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int pageSize = 6;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageData<Evaluate> pd = es.overEval(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(pd);
		//System.out.println(data);
		request.setAttribute("dataJson", data);
		response.getWriter().println(data);
	}

}
