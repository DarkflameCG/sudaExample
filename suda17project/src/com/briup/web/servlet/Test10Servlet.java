package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie的一些操作
 */
@WebServlet("/Test10Servlet")
public class Test10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//创建cookie
		Cookie cookie1 = new Cookie("username", "joker");
		Cookie cookie2 = new Cookie("msg", "infomation");
		Cookie cookie3 = new Cookie("date", "1205");
		
		cookie1.setMaxAge(60);
		cookie1.setMaxAge(30);
		cookie1.setMaxAge(60*60*24);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		//销毁cookie
		//获得cookie
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++) {
			//销毁全部
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
			//指定销毁某一个cookie
			if("msg".equals(cookies[i].getName())) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
