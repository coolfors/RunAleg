package com.kdx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Dispatch;
import com.kdx.service.DispatchService;
import com.kdx.service.ReceiptService;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.serviceImpl.ReceiptServiceImpl;

/**
 * Servlet implementation class GpsServlet
 */
@WebServlet("/GpsServlet.do")
public class GpsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DispatchService ds=new DispatchServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GpsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op=request.getParameter("op");
		if(op.equals("getBeginAdd")) {
			getBeginAdd(request, response);
		}else if(op.equals("getEndAdd")) {
			getEndAdd(request, response);
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
	 * 获得用户派单的起送地点
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBeginAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disId=request.getParameter("disId");
		Dispatch d=ds.getOne(disId);
		response.getWriter().print(d.getBeginAdd());
	}
	/**
	 * 获得用户派单的目的地点
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getEndAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disId=request.getParameter("disId");
		Dispatch d=ds.getOne(disId);
		response.getWriter().print(d.getEndAdd());
	}

}
