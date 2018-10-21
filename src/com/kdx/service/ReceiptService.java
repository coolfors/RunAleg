package com.kdx.service;

import java.util.List;

import com.kdx.entity.Receipt;
import com.kdx.entity.User;
import com.kdx.util.PageData;

public interface ReceiptService {
	PageData<Receipt> queryReceipt(int page, int pageSize);// 查询所有订单

	PageData<Receipt> queryReceiptcom(int page, int pageSize);// 查询已完成订单

	boolean updateReceipt(Receipt r);// 修改订单

	boolean addReceipt(Receipt r);// 增加订单

	boolean delReceipt(int receiptId);// 删除订单

	PageData<Receipt> waitSendReceipt(int page, int pageSize);// 待送订单

	PageData<Receipt> waitUpdateReceipt(int page, int pageSize);// 待修改订单

	PageData<Receipt> Receiptdispatch(int page, int pageSize);// 配送中的订单

	List<Receipt> getReceipt();

	boolean updateState(String receiptId, int state);// 改变状态

	PageData<Receipt> sendReceipt(int page, int pageSize, String userId);// user配送中的订单(根据用户自己的userId来查询)

	PageData<Receipt> waitSendReceipt(int page, int pageSize, String userId);// user待送订单(根据用户自己的userId来查询)

	boolean setGetDistance(String disId, String courierId, double distance);

	boolean setSendDistance(String disId, String courierId, double distance);

	boolean getState(String disId, String receiptId);// 改变状态
}
