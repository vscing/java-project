package com.servlet.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */
public class MainServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("123");
		ServletConfig config = this.getServletConfig();
		//获取servlet在web.xml 中的配置名称
		String name = config.getServletName();
		System.out.println(name);
		//获取servlet在web.xml 中的配置内容
		String contents = config.getInitParameter("测试1");
		System.out.println(contents);
		//获取当前servlet中配置的全部初始化参数
		Enumeration<String> initValue = config.getInitParameterNames();
		while (initValue.hasMoreElements()) {
			String names =  initValue.nextElement();
			String values = config.getInitParameter(names);
			System.out.println("名称:"+names+" 值:"+values);
		}
		ServletContext context = this.getServletContext();
		String c1 = context.getInitParameter("测试c1");
		System.out.println(c1);
		Enumeration<String> cValue = context.getInitParameterNames();
		while (cValue.hasMoreElements()) {
			String names =  cValue.nextElement();
			String values = context.getInitParameter(names);
			System.out.println("名称:"+names+" 值:"+values);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
