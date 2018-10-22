package com.kdx.service;

import java.util.List;

import com.kdx.entity.Article;
import com.kdx.util.PageData;

public interface ArticleService {
	 List<Article> queryArticle();
	 Article queryByIdArticle(String  articleId);//通过id显示文章
	boolean addArticle(Article Article);
	boolean updateArticle(Article Article);
	PageData getArticlesByPage(int page, int pageSize);
	PageData<Article> queryArticleByPage(int page, int pageSize, String key);//文章显示
	

}
