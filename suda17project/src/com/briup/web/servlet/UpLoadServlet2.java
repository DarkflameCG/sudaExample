package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * servlet3.1的上传操作
 */
@WebServlet("/upload2")
@MultipartConfig(location = "E:\\netResource\\upload")
public class UpLoadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		System.out.println(username);
		
		//获取上传的文件  part里就是文件的所有信息
		Part part = request.getPart("file");
		
		//获取上传文件的名字
		//servlet3.1的方法
		String fileName = part.getSubmittedFileName();
		
		System.out.println(username+" 上传了文件："+fileName);
		
		//避免上传的文件重复，文件名前面加上时间戳
		part.write(System.currentTimeMillis()+"-"+fileName);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
