package com.kdx.dao;

import java.util.List;

import com.kdx.entity.Receipt;
import com.kdx.util.PageData;

public interface ReceiptDao {
	PageData<Receipt> queryReceipt(int page, int pageSize);//查询所有订单
	boolean updateReceipt(Receipt r);//修改订单
	boolean addReceipt(Receipt r);//增加订单
	boolean delReceipt(int receiptId);//删除订单
}