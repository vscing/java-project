package com.servlet.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import org.junit.Test;

public class DBUtil {
	private Connection ct = null;
	private PreparedStatement pst = null;
	private ResultSet rst = null;
	
	//1.建立连接
	public Connection getCnt(){
		Properties p = new Properties();
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
		try {
			p.load(in);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			//加载驱动
			Class.forName(driver);
			ct = DriverManager.getConnection(url, user, password);
			return ct;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;	
	}
	
	//2.获取PerparedStatement
	public PreparedStatement getSt(Connection ct,String sql){
		try {
			pst = ct.prepareStatement(sql);
			return pst;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	//3.获取结果
	public ResultSet getRt(PreparedStatement pst){
		try {
			rst = pst.executeQuery();
			return rst;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	//4.关闭所有资源
	public void close(Connection ct,PreparedStatement pst,ResultSet rst){
		try {
			if(ct != null){
				ct.close();
			}
			if(pst != null){
				pst.close();
			}
			if(rst != null){
				rst.close();	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//测试连接
	@Test
	public void test(){
		if(getCnt() != null){
			System.out.print("连接成功");
		}else{
			System.out.print("连接失败");
		}
	}
	
}
