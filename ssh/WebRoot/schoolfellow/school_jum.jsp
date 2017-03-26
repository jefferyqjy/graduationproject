<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body >
<script type="text/javascript">
function jum(){
var id = document.getElementById("dd").value;
window.location="sch.html?ssh=findleave&id="+id;
}
</script>
<a href="#" onclick="jum();">保存成功</a>
<input type="hidden" value="${ids }" id="dd" name="id"/>
</body>
</html>