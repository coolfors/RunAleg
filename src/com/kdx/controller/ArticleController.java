package com.kdx.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import com.kdx.util.UUIDUtils;
/**
 * Servlet implementation class QusController
 */
@WebServlet("/ArtcleController")
/**
 * 
 * @author coolfors
 *
 */
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*更新文章提交到文章页面*/
		//设置编码
		request.setCharacterEncoding("utf-8");
		//输出控制台
		PrintWriter out = response.getWriter();
		//获取传送的参数值系统时间
		String article = request.getParameter("article");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String articledate = df.format( new Date());
		String title = request.getParameter("title");
		String userId = "25";
		//添加数据到数据库
		String uuid=UUIDUtils.getUUID();
		Article at = new Article(uuid,userId,articledate, title, article);
		ArticleService as = new ArticleServiceImpl();
		boolean flag  = as.addArticle(at);
		if(flag) {
			//将数据转成json串
		Gson gson = new Gson();
		String jsonstr = gson.toJson(at);
		//添加成功转发到所有文章界面
		request.setAttribute("pd", jsonstr);
		request.getRequestDispatcher("admin/Aarticle.html").forward(request, response);
		out.print("<script>alert('添加帮助成功');location.href='index.html'</script>");
		
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
		
	}

}
