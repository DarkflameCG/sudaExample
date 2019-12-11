package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//注解
@WebServlet("/servlettest1")
public class Test1Servlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {

		//super.init();
		System.out.println("GenericSevrlet init...");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO 逻辑代码
		res.getWriter().println("genericServlet...");
		
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	
	@Override
	public void destroy() {
		
	}

}
