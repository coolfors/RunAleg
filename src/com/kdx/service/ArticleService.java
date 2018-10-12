package com.kdx.service;

import com.kdx.entity.Article;
import com.kdx.util.PageData;

public interface ArticleService {
	boolean addArticle(Article Article);
	boolean updateArticle(Article Article);
	PageData getArticlesByPage(int page, int pageSize);
	Article loginArticle(String ArticleName,String ArticlePwd);

}
