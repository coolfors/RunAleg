package com.kdx.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Article;
import com.kdx.service.ArticleService;
import com.kdx.serviceImpl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleSevlet
 */
@WebServlet("/artlist.html")
public class ArticleShowListSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService at = new ArticleServiceImpl();
	

    /**
     * Default constructor. 
     */
    public ArticleShowListSevlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求和响应编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int articleId = Integer.parseInt(request.getParameter("id"));
		Article article = at.queryByIdArticle(articleId);
		String webcontent =article.getContent();
		//根据id查询文章
		// 获取请求参数
		// 先获取id然后打印到网页上
		if(articleId != 0) {
        request.setAttribute("content", webcontent);
 		//从当前的控制器跳转到jsp页面，跳转的方法叫做转发
 		request.getRequestDispatcher("driving-kn-details.jsp").forward(request, response);
	    }
		
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		Article article = at.queryByIdArticle(articleId);
		request.setAttribute("article", article);
		request.getRequestDispatcher("driving-knowledge.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
