package com.kdx.test;

import java.util.List;

import com.kdx.entity.Article;
import com.kdx.service.ArticleService;
import com.kdx.serviceImpl.ArticleServiceImpl;
import com.kdx.util.PageData;

public class testArticle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Article u=new Article(12,"April","13",1,1,"2018-10-11 14:14:27");
		
		ArticleServiceImpl usi=new ArticleServiceImpl();
		
		//boolean flag=usi.addArticle(u);
		boolean flag=usi.updateArticle(u);
		
		System.out.println(flag);*/
		ArticleService us=new ArticleServiceImpl();
		PageData<Article> pd=us.getArticlesByPage(3, 4);
		List<Article> list=pd.getData();
		for (Article Article : list) {
			System.out.println(Article);
		}
	}

}
