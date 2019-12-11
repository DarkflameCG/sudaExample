package com.briup.web.demo;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Arrays;

import com.briup.bean.User;
import com.briup.sevice.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().println("开始。。。");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		//response.getWriter().println("结束。。。");
		
		//一个参数对应一个值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isAutoLogin = request.getParameter("isAuto");
		//一个参数对应多个值
//		String[] fruits = request.getParameterValues("fruit");
//		System.out.println(Arrays.toString(fruits));
		//获取所有的参数的名字
//		Enumeration<String> pns = request.getParameterNames();
//		while(pns.hasMoreElements()) {
//			System.out.println(pns.nextElement());			
//		}
//		
		//获取所有的参数的名字和值
		Map<String, String[]> pnvs = request.getParameterMap();
		Set<String> set =pnvs.keySet();
		for(String s : set) {
			System.out.println("key:"+s+"，value:"+Arrays.toString(pnvs.get(s)));
		}
		
		//根据拿到的参数，作判断
		
		LoginServiceImpl impl = new LoginServiceImpl();
		try {
			boolean flag = impl.userLogin(username, password);
			if(flag) {
				//当用户存在
				User user = new User(username,password);
				//将登陆信息保存在session里
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//先判断是否勾选了自动登录
				if("autoLogin".equals(isAutoLogin)) {
					//勾选了自动登录
					//将登陆信息保存在cookie里
					Cookie cookie = new Cookie("AutoLoginInfo", username+"@"+password);
					cookie.setMaxAge(60*60*24*7);  //十天内免登陆
					response.addCookie(cookie);
				}
				response.sendRedirect("html/mainpage.html");				
			}else {
				//如果登录失败
				//重新跳转到登录页上
				response.sendRedirect("login.html");		
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
