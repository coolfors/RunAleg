package com.kdx.dao;
import java.util.List;

import com.kdx.entity.Article;
import com.kdx.util.PageData;

public interface ArticleDao {
	List<Article> queryArticle();
	Article queryByIdArticle(int  articleId);
	
	boolean addArticle(Article Article);
	boolean updateArticle(Article Article);
	PageData queryArticleByPage(int page, int pageSize);

}
