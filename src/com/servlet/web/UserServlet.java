package com.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.dao.UserImp;
import com.servlet.pojo.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("user doget");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("user dopost");
	}
	
	//登录页面
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字符转义
		request.setCharacterEncoding("utf-8");  
		request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
	}
	
	//验证登录
	protected void ajaxlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		UserImp userImp = new UserImp();
		user = userImp.getUserInfo(username, password);
		//JSON对象
		JSONObject jsonObject = new JSONObject();
		if (user != null) {
			HttpSession session = request.getSession();//拿到会话对象
			session.setAttribute("admin_user", user);//保存会话对象值
			jsonObject.accumulate("error", 0).accumulate("msg","登录成功");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jsonObject.toString());
		}else{
			jsonObject.accumulate("error",-1).accumulate("msg","用户名或密码错误");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jsonObject.toString());
		}
	}
	
	//后台主页
	protected void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute("admin_user");
		System.out.println(user);
		if(user == null){
			response.sendRedirect(request.getContextPath()+"/user/login.do");
		}else{
			request.getRequestDispatcher("/WEB-INF/view/user/main.jsp").forward(request, response);
		}
	}
	
	//退出
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//清空session
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/user/login.do");
	}

}
