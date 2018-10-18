package com.kdx.daoImpl;

import com.kdx.dao.BillDao;
import com.kdx.entity.Bill;
import com.kdx.util.BaseDao;

public class BillDaoImpl implements BillDao {

	@Override
	public boolean addBill(Bill b) {
		// TODO Auto-generated method stub
		return BaseDao.execute("insert into bill values(?,?,?,?,XXX)", b.getBillId(),b.getPayerId(),b.getRunnerId(),b.getMoney())>0;
	}

	@Override
	public boolean deleteBill(String billId) {
		// TODO Auto-generated method stub
		return BaseDao.execute("delete from bill where billId=?", billId)>0;
	}

}
