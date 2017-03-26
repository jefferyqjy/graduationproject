<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/tour.tld" prefix="tour" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>校友录</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #000000;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.t1 {
	border-right-width: 2px;
	border-right-style: solid;
	border-right-color: #999999;
}
.t2 {
	border-left-width: 2px;
	border-left-style: solid;
	border-left-color: #999999;
}
.t3 {
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #999999;
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style>
</head>

<body>
<form name="myform" id="myf" action="" method="post">
<table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="34" class="t1" scope="row">&nbsp;</th>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <th scope="row"><img src="images/main02_02.jpg" width="937" height="52" /></th>
      </tr>
	   <tr>
        <th scope="row"><img src="images/main02_04.jpg" width="937" height="105" /></th>
      </tr>
	   <tr>
        <th scope="row"><img src="images/main02_05.jpg" width="937" height="110" /></th>
      </tr>
	   <tr><td>
	   <table width="100%" >
	   <tr>
	   <td width="50" height="">&nbsp;</td>
	   <td valign="top">
	   <table width="100%" border="0" align="center">
	   <tr><td height="30" align="center">${fl.title}</td></tr>
	   <tr><td height="30" align="center">作者:${fl.name}</td></tr>
	   <tr><td height="30" align="left">时间:${fl.date}</td></tr>
	   <tr><td  valign="top"><font size="3">&nbsp;&nbsp;&nbsp;&nbsp;${fl.count}</font></td></tr>
	   </table></td>
  	   <td width="50">&nbsp;</td>
	   </tr>
	   </table>
	   </td></tr>
	   <tr>
        <th scope="row"><img src="images/main02_19.jpg" width="937" height="36" /></th>
      </tr>
	  <tr>
        <th height="50" bgcolor="#F9FBF6" scope="row"><img src="images/h.jpg" width="310" height="16" /></th>
      </tr>
    </table></td>
    <td width="34" class="t2">&nbsp;</td>
  </tr>
</table>
</form>
<br />
<script type="text/javascript">
function log(){
	var un = document.getElementById("un").value;
	var ps = document.getElementById("ps").value;
	if(un == null || un== ""){
		alert("请输入用户名");
		return false;
	}else if(ps == null || ps == ""){
		alert("请输入密码");
		return false;
	}else {
		document.getElementById("myf").action="login.html";
	}
}
function zc(){
	document.getElementById("myf").action="zc.html?ssh=zhuce";
}
</script>
</body>
</html>
