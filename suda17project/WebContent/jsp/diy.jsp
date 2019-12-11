<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.briup.cgx/core" prefix="cgx" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setAttribute("count", 8);
		request.setAttribute("username", "joker");
	%>
	<cgx:hello count="${requestScope.count}">${requestScope.username}</cgx:hello>
</body>
</html>