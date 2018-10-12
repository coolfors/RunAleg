package com.kdx.serviceImpl;

import com.kdx.dao.ReceiptDao;
import com.kdx.daoImpl.ReceiptDaoImpl;
import com.kdx.entity.Receipt;
import com.kdx.service.ReceiptService;
import com.kdx.util.PageData;

public class ReceiptServiceImpl implements ReceiptService {
	ReceiptDao rd= new ReceiptDaoImpl();
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

	@Override
	public PageData<Receipt> waitSendReceipt(int page, int pageSize) {
		// TODO Auto-generated method stub
		return rd.waitSendReceipt(page, pageSize);
	}

	@Override
	public PageData<Receipt> waitUpdateReceipt(int page, int pageSize) {
		// TODO Auto-generated method stub
		return rd.waitUpdateReceipt(page, pageSize);
	}

}
