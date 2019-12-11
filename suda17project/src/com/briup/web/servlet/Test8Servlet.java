package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session对象
 */
@WebServlet("/test8")
public class Test8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session对象的创建方式
//		HttpSession session1 = request.getSession(true);
//		HttpSession session2 = request.getSession(false);
		HttpSession session3 = request.getSession();
		
		System.out.println(session3);
		
		//application对象的创建方式
		
		ServletContext sc1 = getServletContext();
//		ServletContext sc2 = this.getServletContext();
//		ServletContext sc3 = request.getServletContext();
//		ServletContext sc4 = request.getSession().getServletContext();
		
		//如何保存和取到数据
		request.setAttribute("r", "request");
		session3.setAttribute("s", "session");
		sc1.setAttribute("c", "context");
		
		request.getAttribute("r");
		session3.getAttribute("s");
		sc1.getAttribute("c");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
