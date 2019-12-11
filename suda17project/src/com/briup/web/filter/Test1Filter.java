package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 第一个filter的编写
 * @author CuiGX
 *
 */
public class Test1Filter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter初始化。。。");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 逻辑
		System.out.println("过滤器执行。。。");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("filter销毁。。。");
	}

}
