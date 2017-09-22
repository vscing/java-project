package com.servlet.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MainServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 每请求一次响应不一样的
		String path = request.getServletPath();//获取路径
		//按规则分割路径 获取 类名 方法名
		path = path.substring(1); 
		String[] names = path.split("\\/");
		String className = this.getClass().getPackage().getName()+"."+names[0].substring(0, 1).toUpperCase() + names[0].substring(1) +"Servlet";
		String classMethod = names[1].substring(0,names[1].lastIndexOf(".") );
		//反射
		try {
			Class<?> cl = Class.forName(className);
			Object o = cl.newInstance();
			Method m = o.getClass().getDeclaredMethod(classMethod,HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(o,request,response);
		}catch (Exception e) {
			System.out.println("反射跳转错误");
			e.printStackTrace();
		}
	}
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/404.jsp").forward(request, response);
	}

}
