package com.briup.web.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;

/**
 * 模仿登录成功后的主页
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		//展示一段谁谁谁登录成功
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		//User user =(User)session.getAttribute("user");
		User user =new User("joker","8888");
		session.setAttribute("user", user);
		response.getWriter().println(user.getUsername()+"，恭喜你！登录成功！");
		
		//销毁session（测试的时候再打开注释）
		//session.invalidate();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
