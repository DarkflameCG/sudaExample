<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		exception.printStackTrace(new PrintWriter(out));
		try{
			int i= 1/0;
		}catch(Exception e){
			e.printStackTrace(new PrintWriter(out));
		}
	%>
</body>
</html>