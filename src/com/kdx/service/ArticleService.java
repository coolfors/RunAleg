package com.kdx.service;

import java.util.List;

import com.kdx.entity.Article;
import com.kdx.util.PageData;

public interface ArticleService {
	 List<Article> queryArticle();
	 Article queryByIdArticle(int  articleId);
	boolean addArticle(Article Article);
	boolean updateArticle(Article Article);
	PageData getArticlesByPage(int page, int pageSize);
	PageData<Article> queryArticleByPage(int page, int pageSize, String key);

}
