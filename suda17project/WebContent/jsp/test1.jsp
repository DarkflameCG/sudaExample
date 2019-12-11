<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page errorPage="eroor1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:useBean id="u" class="com.briup.bean.User" scope="page"/> --%>

	<%--<jsp:forward page="../login.html"></jsp:forward>--%>
 	<%
		List<String> list = new ArrayList<>();	
		list.add("张三");
		list.add("李四");
		int a =1/0;
		/* list.add("joker"); */
		//list.add("mint");
		/**这是文档注释*/
		out.println(list);
		out.println(request.getScheme());
		//范围对象
		session.setAttribute("tom1", "tom1");
		request.setAttribute("tom2", "tom2");
		application.setAttribute("tom3", "tom3");
		pageContext.setAttribute("tom4", "tom4");
		
		out.println(pageContext.getAttribute("tom4"));
		out.println(config.getServletName());
		
	%>

	<%=(page==this)%>
	<%!
		//private int a;
		private String name;
		public void jspInit(){
			System.out.println("初始化");
		}
	%>
	<div>
		<!-- 这是html文档的注释 -->
		<!-- <h1>test1</h1> -->  
		<h2>这是第一段</h2>
		<p>这是正文</p>
	</div>
</body>
</html>