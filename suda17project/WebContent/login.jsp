<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=(String)request.getAttribute("basePath") %>">
<meta charset="UTF-8">
<meta name='referrer' content='no-referrer'/>
<title>用户登录</title>
<link rel="stylesheet" href="css/test1.css" type="text/css">
<script type="text/javascript" src="test1.js"></script>
</head>
<body>
	<div id="center">
		<form action="login" method="get">
		帐号：<input type="text" name="username"> <br>
		密码：<input type="password" name="password"> <br>
		<br>
		<div class="check">
		<input type="checkbox" value="autoLogin" name="isAuto"><span class="desc">七天内自动登录</span>
		<a id="forget" href="#"> 忘记密码？ </a>
		<br>
		</div>
		
		<!-- <br>
		<input type="checkbox" value="苹果" name="fruit">苹果
		<input type="checkbox" value="香蕉" name="fruit">香蕉
		<input type="checkbox" value="凤梨" name="fruit">凤梨
		<input type="checkbox" value="哈密瓜" name="fruit">哈密瓜
		<br> -->
		
		<input type="submit" value="登录">
		<a href="html/register.html">注册</a>
		<!-- <a href="test11;jsessionid=7CCDA48C88119611E4E403C7B6AC43C3">测试URL重写</a> -->
		</form>
	</div>
 	<div>
		<!-- <img src="http://pic.netbian.com/uploads/allimg/191106/235347-1573055627f677.jpg"> -->
		<!-- <img src="./zha.jpg"> -->
		
	</div>
	
</body>
</html>