<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${basePath}">
<title>首页</title>
</head>
<body>
	<table border='1px'   cellspacing='0'  align='center'  cellpadding='2px' >
		<tr align='center' >
			<td>编号</td>
			<td>书名</td>
			<td>价格</td>
			<td>描述</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>作者</td>
		</tr>
		<c:forEach items="${booklist}" var="book" >
		<form action="buyBook"  method='post'>
			<tr align='center' >
				<td><input type='text' name='book_id' value='${book.id}' readonly="readonly" style='text-align:center'></td>
				<td><input type='text' name='book_name' value='${book.name}' readonly="readonly"  style='text-align:center'></td>
				<td><input type='text' name='book_price' value='${book.price}' readonly="readonly"  style='text-align:center'></td>
				<td><input type='text' name='book_desc' value='${book.desc}' readonly="readonly"   style='text-align:center'></td>
				<td><input type='text' name='book_publish' value='${book.publish}' readonly="readonly" style='text-align:center'></td>
				<td><input type='text' name='book_publishdate' value='${book.publishdate}' readonly="readonly" style='text-align:center'></td>
				<td><input type='text' name='book_author' value='${book.author}' readonly="readonly" style='text-align:center'></td>
				<td><a><input  type='submit'  value='购买'></a></td>
				<td><a>查看详情</a></td>  <!--跳转到某一本书的详情-->
			</tr>
		</form>
		</c:forEach>
	</table>
</body>
</html>