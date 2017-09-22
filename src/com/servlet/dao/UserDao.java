package com.servlet.dao;

import com.servlet.pojo.User;

public interface UserDao {
	//1.根据姓名和密码查询用户信息
	User getUserInfo(String username,String password);
	
	//2.添加用户
	int add(User user);
	
	//3.删除用户
	int delete(int userid);
	
	//4.修改用户
	int save(String username,String password);
}
