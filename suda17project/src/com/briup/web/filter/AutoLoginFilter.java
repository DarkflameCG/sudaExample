package com.briup.web.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截登录，判断cookie里的帐号密码
 * 从而完成自动登录
 */
@WebFilter("/login.html") //代表访问哪个资源
public class AutoLoginFilter implements Filter {

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//获取cookie里的信息
		Cookie[] cookies = req.getCookies();
		//遍历cookie
		Cookie coo = null;
		if(cookies==null||cookies.length==0) {
			//第一次访问的时候一定没有cookie
			//不拦截，直接放行
			chain.doFilter(request, response);
			return;
		}
		for(int i=0;i<cookies.length;i++) {
			if("AutoLoginInfo".equals(cookies[i].getName())) {
				coo = cookies[i];
			}
		}
		//拆分字符串
		//当没有勾选自动登陆时，coo是个空对象
		if(coo==null) {
			chain.doFilter(request, response);
			return;
		}
		//当勾选自动登陆时，coo有值
		String[] info =coo.getValue().split("@");   // tom@123
		System.out.println("拦截器拦截帐号密码："+Arrays.toString(info));
		//根据拿到的信息进行判断
		if("tom".equals(info[0]) && "123".equals(info[1])) {
			res.sendRedirect("index");
			return;
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
