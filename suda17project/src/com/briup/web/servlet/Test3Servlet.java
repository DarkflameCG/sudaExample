package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test3")
public class Test3Servlet implements Servlet{

	public Test3Servlet() {
		System.out.println("servlet3...");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet3 init...");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("servlet3 service...");
	}

	@Override
	public String getServletInfo() {
		return "qwer";
	}

	@Override
	public void destroy() {
		System.out.println("servlet3 destory...");
	}

}
