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
import com.kdx.util.MyDataTableData;
import com.kdx.util.PageData;

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
		
		/**
		 * 下面是文章列表的显示
		 */
		// TODO Auto-generated method stub
				// 处理请求编码:切记，处理请求第一件事情就是设置请求编码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");// 相应编码
				// String v=request.getParameter("表单中的文本名，select名字等等/参数名"); 接收请求参数的值
				String op = request.getParameter("op");
				response.setContentType("application/json");
				
				if ("allArticle".equals(op)) {// getUsersByPage
					allArticle(request, response);}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		// 查询并返回所有数据 的格式要注意咯
		List<Article> list = at.queryArticle();

		MyDataTableData<Article> mydata = new MyDataTableData<Article>();
		mydata.setData(list);

		// 返回json对象
		Gson gson = new Gson();
		String jsonString = new Gson().toJson(mydata);

		System.out.println(jsonString);

		PrintWriter out = response.getWriter();

		out.print(jsonString);

		out.close();
	}
	

	/**
	 * 所有订单-文章的所有内容
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void allArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;// 默认第一页
		int pageSize = 10;// 默认一页有10条记录
		// 如果用户传递的参数不为空
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		PageData<Article> art = at.getArticlesByPage(page, pageSize);
		Gson gson = new Gson();
		String data = gson.toJson(art);
		response.getWriter().println(data);
	}

}
