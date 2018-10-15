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
	private String userName;
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
	 * 构造文章列表
	 * @param articleId 文章的id
	 * @param userName 文章的作者
	 * @param articledate 文章的发布时间
	 * @param title 文章的标题
	 */
	public Article(int articleId, String userName, String articledate, String title) {
		super();
		this.articleId = articleId;
		this.userName = userName;
		this.articledate = articledate;
		this.title = title;
	}
	
	
	
}

