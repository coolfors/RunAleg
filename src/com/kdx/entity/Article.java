package com.kdx.entity;

/**
 * @author coolfors
 * @date 2018年10月12日 上午10:05:43
 * @description:
 *git:https://github.com/coolfors/RunAleg
 */

public class Article {
	private int articleId;
	private int userId;
	private String articledate;
	private String title;
	private String content;
	public int getArticleId() {
		return articleId;
	}
	/**
	 * 构造文章类
	 * @param articledate 发表时间
	 * @param title 文章的标题
	 * @param content 文章的内容
	 */

	public Article(int articleId, int userId, String articledate, String title, String content) {
		super();
		this.articleId = articleId;
		this.userId = userId;
		this.articledate = articledate;
		this.title = title;
		this.content = content;
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getArticledate() {
		return articledate;
	}
	public void setArticledate(String articledate) {
		this.articledate = articledate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "article [articleId=" + articleId + ", userId=" + userId + ", articledate=" + articledate + ", title="
				+ title + ", content=" + content + "]";
	}
	
	/**
	 * 无参构造
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 文章添加内容测试
	 * @param i
	 * @param articledate2
	 * @param title2
	 * @param article
	 */
	public Article(int userId, String articledate, String title, String content) {
		super();
		this.userId = userId;
		this.articledate = articledate;
		this.title = title;
		this.content = content;
	}
	
	
	
}

