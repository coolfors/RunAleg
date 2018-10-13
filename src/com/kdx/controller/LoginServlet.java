package com.kdx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kdx.entity.User;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		PrintWriter out=response.getWriter();
		String op=request.getParameter("op");
		if(op.equals("login")) {
			UserService us=new UserServiceImpl();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			User u=us.loginUser(userName, password);
			if(u==null) {
				out.print("<script>alert('登录失败！');location.href='login.html'</script>");
			}
			else {
				Gson gson=new Gson();
				String user=gson.toJson(u);
				HttpSession session=request.getSession();
				session.setAttribute("User", user);
				out.print("<script>alert('登录成功！');location.href='index.html'</script>");
			}
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
