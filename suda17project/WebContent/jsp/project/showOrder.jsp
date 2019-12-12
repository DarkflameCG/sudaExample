<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${orderlist}" var="book">
		购买<h4>${book.name}，${book.price} </h4>一本
	</c:forEach>
</body>
</html>