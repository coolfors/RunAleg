package com.kdx.daoImpl;

import com.kdx.dao.DispatchDao;
import com.kdx.entity.Dispatch;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class DispatchDaoImpl implements DispatchDao {

	@Override
	public boolean addDispatch(Dispatch dis) {
		// TODO Auto-generated method stub
		return BaseDao.execute("insert into dispatch values(null,?,?,?,?,"
				+ "?,?,?,?)", dis.getUserId(),dis.getBeginAdd(),dis.getEndAdd(),
				dis.getDisTel(),dis.getDisPrice(),dis.getGoodsType(),
				dis.getDisPS(),dis.getDisState())>0;
	}

	@Override
	public boolean updateDispatch(Dispatch dis, int disId) {
		// TODO Auto-generated method stub
		return BaseDao.execute("update dispatch set beginAdd=?,endAdd=?,disTel=?,"
				+ "disPrice=?,goodsType=?,disPS=?,disState=? where disId=?", dis.getBeginAdd(),
				dis.getEndAdd(),dis.getDisTel(),dis.getDisPrice(),dis.getGoodsType(),
				dis.getDisPS(),dis.getDisState(),dis.getDisId())>0;
	}

	@Override
	public PageData<Dispatch> queryDispatch(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from dispatch", page, pageSize, Dispatch.class);
	}

}
