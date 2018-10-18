package com.kdx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.kdx.dao.DispatchDao;
import com.kdx.entity.Dispatch;
import com.kdx.entity.User;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

public class DispatchDaoImpl implements DispatchDao {

	@Override
	public boolean addDispatch(Dispatch dis) {
		// TODO Auto-generated method stub
		return BaseDao.execute("insert into dispatch values(?,?,?,?,?,?,?,?,?)", dis.getDisId(),dis.getUserId(),
				dis.getBeginAdd(), dis.getEndAdd(), dis.getDisTel(), dis.getDisPrice(), dis.getGoodsType(),
				dis.getDisPS(), dis.getDisState()) > 0;
	}

	@Override
	public boolean updateDispatch(Dispatch dis) {
		// TODO Auto-generated method stub
		return BaseDao.execute(
				"update dispatch set beginAdd=?,endAdd=?,disTel=?,"
						+ "disPrice=?,goodsType=?,disPS=?,disState=? where disId=?",
				dis.getBeginAdd(), dis.getEndAdd(), dis.getDisTel(), dis.getDisPrice(), dis.getGoodsType(),
				dis.getDisPS(), dis.getDisState(), dis.getDisId()) > 0;
	}

	/**
	 * 所有订单-dispatch所有内容
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageData<Dispatch> queryDispatch(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from dispatch where disState=0", page, pageSize, Dispatch.class);
	}

	/**
	 * 待配送订单-dispatch中disState为0 的内容
	 */
	@Override
	public PageData<Dispatch> waitSendDispatch(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from dispatch where disState=0";
		return BaseDao.getPage(sql, page, pageSize, Dispatch.class);
	}

	@Override
	public List<Dispatch> getDispatch() {
		// TODO Auto-generated method stub
		String sql = "SELECT dispatch.disId,user.userName,dispatch.beginAdd,dispatch.endAdd,dispatch.disTel,dispatch.disPrice,dispatch.goodsType,dispatch.disPS,dispatch.disState FROM dispatch INNER JOIN user ON dispatch.userId=user.userId";
		return (List<Dispatch>) BaseDao.select(sql, Dispatch.class);
	}
	@Override
	public List<String> getBeginAndEnaAdd(String disId) {
		// TODO Auto-generated method stub
		List<Dispatch> list=(List<Dispatch>) BaseDao.select("select * from dispatch where disId=?", Dispatch.class, disId);
		List<String> strlist=new ArrayList<>();
		for (Dispatch dis : list) {
			strlist.add(dis.getBeginAdd());
			strlist.add(dis.getEndAdd());
		}
		return strlist;
	}
	/*
	 * user 用户的所有订单(显示自己的所有订单)
	 * 
	 */
	@Override
	public PageData<Dispatch> queryDispatch(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		String sql="SELECT dispatch.disId, dispatch.beginAdd, dispatch.endAdd, dispatch.disTel, dispatch.disPrice, dispatch.goodsType, dispatch.disPS, dispatch.disState FROM dispatch WHERE userId=? ";
		return BaseDao.getPage(sql, page, pageSize, Dispatch.class, userId);
	}

}
