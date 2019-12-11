<%@page import="com.briup.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		String score = "100";
		pageContext.setAttribute("score", score);
		
		//准备一个数组、一个arraylist、一个map
		int[] a = {1,2,3,4,5}; 
		
		List<User> list = new ArrayList<User>();
		list.add(new User("happy","123"));
		list.add(new User("lilith","123"));
		list.add(new User("mark","123"));
		list.add(new User("张三","123456"));
	
		
		Map<String,User> map = new HashMap<String,User>();
		map.put( "1",new User("larry","123"));
		map.put( "2",new User("lilith","123"));
		map.put( "3",new User("张三","123456"));
		
		pageContext.setAttribute("array", a);
		pageContext.setAttribute("list", list);
		pageContext.setAttribute("map", map);
		
	%>
	
	<hr>
	<%-- <c:import var="data" url="el.jsp" /> --%>
	
	<c:choose>
		<c:when test="${score>=90}">优</c:when>
		<c:when test="${score>=80}">良</c:when>
		<c:when test="${score>=70}">中</c:when>
		<c:when test="${score>=60}">及格</c:when>
		<c:otherwise>差</c:otherwise>
	</c:choose>
	重定向<br>
	<c:redirect url="el.jsp"></c:redirect>
	
	没有学的
	<c:param name=""></c:param>
	<c:forTokens items="" delims=""></c:forTokens>
	<c:url></c:url>
	
	<hr>
	<table>
		<tr>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
		</tr>
		<c:forEach items="${pageScope.list}" var="user" begin="1" end="2">
			<tr>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.sexStr }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
		<c:forEach items="${pageScope.map}" var="entry">
			${entry.key} ----->  ${entry.value.username}
			<br>
		</c:forEach>
		
	<%-- <c:out value="${list}"></c:out> --%>
	<hr>
	<h2>向某一范围对象中加入值</h2><br>
	<c:set var="aaa" value="${list}" scope="request"></c:set>
	${requestScope.aaa}
	<h2>从某一范围内删除一个值</h2><br>
	<c:remove var="aaa" scope="request"/>
	${requestScope.aaa}
	<hr>
	<h2>判断</h2><br>
	<c:if test="${pageScope.list[0].username =='tom'}">
		${"会员登录！"}
	</c:if>
 	<c:if test="${not list[0].username !='tom'}">
		${"普通用户登录！"}
	</c:if>
	
	<hr>
	<h3>捕捉异常</h3><br>
	<c:catch var="catchException">
		<%int i = 1/0;%>
	</c:catch>
	<c:if test="${catchException !=null }">
		<p>异常为 : ${catchException} <br />
	   	发生了异常: ${catchException.message}</p>
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>