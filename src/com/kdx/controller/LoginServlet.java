package com.kdx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kdx.entity.Courier;
import com.kdx.entity.User;
import com.kdx.entity.Userinfo;
import com.kdx.service.CourierService;
import com.kdx.service.UserService;
import com.kdx.service.UserinfoService;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.serviceImpl.UserinfoServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	private UserinfoService uis = new UserinfoServiceImpl();
	private CourierService cs = new CourierServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		@SuppressWarnings("unused")
		String check_code= request.getParameter("check_code");//获取用户文本框内的内容
		if(op.equals("login")) {
			login(request,response);
		}
		else if(op.equals("register")) {
			register(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String check_code= request.getParameter("check_code");//获取用户文本框内的内容
		String code = (String) request.getSession().getAttribute("code"); // 获取存放在session中的验证码
		User user = us.loginUser(userName, password);
		if(user==null) {
			out.print("<script>alert('账号或密码错误，登录失败！');location.href='login.html'</script>");
		}else if(!check_code.equalsIgnoreCase(code)) {
			out.print("<script>alert('验证码错误，登录失败！');location.href='login.html'</script>");
		}
		else {
			/*Gson gson=new Gson();
			String user=gson.toJson(u);*/
			HttpSession session=request.getSession();
			session.setAttribute("User", user);
			//传递普通用户的全部信息
			Userinfo userInfo = uis.getUserInfo(user.getUserId());
			session.setAttribute("Userinfo", userInfo);
			//传递跑腿用户的全部信息
			Courier courier = cs.getCourierById(user.getUserId());
			session.setAttribute("Courier", courier);
			System.out.println(courier);
			out.print("<script>alert('登录成功！');location.href='index.jsp'</script>");
		}
		out.close();
	}
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int userType = 1;
		@SuppressWarnings("deprecation")
		String userDate = new Date().toLocaleString();
		User user = new User(userName, password, userType,userDate);
		boolean flag = us.addUser(user);
		if(flag) {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
