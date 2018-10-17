package com.kdx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Courier;
import com.kdx.service.AffairService;
import com.kdx.serviceImpl.AffairServiceImpl;
import com.kdx.util.IDNumber;

/**
 * 升级为跑腿的事务操作
 * Servlet implementation class BeCourier
 */
@WebServlet("/BeCourier.do")
public class BeCourier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AffairService as = new AffairServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeCourier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courierId = IDNumber.getIDNumber();//生成跑腿编号  y
		String userId = request.getParameter("userId");//用户Id  
		String balance = request.getParameter("balance");//余额
		String tel = request.getParameter("tel");//手机号
		String address = request.getParameter("address");//地址
//		String idImg = request.getParameter("idImg");//头像 y
		String realIDcard = request.getParameter("realIDcard"); // y
		String userName = request.getParameter("realName");//y
		Courier cour = new Courier(courierId, address, Double.parseDouble(balance),realIDcard,tel, userId, userName);
		boolean flag = as.toBeCourier(cour);
		if(flag) {
			request.getRequestDispatcher("userMessage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
