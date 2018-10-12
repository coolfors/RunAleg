package com.kdx.test;

import java.util.List;


import com.kdx.dao.FebackDao;
import com.kdx.dao.ReceiptDao;
import com.kdx.daoImpl.FebackDaoImpl;
import com.kdx.daoImpl.ReceiptDaoImpl;
import com.kdx.entity.Feedback;
import com.kdx.entity.Receipt;
import com.kdx.service.ReceiptService;
import com.kdx.serviceImpl.ReceiptServiceImpl;
import com.kdx.util.PageData;

public class TestReceipt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * 分页查询
		 */
		ReceiptDao rd = new ReceiptDaoImpl();

		PageData<Receipt> pd = rd.queryReceipt(2, 3);

		@SuppressWarnings("unchecked")
		List<Receipt> list = pd.getData();

		list.forEach(System.out::println);

		/**
		 * 增加测试
		 */
		/*ReceiptDao rd=new ReceiptDaoImpl();
		Receipt r=new Receipt(3,1,1,"aaa","222","223",1,"222",1,1);
	
		boolean flag=rd.addReceipt(r);
		System.out.println("flag:"+flag);
		*/
		
	
		
	}

}
