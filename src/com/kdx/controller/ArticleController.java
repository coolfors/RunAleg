package com.kdx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		// 设置编码
		request.setCharacterEncoding("utf-8");
		// 输出控制台
		PrintWriter out = response.getWriter();
		// 获取传送的参数值系统时间
		String article = request.getParameter("article");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String articledate = df.format(new Date());
		String title = request.getParameter("title");
		// 添加数据到数据库
		String uuid = UUIDUtils.getUUID();
		String userId = request.getParameter("userId");
		Article at = new Article(uuid, userId,articledate, title, article);
		ArticleService as = new ArticleServiceImpl();
		boolean flag = as.addArticle(at);
		if (flag == true) {
			// 将数据转成json串
			Gson gson = new Gson();
			String jsonstr = gson.toJson(at);
			// 添加成功转发到所有文章界面
			request.setAttribute("pd", jsonstr);
			out.print("<script>alert('添加帮助成功');location.href='index.html'</script>");

			response.setContentType("text/html;charset=utf-8");

			// 从客户端得到所有cookie信息
			Cookie[] allCookies = request.getCookies();

			int i = 0;
			// 如果allCookies不为空...
			if (allCookies != null) {

				// 从中取出cookie
				for (i = 0; i < allCookies.length; i++) {

					// 依次取出
					Cookie temp = allCookies[i];

					if (temp.getName().equals("userId")) {

						// 得到cookie的值
						String val = temp.getValue();

					 	out.println("userId=" + val);
						break;

					}
				}
				if (allCookies.length == i) {

					out.println("cookie 过期");
				}

			} else {
				out.println("不存在color1这个cookie/或是过期了!");
			}
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
