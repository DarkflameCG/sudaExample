package com.briup.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * servlet3.0之前的上传操作
 */
@WebServlet("/upload1")
public class UpLoadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "D:\\jd2019\\upload";
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		//页面表单中设置了enctype="multipart/form-data"后
		//无法直接通过getParameter方法获取普通组件的参数值
		System.out.println("getParameter username = "+username);
		
		//如果是上传的目录在项目中，可以通过该方法获得该上传目录的绝对路径
//		String realpath = getServletContext().getRealPath(path);
		
		try {
			//构造一个文件上传处理对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upLoad = new ServletFileUpload(factory);
			
			//获得表单中提交内容
			List<FileItem> list = upLoad.parseRequest(request);

			for (FileItem fileItem : list) {
				//fileItem.isFormField()返回true表示是普通的表单组件
				//fileItem.isFormField()返回false表示是上传输入框
				if (fileItem.isFormField()) {
					//getFieldName()方法获得普通表单组件的参数名
					String FieldName = fileItem.getFieldName();
					//获得该参数所对应的值并指定编码
					String Content = fileItem.getString("UTF-8");
					//为了后面可以把普通参数从request中拿出来
					request.setAttribute(FieldName, Content);
				} else {
					//getName()取得上传文件的名字
					String fileName = fileItem.getName();
					//避免文件名字重复
					fileName = System.currentTimeMillis()+"-"+fileName;
					File file = new File(path, fileName);
					//把上传文件进行指定目录
					fileItem.write(file);
				}
			}
			
			//因为上面解析request中是数据后,把普通表单组件中的key和value放到了request中,所以这里可以拿出来
			System.out.println("request.getAttribute(\"username\") = "+request.getAttribute("username"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
