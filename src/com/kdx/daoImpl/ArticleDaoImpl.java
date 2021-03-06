package com.kdx.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.kdx.dao.ArticleDao;
import com.kdx.entity.Article;
import com.kdx.entity.Userinfo;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class ArticleDaoImpl implements ArticleDao {
	
    public List<Article> queryArticle() {
		@SuppressWarnings("unchecked")
		List<Article> list =(List<Article>) BaseDao.select("SELECT articleId, userName, articledate, title, content FROM `user` INNER JOIN article WHERE `user`.userId = article.userId", Article.class);
		return list;
	}

	@Override
	public boolean addArticle(Article u) {
		// TODO Auto-generated method stub
		String sql="insert into article(articleId,userId,articledate,title,content) values(?,?,?,?,?)";
		//插入系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String articledate = df.format( new Date());
		return BaseDao.execute(sql,u.getArticleId(),u.getUserId(),articledate,u.getTitle(),u.getContent())>0;
	}

	@Override
	public boolean updateArticle(Article u) {
		// TODO Auto-generated method stub
		String sql="update article set title=?,content=? where ArticleId=?";
		return BaseDao.execute(sql,u.getTitle(),u.getContent(),u.getUserId())>0;
		 
	}

	@Override
	public PageData queryArticleByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from Article", page, pageSize, Article.class);
	}

	@Override
	public Article queryByIdArticle(String articleId) {
		// TODO Auto-generated method stub
		List<Article> list = (List<Article>) BaseDao.select("SELECT content FROM article WHERE articleId like ?" ,Article.class,articleId);
		Iterator<Article> it = list.iterator();
		Article article = null;
		if (it.hasNext()) {
			article = it.next();
		}
		return article;
	}

}
