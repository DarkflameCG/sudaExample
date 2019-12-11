package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;

/**
 * 测试session的活化和钝化
 * 在session的生效范围内服务器正产关闭
 * 钝化：session对象会序列化成一个文件保存在work里
 * 活化：服务器在生效范围内开启
 * 		SESSIONS.ser文件会反序列化成一个session对象重新加载
 */
@WebServlet("/test9.do")
public class Test9Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("user");
		
		response.getWriter().println("帐号："+user.getUsername());
		response.getWriter().println("帐号："+user.getPassword());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
