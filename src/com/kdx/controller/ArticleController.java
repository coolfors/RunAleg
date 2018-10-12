package com.kdx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kdx.entity.Article;
import com.kdx.service.ArticleService;
import com.kdx.serviceImpl.ArticleServiceImpl;

/**
 * Servlet implementation class QusController
 */
@WebServlet("/ArtcleController")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*更新文章提交到文章页面*/
		//设置编码
		request.setCharacterEncoding("utf-8");
		//输出控制台
		PrintWriter out = response.getWriter();
		//获取传送的参数值
		String article = request.getParameter("article");
		String articledate = new Date().toLocaleString();
		String title = request.getParameter("title");
		
		System.out.println(article);
		System.out.println("作者：" + request.getParameter("username"));
		Article at = new Article(8,articledate, title, article);
		ArticleService as = new ArticleServiceImpl();
		boolean flag  = as.addArticle(at);
		if(flag) {
		System.out.println("添加文章成功");
		Gson gson = new Gson();
		String jsonstr = gson.toJson(at);
		System.out.println("jsonstr"+jsonstr);
		out.println(jsonstr);
		out.close();
		request.setAttribute("pd", jsonstr);
		request.getRequestDispatcher("admin/Aarticle.html").forward(request, response);
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

}
