package com.kdx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kdx.entity.Courier;
import com.kdx.entity.User;
import com.kdx.entity.Userinfo;
import com.kdx.service.AffairService;
import com.kdx.service.CourierService;
import com.kdx.service.UserService;
import com.kdx.service.UserinfoService;
import com.kdx.serviceImpl.AffairServiceImpl;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.serviceImpl.UserinfoServiceImpl;
import com.kdx.util.IDNumber;

/**
 * 升级为跑腿的事务操作
 * Servlet implementation class BeCourier
 */
@WebServlet("/BeCourier.do")
public class BeCourier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AffairService as = new AffairServiceImpl();
	private UserService us=new UserServiceImpl();
	private UserinfoService uis = new UserinfoServiceImpl();
	private CourierService cs = new CourierServiceImpl();
       
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if(op.equals("toBeCourier")) {
			beCourier(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	/**
	 * 升级为courier
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void beCourier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courierId = IDNumber.getIDNumber();//生成跑腿编号  y
		String userId = request.getParameter("userId");//用户Id  
		String balance = request.getParameter("balance");//余额
		String tel = request.getParameter("tel");//手机号
		String address = request.getParameter("address");//地址
		String idImg = request.getParameter("idImg");//头像 y
		String realIDcard = request.getParameter("realIDcard"); // y
		String userName = request.getParameter("realName");//y
		Courier cour = new Courier(courierId, address,Double.parseDouble(balance),realIDcard,tel,idImg, userId, userName);
		boolean flag = as.toBeCourier(cour);
		if(flag) {
			HttpSession session = request.getSession();
			//移除现有的session
			session.removeAttribute("User");
			session.removeAttribute("Userinfo");
			session.removeAttribute("Courier");
			//创建新的session
			//传递user表信息
			User user = us.getUserById(cour.getUserId());
			session.setAttribute("User", user);
			//传递普通用户的全部信息
			Userinfo userInfo = uis.getUserInfo(cour.getUserId());
			session.setAttribute("Userinfo", userInfo);
			//传递跑腿用户的全部信息
			Courier courier = cs.getCourierById(cour.getUserId());
			session.setAttribute("Courier", courier);
			request.getRequestDispatcher("userMessage.jsp").forward(request, response);
		}
	}
	

}
