<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
body,td,th {
	font-family: 宋体;
	font-size: 12px;
	color: #000000;
}
a {
	font-size: 12px;
	color: #6699CC;
}
a:link {
	text-decoration: none;
	color: #0099CC;
}
a:visited {
	text-decoration: none;
	color: #0099CC;
}
a:hover {
	text-decoration: none;
	color: #999999;
}
a:active {
	text-decoration: none;
	color: #999999;
}
.t3 {
	font-family: "宋体";
	font-size: 14px;
	font-weight: bold;
	color: #0099FF;
}
.t5 {
}
.t4 {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #0099CC;
	border-left-color: #0099CC;
	border-right-color: #0099CC;
	border-bottom-color: #D6D3CE;
}
.xia {
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #0099CC;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #0099CC;
	border-left-color: #0099CC;
}
.zuo {
	border: 1px solid #999999;
}
.zou {
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #0099FF;
}
.STYLE2 {color: #0099CC}
.STYLE3 {font-size: 14px; color: #0099FF; font-family: "宋体";}
.liu {
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #3366CC;
}
-->
</style>
</head>

<body>
<form action="" name="myform" id="myf" method="post">
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="32">&nbsp;</td>
    <td width="916" height="58" background="images/i-2.jpg"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="30">&nbsp;</td>
        <td width="200" align="center" valign="middle" class="t3"><a href="ge.html">主 页</a></td>
        <td width="200" align="center" valign="middle" class="t3"><a href="ph.html?ssh=all">相 册</a></td>
        <td width="200" align="center" valign="middle" class="t3"><a href="lea.html?ssh=all">留言板</a></td>
        <td width="200" align="center" valign="middle" class="t3"><a href="fir.html?ssh=all">好 友</a></td>
        <td width="30">&nbsp;</td>
      </tr>
    </table></td>
    <td width="43">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="10">&nbsp;</td>
    <td bgcolor="E3F7F8">&nbsp;</td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="10">&nbsp;</td>
    <td bgcolor="E3F7F8">
    <table width="100%" height="205" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="800" height="10" align="left" valign="top" align="center">
         <table border="0" width="100%">
         	<tr><td>
         	<c:if test="${er != null}">${er}</c:if>
         	<c:if test="${er == null}">发送成功</c:if>
         	</td></tr>
         </table>
         </td><td width="15"><br />
          <br /></td>
      </tr>
    </table></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
</form>
<script type="text/javascript">
function tj(){
	var tx = document.getElementById("un").value;
	var ti = document.getElementById("ti").value;
	var co = document.getElementById("co").value;
	if(tx == null || tx == ""){
		alert("收信人不能为空");
		return false;
	}else if(ti == null || ti == ""){
		alert("标题内容不能为空");
		return false;
	}else if(co == null || co == ""){
		alert("内容不能为空");
		return false;
	}else{
		document.getElementById("myf").action="mail.html?ssh=sa";
		document.getElementById("myf").sumbit();
	}
}
</script>
</body>
</html>
