package com.briup.suda;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;

@WebServlet()
public class Hello2Servlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("servlet destory...");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet init...");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("console print ...");
		
		PrintWriter pw = res.getWriter();
		pw.println("Hello, World!");
		pw.flush();
		
		//第一种方法
		ServletOutputStream sos = res.getOutputStream();		
		FileInputStream fis = new FileInputStream(new File("D:\\4k壁纸\\67101396_p0.jpg"));
		
		int len = 0;
		byte[] buff = new byte[1024];
		
		while((len=fis.read(buff))>0) {
			sos.write(buff, 0, len);
		}
		fis.close();
		sos.close();
		
		//第二种方法
		
		String con = "哈哈哈";
		
		pw.println("<html><head><meta name='referrer' content='no-referrer'/></head><body><img src='http://pic.netbian.com/uploads/allimg/191106/235347-1573055627f677.jpg'/></body></html>");
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div>"+con+"</div>");
		pw.println("</body>");
		pw.println("</html>");
		
		
		
		pw.flush();
		
	}

}
