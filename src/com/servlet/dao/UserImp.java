package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.servlet.pojo.User;
import com.servlet.util.DBUtil;


public class UserImp extends DBUtil implements UserDao {

	@Override
	public User getUserInfo(String username, String password) {
		// TODO Auto-generated method stub
		Connection ct = getCnt();
		String sql = "select * from user where username=? and password=?";
		PreparedStatement pst = getSt(ct,sql);
		ResultSet rst = null;
		try {
			if(username != null && !"".equals(username) && password != null && !"".equals(password)){
				pst.setString(1, username);
				pst.setString(2, password);
				rst = getRt(pst);
				if (rst.next()) {
					User user = new User();
					user.setUsername(rst.getString("username"));
					user.setPassword(rst.getString("password"));
					user.setId(rst.getInt("id"));
					user.setPhone(rst.getString("phone"));
					return user;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			close(ct, pst, rst);
		}
		return null;
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

}
