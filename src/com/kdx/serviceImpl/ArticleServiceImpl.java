package com.kdx.serviceImpl;

import java.util.List;

import com.kdx.dao.ArticleDao;
import com.kdx.daoImpl.ArticleDaoImpl;
import com.kdx.entity.Article;
import com.kdx.service.ArticleService;
import com.kdx.util.PageData;

public class ArticleServiceImpl implements ArticleService {
	//创建对象
	ArticleDao ud=new ArticleDaoImpl();
	@Override
	public boolean addArticle(Article Article) {
		// TODO Auto-generated method stub
		return ud.addArticle(Article);
	}
	@Override
	public boolean updateArticle(Article Article) {
		// TODO Auto-generated method stub
		return ud.updateArticle(Article);
	}
	@Override
	public Article loginArticle(String ArticleName, String ArticlePwd) {
		// TODO Auto-generated method stub
		return ud.loginArticle(ArticleName, ArticlePwd);
	}
	@Override
	public PageData<Article> queryArticleByPage(int page, int pageSize, String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PageData getArticlesByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Article> queryArticle() {
		// TODO Auto-generated method stub
		return ud.queryArticle();
	}
	
}
