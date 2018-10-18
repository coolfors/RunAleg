package com.kdx.service;

import com.kdx.entity.Receipt_about;
import com.kdx.util.PageData;

public interface Receipt_aboutService {
	PageData<Receipt_about> sendReceipt(int page ,int pageSize,String  courierId);//查询courier配送中的订单，有收货人电话号码跟发货人电话号码
	PageData<Receipt_about> waitsendReceipt(int page, int pageSize ,String courierId);//查询courier待配送的订单

}
