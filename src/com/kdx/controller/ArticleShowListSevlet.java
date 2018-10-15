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
import com.kdx.entity.User;
import com.kdx.service.ArticleService;
import com.kdx.serviceImpl.ArticleServiceImpl;
import com.kdx.util.MyDataTableData;
import com.kdx.util.PageData;

/**
 * Servlet implementation class ArticleSevlet
 */
@WebServlet("/artlist.show")
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		int articleId = Integer.parseInt(request.getParameter("op"));
		Article article = at.queryByIdArticle(articleId);
		request.setAttribute("article", article);
		response.sendRedirect("driving-kn-details.jsp");
							
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
