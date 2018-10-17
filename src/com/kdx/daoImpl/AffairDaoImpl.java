package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdx.dao.AffairDao;
import com.kdx.entity.Courier;
import com.kdx.entity.User;
import com.kdx.entity.Userinfo;
import com.kdx.util.BaseDao;
import com.kdx.util.IDNumber;

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
				System.out.println(u.getUserName());
				flag = false;
			} else {
				String uuid1 = IDNumber.getIDNumber();
				String uuid2 = IDNumber.getIDNumber();
				// 执行增加user的操作
				String sql1 = "insert into user(userId,userName,sockState,userPwd,userType,userdate) values(?,?,0,?,1,?)";
				BaseDao.execute(sql1, conn, uuid1, u.getUserName(), u.getUserPwd(), u.getUserDate());

				// 执行增加userinfo的操作
				String sql2 = "insert into userinfo values(?,?,null,null,null,null)";
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
				String sql1 = "delete from userinfo where userId = ?";
				BaseDao.execute(sql1, Userinfo.class, cour.getUserId());
				
				//执行增加Courier的操作
				String sql2="insert into courier values(?,?,?,?,?,?,0,?,100,?,?)";
				BaseDao.execute(sql2, conn, cour.getCourierId(),cour.getUserId(),cour.getDeposit(),cour.getBalance(),cour.getTel(),cour.getAbleDistance(),cour.getIdImg(),cour.getIDcard(),cour.getAddress());
				
				//执行修改user中usertype;
				String sql3="update user set userType = 2 where userId = ?";
				BaseDao.execute(sql3, Courier.class, cour.getUserId());			
				//手动提交
				conn.commit();
				flag=true;
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
