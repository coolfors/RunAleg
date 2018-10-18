package com.kdx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Userinfo;
import com.kdx.service.UserinfoService;
import com.kdx.serviceImpl.UserinfoServiceImpl;

/**
 * Servlet implementation class Alipay
 */
@WebServlet("/AlipayService")
public class AlipayService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlipayService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String token = (String) request.getSession().getAttribute("token")+"";
		Double userBalance =Double.parseDouble((String) request.getSession().getAttribute("userBalance"));
		System.out.println("hah"+userBalance);
		String userId = request.getParameter("userId");
		System.out.println("haha"+userId);
		UserinfoService uis = new UserinfoServiceImpl();
		boolean flag = uis.updateUserinfoBalance(userBalance, userId);
		System.out.println(flag);
		if(flag){
			System.out.println("falg"+flag);
			request.getSession().removeAttribute("Userinfo");
			request.getSession().removeAttribute("userBalance");
			Userinfo userInfo = uis.getUserInfo(userId);
			request.getSession().setAttribute("Userinfo",userInfo);	
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
