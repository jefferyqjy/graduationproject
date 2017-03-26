<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="800">
<tr><td colspan="5" align="center">活动列表</td></tr>
<c:forEach items="${list}" var="li" >
<tr>
<td width="15"></td>
<td height="30"><a href="home.html?ssh=news&id=${li.id}" target="_blank">${li.title}</td>
<td width="60" align="center"><a href="admin.html?ssh=showact&id=${li.id}">修改</a></td>
<td width="60" align="center"><a href="admin.html?ssh=delatc&id=${li.id}">删除</a></td>
<td width="15"></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td ><input type="button" value="添加" onclick="javascript:window.location='admin.html?ssh=jumatc'"/></td>
<td><a href="admin.html?ssh=atclist&page=1">首页</a>
<a href="admin.html?ssh=atclist&page=${pageback}">上一页</a>
<a href="admin.html?ssh=atclist&page=${pagenext}">下一页</a>
<a href="admin.html?ssh=atclist&page=${pagetotal}">末页</a></td>
</tr>
</table>
</body>
</html>