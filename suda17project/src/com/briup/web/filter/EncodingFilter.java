package com.briup.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 编码过滤器
 */
@WebFilter(value="/*",initParams = {
		@WebInitParam(name = "encodeStr",value = "UTF-8")
})
public class EncodingFilter implements Filter {
	
	//成员变量
	private String encodeStr = "";
	
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		request.setCharacterEncoding(encodeStr);
		response.setCharacterEncoding(encodeStr);
		response.setContentType("text/html");
		
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		encodeStr = fConfig.getInitParameter("encodeStr");
	
	
	}

}
