package com.kdx.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.kdx.entity.Article;
import com.kdx.service.ArticleService;
import com.kdx.serviceImpl.ArticleServiceImpl;
import com.kdx.util.PageData;
import com.kdx.util.UUIDUtils;

public class testArticle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*ArticleService us=new ArticleServiceImpl();
		Article al =us.queryByIdArticle(16);
		System.out.println(al.getContent());*/

//		System.out.println(createHtml("aa", "11")); 
		
		String article = "文章的内容";
		String articleId = "sss";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String articledate = df.format( new Date());
		String title = "如何成为快递侠";
		//添加数据到数据库
		String uuid=UUIDUtils.getUUID();
		Article at = new Article(uuid,articledate, title, article);
		ArticleService as = new ArticleServiceImpl();
		boolean flag  = as.addArticle(at);
		System.out.println(flag);
	}
	public static boolean createHtml(String content,String id){

		  boolean bool=false;//标记是否成功，默认为失败
		  String cont=content;
		  String fileName=id+".html";
		  //创建目录article用来放置生成的网页
		  FileWriter toFile;
		  BufferedWriter out;
		   try{
		    toFile=new FileWriter("..//article\\"+fileName);
		    out=new BufferedWriter(toFile);
		    //输出网页的内容
		    out.write(cont,0,cont.length());
		    out.close();
		    toFile.close();
		    bool=true;    
		   }
		   catch(IOException ioe){
		    ioe.printStackTrace();
		   }
		   return bool;
		 }

}
