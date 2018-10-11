package com.kdx.test;

import java.util.List;

import com.kdx.entity.Userinfo;
import com.kdx.util.BaseDao;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Userinfo> list=(List<Userinfo>) BaseDao.select("select * from userinfo", Userinfo.class);
		System.out.println(list);
	}

}
