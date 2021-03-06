package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.kdx.dao.AffairDao;
import com.kdx.dao.BillDao;
import com.kdx.entity.Bill;
import com.kdx.entity.Courier;
import com.kdx.entity.Dispatch;
import com.kdx.entity.User;
import com.kdx.service.CourierService;
import com.kdx.service.DispatchService;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.serviceImpl.DispatchServiceImpl;
import com.kdx.util.BaseDao;
import com.kdx.util.IDNumber;
import com.kdx.util.UUIDUtils;

public class AffairDaoImpl implements AffairDao {
	/**
	 * 用事务查询，在用户注册账号时同时
	 */
	@SuppressWarnings({ "unchecked", "finally" })
	@Override
	public boolean addUserAndInfo(User u) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		boolean flag = false;
		try {
			// 在java中可以对支持事务的数据库完成事务的处理
			conn.setAutoCommit(false);
			List<User> list = (List<User>) BaseDao.select("select * from user where userName=?", User.class,
					u.getUserName());
			if (list.size() != 0) {
				//System.out.println(u.getUserName());
				flag = false;
			} else {
				String uuid1 = IDNumber.getIDNumber();
				String uuid2 = IDNumber.getIDNumber();
				// 执行增加user的操作
				String sql1 = "insert into user(userId,userName,sockState,userPwd,userType,userdate) values(?,?,0,?,1,?)";
				BaseDao.execute(sql1, conn, uuid1, u.getUserName(), u.getUserPwd(), u.getUserDate());

				// 执行增加userinfo的操作
				String sql2 = "insert into userinfo values(?,?,null,null,0,null)";
				BaseDao.execute(sql2, conn, uuid2, uuid1);
				// 手动提交
				conn.commit();
				flag = true;
				System.out.println("注册提交！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			conn.rollback();
			e.printStackTrace();
		} finally {
			return flag;
		}
	}

	/**
	 * 事务升级。
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean toBeCourier(Courier cour) {
		// TODO Auto-generated method stub
		Connection conn=BaseDao.getConn();
		boolean flag=false;
		try {
				// 在java中可以对支持事务的数据库完成事务的处理
				conn.setAutoCommit(false);
				//执行删除userinfo操作
//				String sql1 = "delete from userinfo where userId = ?";
//				BaseDao.execute(sql1, conn, cour.getUserId());
				
				//执行增加Courier的操作
				String sql2="insert into courier values(?,?,500,?,?,null,0,?,100,?,?)";
				BaseDao.execute(sql2, conn, cour.getCourierId(),cour.getUserId(),cour.getBalance(),cour.getTel(),cour.getIdImg(),cour.getIDcard(),cour.getAddress());
				
				//执行修改user中usertype;
				String sql3="update user set userType = 2,userName = ? where userId = ?";
				BaseDao.execute(sql3, conn,cour.getUserName(),cour.getUserId());			
				//手动提交
				conn.commit();
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("执行事务失败");
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
			//System.out.println(disId);
			List<Dispatch> list=(List<Dispatch>) BaseDao.select("select * from dispatch where disId=?", Dispatch.class, disId);
			Dispatch dis=null;
			Iterator<Dispatch> it=list.iterator();
			dis=it.next();
			//System.out.println(dis);
			if(dis.getDisState()!=0) {
				System.out.println("jj");
				flag=false;
			}else {
				CourierService cs=new CourierServiceImpl();
				DispatchService ds=new DispatchServiceImpl();
				String uuid1=UUIDUtils.getUUID();
				String uuid2=UUIDUtils.getUUID();
				//System.out.println(1);
				//执行改变dispatch状态的动作
				String sql1 = "update dispatch set disState=1 where disId=?";
				BaseDao.execute(sql1, conn,disId);
				//System.out.println(2);
				//获取当前时间作为起点时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Date = df.format( new Date());
				//执行增加增加receipt的操作
				String sql2="insert into receipt values(?,?,?,?,?,'XXX',0,?,?,?)";
				//配送员当前位置
				String add=cs.getCourierAdd(courierId);
				//System.out.println(3);
				
				BaseDao.execute(sql2, conn, uuid1,uuid2,courierId,disId,Date,add,getGoodsDistance,sendGoodsDistance);
				//System.out.println(4);
				
				//Bill b=new Bill(UUIDUtils.getUUID(), disN.getUserId(), disId, Double.valueOf(disN.getDisPrice()));
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
