<%@page import="com.briup.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name1", "tom1");
		session.setAttribute("name2", "tom2");
		application.setAttribute("name3", "tom3");
		pageContext.setAttribute("name4", "tom4");
		
		User user = new User("joker","123");
		session.setAttribute("tu", user);
		
		session.setAttribute("javax.aaa.bbb.ccc", "javax");
		
		String score = "59";
		pageContext.setAttribute("score", score);
		
		//准备一个数组、一个arraylist、一个map
		int[] a = {1,2,3,4,5}; 
		
		List<String> list = new ArrayList<String>();
		list.add("中午");
		list.add("11点");
		list.add("52分");
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put( "哈哈哈",1);
		map.put( "嘿嘿嘿",2);
		map.put( "嘻嘻嘻",3);
		
		pageContext.setAttribute("array", a);
		pageContext.setAttribute("list", list);
		pageContext.setAttribute("map", map);
		
	%>
	
	页面上输出值：
	<%=(String)request.getAttribute("basePath")%>
	<hr>
	el表达式：${requestScope.name1}，登录成功！
	<a href="test2.jsp?score=${score}">点击跳转</a>
	<hr>
	不指定范围：
	顺序：pageContext->request->session->application
	<br>
	${basePath}
	<hr>
	<h4>对象里取值</h4>
	指定范围：${sessionScope.tu.username} 登录成功！<br>
	不指定范围： 密码：${tu.password}， 性别：${tu.sexStr}，
	地址：${tu.address.contury}${tu.address.city}${tu.address.street}
	
	<hr>
	取不到值：${sessionScope.javax.aaa.bbb.ccc}<br>
	取的到值：${sessionScope["javax.aaa.bbb.ccc"]}
	
	<hr>
	<h4>输出一个字符串：${"helloword"}</h4>
	
	<hr>
	<h3>运算符</h3>
	${1+1}
	${2*4+6-8/2} 
	${empty ""}  和  ${empty "hello"}
	${not empty ""} 和 ${! empty ""}
	
	<hr>
	<h3>输出数组和集合</h3>
	一般都是用来遍历：
	数组：${array[0]}<br>
	list：${list}<br>
	map：${map["嘿嘿嘿"]}<br>

	
	
	
	
	
	
</body>
</html>