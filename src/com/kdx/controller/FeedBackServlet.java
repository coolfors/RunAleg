package com.kdx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Feedback;
import com.kdx.entity.User;
import com.kdx.service.FebackService;
import com.kdx.service.UserService;
import com.kdx.serviceImpl.FebackServiceImpl;
import com.kdx.serviceImpl.UserServiceImpl;
import com.kdx.util.PageData;
import com.kdx.util.UUIDUtils;

/**
 * Servlet implementation class FeedBackServlet
 */
@WebServlet("/FeedBackServlet.do")
public class FeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedBackServlet() {
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
		if (op.equals("FeedBack")) {
			doFeedBack(request, response);
		} else if (op.equals("getFeedBack")) {
			getFeedBack(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doFeedBack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserId = request.getParameter("UserId");
		String neirong = request.getParameter("neirong");
		UserService us = new UserServiceImpl();
		FebackService fs = new FebackServiceImpl();
		User u = us.getUserById(UserId);// feedbackId
		String uuid = UUIDUtils.getUUID();
		Feedback f = new Feedback(uuid, neirong, UserId, null);
		boolean flag = fs.addFeback(f);
		if (flag) {
			response.getWriter().print("<script>alert('感谢您的留言！');location.href='contact-us.jsp'</script>");

		} else {
			response.getWriter().print("<script>alert('留言失败，请重试！');</script>");
		}
	}

	protected void getFeedBack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserId = request.getParameter("UserId");
		String pageIndex = request.getParameter("pageIndex");
		String pageSize = request.getParameter("pageSize");
		if (pageIndex == null) {
			pageIndex = "1";
		}
		if (pageSize == null) {
			pageSize = "5";
		}
		FebackService fs = new FebackServiceImpl();
		PageData<Feedback> pd = fs.queryFebackByPage(Integer.parseInt(pageIndex), Integer.parseInt(pageSize), UserId);
		request.setAttribute("pd", pd);
		request.getRequestDispatcher("contact-us.jsp").forward(request, response);
	}

}
