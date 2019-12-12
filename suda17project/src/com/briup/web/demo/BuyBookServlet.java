package com.briup.web.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.EsBook;
import com.briup.bean.EsOrder;
import com.briup.bean.EsUser;
import com.briup.sevice.impl.OrderServiceImpl;

@WebServlet("/buyBook")
public class BuyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//servcice层的实例对象
	private OrderServiceImpl orderimpl = new OrderServiceImpl(); 
	
	private static List<EsBook> list;
	static {
		list = new ArrayList<>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//1、接收表单里的信息
		Long id=Long.parseLong(request.getParameter("book_id"));
		String name =request.getParameter("book_name");
		Double price = Double.parseDouble(request.getParameter("book_price"));
		String desc = request.getParameter("book_desc");
		String publish = request.getParameter("book_publish");
		//Date date = request.getParameter("book_publishdate");
		//字符串和date的互相转化
		String author = request.getParameter("book_author");
		
		EsBook book = new EsBook(id,name,price,desc,publish,author,null);
		//第一种方法：可以用一个集合来吧这个book存到session里
		list.add(book);
		//第二种方法把这个book存到数据库表中
		EsOrder order = new EsOrder();
		EsUser user =(EsUser) session.getAttribute("user");
		order.setUserid(user.getId());
		order.setBookid(id);
		try {
			orderimpl.addOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//不管哪个方法，都要放到session里
		session.setAttribute("orderlist", list);
		//跳转页面
		response.sendRedirect("html/BuyingSucc.html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
