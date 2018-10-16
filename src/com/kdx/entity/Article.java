package com.kdx.entity;

/**
 * @author coolfors
 * @date 2018年10月12日 上午10:05:43
 * @description:
 *git:https://github.com/coolfors/RunAleg
 */

public class Article {
	private String articleId;
	private String userId;
	private String userName;
	private String articledate;
	private String title;
	private String content;
	public String getArticleId() {
		return articleId;
	}
	/**
	 * 构造文章类
	 * @param articledate 发表时间
	 * @param title 文章的标题
	 * @param content 文章的内容
	 */

	public Article(String articleId, String userId, String articledate, String title, String content) {
		super();
		this.articleId = articleId;
		this.userId = userId;
		this.articledate = articledate;
		this.title = title;
		this.content = content;
	}
	
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Article [articleId=" + articleId + ", userId=" + userId + ", userName=" + userName + ", articledate="
				+ articledate + ", title=" + title + ", content=" + content + "]";
	}
	
	/**
	 * 无参构造
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param userId
	 * @param articledate
	 * @param title
	 * @param content
	 */
	public Article(String userId, String articledate, String title, String content) {
		super();
		this.userId = userId;
		this.articledate = articledate;
		this.title = title;
		this.content = content;
	}
	
	
	
	
}

