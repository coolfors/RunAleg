package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.kdx.dao.AffairDao;
import com.kdx.entity.Courier;
import com.kdx.entity.Dispatch;
import com.kdx.entity.User;
import com.kdx.service.CourierService;
import com.kdx.service.DispatchService;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.util.BaseDao;
import com.kdx.util.UUIDUtils;

public class AffairDaoImpl implements AffairDao {
	/**
	 * 用事务查询，在用户注册账号时同时
	 */
	@Override
	public boolean addUserAndInfo(User u) {
		// TODO Auto-generated method stub
		Connection conn=BaseDao.getConn();
		boolean flag=false;
		try {
			// 在java中可以对支持事务的数据库完成事务的处理
			conn.setAutoCommit(false);
			List<User> list=(List<User>) BaseDao.select("select * from user where userName=?", User.class, u.getUserName());
			if(list.size()!=0) {
				System.out.println(u.getUserName());
				flag=false;
			}else {
				String uuid1=UUIDUtils.getUUID();
				String uuid2=UUIDUtils.getUUID();
				//执行增加user的操作
				String sql1 = "insert into user(userId,userName,sockState,userPwd,userType,userdate) values(?,?,0,?,1,?)";
				BaseDao.execute(sql1, conn,uuid1, u.getUserName(),u.getUserPwd(),u.getUserDate());
				
				//执行增加userinfo的操作
				String sql2="insert into userinfo values(?,?,null,null,null,null)";
				BaseDao.execute(sql2, conn, uuid2,uuid1);
				//手动提交
				conn.commit();
				flag=true;
				System.out.println("注册提交！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			return flag;
		}
	}
	@Override
	public boolean buildeReceipt(String disId, String courierId,double getGoodsDistance,double sendGoodsDistance) {
		// TODO Auto-generated method stub
		Connection conn=BaseDao.getConn();
		boolean flag=false;
		try {
			// 在java中可以对支持事务的数据库完成事务的处理
			conn.setAutoCommit(false);
			List<Dispatch> list=(List<Dispatch>) BaseDao.select("select * from dispatch where disId=?", User.class, disId);
			Dispatch dis=null;
			for (Dispatch dispatch : list) {
				dis=dispatch;
			}
			if(dis.getDisState()==1) {
				flag=false;
			}else {
				CourierService cs=new CourierServiceImpl();
				DispatchService ds=new DispatchServiceImpl();
				String uuid1=UUIDUtils.getUUID();
				String uuid2=UUIDUtils.getUUID();
				//执行增加user的操作
				String sql1 = "update dispatch set disState=1";
				BaseDao.execute(sql1, conn);
				//获取当前时间作为起点时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Date = df.format( new Date());
				//执行增加增加receipt的操作
				String sql2="insert into receipt values(?,?,?,?,?,XXX,0,?,?,?)";
				List<String> strlist=ds.getBeginAndEnaAdd(disId);
				Iterator<String> it=strlist.iterator();
				//配送员当前位置
				String add=cs.getCourierAdd(courierId);
				//订单起点和终点
				String beginAdd= it.next();
				String endAdd=it.next();
				
				BaseDao.execute(sql2, conn, uuid1,uuid2,courierId,disId,Date,add,getGoodsDistance,sendGoodsDistance);
				//手动提交
				conn.commit();
				flag=true;
				System.out.println("抢单成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			conn.rollback();
			e.printStackTrace();
		}finally {
			return flag;
		}
	}

}
