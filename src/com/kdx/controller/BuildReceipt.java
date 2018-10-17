package com.kdx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.service.AffairService;
import com.kdx.serviceImpl.AffairServiceImpl;

/**
 * Servlet implementation class BuildReceipt
 */
@WebServlet("/BuildReceipt.do")
public class BuildReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildReceipt() {
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
		if(op.equals("buildReceipt")) {
			buildReceipt(request, response);
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
	 * 跑腿人员抢单后修改派单状态，并生成订单信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void buildReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AffairService as=new AffairServiceImpl();
		String getDis=request.getParameter("getDistance");
		String sendDis=request.getParameter("sendDis");
		String disId=request.getParameter("disId");
		String courierId=request.getParameter("courierId");
		boolean flag=as.buildeReceipt(disId, courierId, Double.valueOf(getDis), Double.valueOf(sendDis));
		if(flag) {
			response.getWriter().print("<script>alert('抢单成功！');location.href='courier-main.jsp'<script>");
		}else {
			response.getWriter().print("<script>alert('抢单失败，下次要快点哦！');location.href='courier-main.jsp'<script>");
		}
		
	}

}
