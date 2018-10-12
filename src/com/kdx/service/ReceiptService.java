package com.kdx.service;

import com.kdx.entity.Receipt;
import com.kdx.util.PageData;

public interface ReceiptService {
	PageData<Receipt> queryReceipt(int page, int pageSize);// 查询所有订单

	boolean updateReceipt(Receipt r);// 修改订单

	boolean addReceipt(Receipt r);// 增加订单

	boolean delReceipt(int receiptId);// 删除订单

	PageData<Receipt> waitSendReceipt(int page, int pageSize);// 待送订单

	PageData<Receipt> waitUpdateReceipt(int page, int pageSize);// 待修改订单
}
