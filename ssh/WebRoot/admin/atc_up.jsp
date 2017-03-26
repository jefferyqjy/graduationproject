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
<form action="" id="myf" name="myf" method="post">
<input type="hidden" value="${news.id}" name="id"/>
<table border="1" width="800">
<tr>
<td>标题</td><td><input type="text" name="title" id="tt" value="${news.title}"/></td>
</tr>
<tr>
<td>内容</td><td><textarea rows="10" cols="50" name="count" id="cc">${news.count}</textarea></td>
</tr>
<tr><td colspan="2"><input type="button" value="保存" onclick="bj();"/></td></tr>
</table>
</form>
<script type="text/javascript">
function bj(){
	var tt = document.getElementById("tt").value;
	var cc = document.getElementById("cc").value;
	if(tt == null || tt == ""){
		alert("");
		return false;
	}else if(cc == null || cc == ""){
		alert("");
		return false;
	}else{
		document.getElementById("myf").action="admin.html?ssh=updatc"
		document.getElementById("myf").submit();
	}
}
</script>
</body>
</html>