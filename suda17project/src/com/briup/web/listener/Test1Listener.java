package com.briup.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 第一类listener
 * 监听request、session、application对象
 * @author CuiGX
 *
 */

public class Test1Listener implements 
HttpSessionListener,
ServletRequestListener,
ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application初始化。。。");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application销毁。。。");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest req = (HttpServletRequest)sre.getServletRequest();
		System.out.println(req.getServletPath()+"请求结束。。。");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest req = (HttpServletRequest)sre.getServletRequest();
		System.out.println(req.getServletPath()+"请求进入。。。");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"创建。。。");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"session销毁。。。");
	}

	
	
	
	
	
	
	
	
	
	
	
}
