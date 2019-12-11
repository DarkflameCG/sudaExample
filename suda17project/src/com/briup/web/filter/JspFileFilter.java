package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 过滤jsp文件，给补充上basePath
 */
@WebFilter(value="*.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class JspFileFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		
		String basePath = request.getScheme()+"://"+
						  request.getServerName()+":"+
						  request.getServerPort()+
						  req.getContextPath()+"/";
		request.setAttribute("basePath", basePath);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
