package com.kdx.serviceImpl;

import com.kdx.dao.ReceiptDao;
import com.kdx.entity.Receipt;
import com.kdx.util.PageData;

public class ReceiptServiceImpl implements ReceiptDao {
	ReceiptDao rd= new ReceiptServiceImpl();
	@Override
	public PageData<Receipt> queryReceipt(int page, int pageSize) {
		// TODO Auto-generated method stub
		return rd.queryReceipt(page, pageSize);
	}

	@Override
	public boolean updateReceipt(Receipt r) {
		// TODO Auto-generated method stub
		return rd.updateReceipt(r);
	}

	@Override
	public boolean addReceipt(Receipt r) {
		// TODO Auto-generated method stub
		return rd.addReceipt(r);
	}

	@Override
	public boolean delReceipt(int receiptId) {
		// TODO Auto-generated method stub
		return rd.delReceipt(receiptId);
	}

}
