package com.kdx.dao;

import com.kdx.entity.Bill;

public interface BillDao {
	boolean addBill(Bill b);
	boolean deleteBill(String billId);
}
