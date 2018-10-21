package com.kdx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Courier;
import com.kdx.entity.Userinfo;
import com.kdx.service.CourierService;
import com.kdx.service.UserinfoService;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.serviceImpl.UserinfoServiceImpl;
/**
 * @author 快递侠
 */
/**
 * Servlet implementation class Alipay
 */
@WebServlet("/AlipayService")
public class AlipayService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserinfoService uis = new UserinfoServiceImpl();
	private CourierService cs =  new CourierServiceImpl();
       
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
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取支付成功传输过来的金额
		Double userBalance =Double.parseDouble((String) request.getSession().getAttribute("userBalance"));
		//获取userId
		String userId = request.getParameter("userId");
		//获取userType
		String userType = request.getParameter("userType");
		
		if(("1").equals(userType)) {
			//执行添加数据库
			boolean flag = uis.updateUserinfoBalance(userBalance, userId);
			if(flag){
				//释放Userinfo和userBalance的session信息
				request.getSession().removeAttribute("Userinfo");
				request.getSession().removeAttribute("userBalance");
				Userinfo userInfo = uis.getUserInfo(userId);
				//创建新的Userinfo的session信息
				request.getSession().setAttribute("Userinfo",userInfo);	
			}
		}else {
			boolean flag = cs.topUpBalance(userBalance, userId);
			if(flag){
				//释放Courier和userBalance的session信息
				request.getSession().removeAttribute("Courier");
				request.getSession().removeAttribute("userBalance");
				Courier courier = cs.getCourierById(userId);
				//创建新的courier的session信息
				request.getSession().setAttribute("Courier",courier);	
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
