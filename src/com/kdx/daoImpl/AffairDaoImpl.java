package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.kdx.dao.AffairDao;
import com.kdx.entity.User;
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
			conn.rollback();
			e.printStackTrace();
		}finally {
			return flag;
		}
	}

}
