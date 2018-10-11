package com.etc.test;

import java.util.List;

import com.etc.entity.Userinfo;
import com.etc.util.BaseDao;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Userinfo> list=(List<Userinfo>) BaseDao.select("select * from userinfo", Userinfo.class);
		System.out.println(list);
	}

}
