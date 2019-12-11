package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request里的方法
 * SevletContext里和路径相关的方法
 */
@WebServlet("/test7.do")
public class Test7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//上半场
		System.out.println(request.getScheme());  //获取当前协议  http
		System.out.println(request.getServerName());   //获取当前主机名称    ip
		System.out.println(request.getServerPort());  //获取当前端口号
		System.out.println(request.getContextPath());  //获取资源的路径  项目名字
		System.out.println(request.getContentType());  //text/html    null
	
		//下半场
		System.out.println(request.getServletPath());
		//servlet的映射  /test7
		
		System.out.println(request.getRequestURI());
		//完整的URI         /suda17project/test7
		
		System.out.println(request.getRequestURL());
		//完整的URL  http://localhost:2333/suda17project/test7
		
		System.out.println("======================");
		
		//ServletContext     application
		ServletContext sc = getServletContext();
		System.out.println(sc.getContextPath());
		System.out.println(sc.getRealPath("/image/zha.jpg"));
		System.out.println(sc.getResource("login.html"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
