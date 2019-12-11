<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	获取请求里的参数：
	${param.password}
	<hr>
	<h2>${sessionScope["name2"]}的分数为${param.score}，评价为${param.score >60?"good":"bad"}</h2>
</body>
</html>