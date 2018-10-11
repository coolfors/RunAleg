package com.kdx.test;

import java.util.List;

import com.kdx.dao.FebackDao;
import com.kdx.daoImpl.FebackDaoImpl;
import com.kdx.entity.Feedback;
import com.kdx.util.PageData;

public class TestFeback {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FebackDao fd = new FebackDaoImpl();

		PageData<Feedback> pd = fd.queryFebackByPage(2, 3);

		@SuppressWarnings("unchecked")
		List<Feedback> list = pd.getData();

		list.forEach(System.out::println);

	}

}
