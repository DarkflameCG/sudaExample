package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 内部跳转和重定向
 */
@WebServlet("/test5")
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//内部跳转
		//servlet
		//request.getRequestDispatcher("/test4").forward(request, response);
		//html
		//request.getRequestDispatcher("login.html").forward(request, response);
		
		//重定向
		String path = "/suda17project";
		//servlet
		//response.sendRedirect(path+"/test4");
		//html
		//response.sendRedirect(path+"/login.html");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
