package com.briup.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test2",loadOnStartup = -1,
initParams = {
		@WebInitParam(name="username",value="joker",description="帐号"),
		@WebInitParam(name="password",value="123",description="密码")
},description = "这是一个servlet",displayName = "aaa")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	public void init() throws ServletException {
		ServletConfig sf = super.getServletConfig();
		//第一个方法
		String sn = sf.getServletName();
		System.out.println("servlet的名字："+sn);
		//第二个方法
		ServletContext sc= sf.getServletContext();
		//第三个方法（已知初始化参数的名字）
		String username =sf.getInitParameter("username");
		String password =sf.getInitParameter("password");
		System.out.println("帐号："+username);
		System.out.println("密码："+password);
		//第四个方法：不知道初始化参数的名字
		Enumeration<String> names= sf.getInitParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
			String v =sf.getInitParameter(names.nextElement());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//逻辑
		resp.getWriter().println("get method ...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//逻辑
		resp.getWriter().println("post method ...");
	}
}
