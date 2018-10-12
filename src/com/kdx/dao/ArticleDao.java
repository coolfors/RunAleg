package com.kdx.dao;
import java.util.List;

import com.kdx.entity.Article;
import com.kdx.util.PageData;

public interface ArticleDao {
	List<Article> queryArticle();
	boolean addArticle(Article Article);
	boolean updateArticle(Article Article);
	PageData queryArticleByPage(int page, int pageSize);
	Article loginArticle(String ArticleName,String ArticlePwd);

}