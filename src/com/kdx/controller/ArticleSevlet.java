package com.kdx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ArticleSevlet
 */
@WebServlet("/art.show")
public class ArticleSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService at = new ArticleServiceImpl();

    /**
     * Default constructor. 
     */
    public ArticleSevlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<Article> list = at.queryArticle();
		//将文章数据转成json字符串
		Gson gson = new Gson();
		String jsonstr = gson.toJson(list);
		System.out.println("jsonstr"+jsonstr);
		out.println(jsonstr);
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
