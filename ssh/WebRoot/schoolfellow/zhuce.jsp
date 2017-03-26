<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script language="javascript" src="css/calendar.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>注册</title>
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
.pict{width:166px;float:left}
-->
</style></head>

<body>
<form name="myform" id="myf" action="" method="post" >
<input type="hidden" name="ids" value="${intro.id}"/>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="32">&nbsp;</td>
    <td width="916" height="58" background="images/i-2.jpg"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="30">&nbsp;</td>
        <td width="200" align="center" valign="middle" class="t3"></td>
        <td width="200" align="center" valign="middle" class="t3"></td>
        <td width="200" align="center" valign="middle" class="t3"></td>
        <td width="200" align="center" valign="middle" class="t3"></td>
        <td width="30">&nbsp;</td>
      </tr>
    </table></td>
    <td width="43">&nbsp;</td>
  </tr>
</table>

<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="10">&nbsp;</td>
    <td bgcolor="E3F7F8">
    <table width="100%" height="205" border="0" cellpadding="0" cellspacing="0">
	  <tr><td width="60">&nbsp;</td></tr>
      <tr>
      <td>
        <table width="500" border="0" align="center" cellspacing="0" cellpadding="0">
        	<tr><td width="100">&nbsp;</td></tr>
        	<tr><td>用户名</td>
        	<td><input type="text" id="un" name="username"/></td>
        	</tr>
        	<tr>
        	<td>密码</td>
        	<td><input type="password" name="password" id="ps"/></td>
        	</tr>
        	<tr>
        	<td>确认密码</td>
        	<td><input type="password" name="passwods" id="qp"/></td>
        	</tr>
        	<tr><td></td><td><input type="button" value="下一步" onclick="tijiao();"/></td></tr>
        	<tr><td><font color="red" size="3">${error}</font></td></tr>
        </table>
     </td> 
     </tr>
     <tr><td height="50">&nbsp;</td></tr>
    </table>
    </td>
    <td width="41" height="20">&nbsp;</td>
  </tr>
</table>
</form>
<script type="text/javascript">
function tijiao(){
	var um = document.getElementById("un").value;
	var ps = document.getElementById("ps").value;
	var qp = document.getElementById("qp").value;
	if(um == null || um == ""){
		alert("请输入用户名");
		return false;
	}else if(ps == null || ps == ""){
		alert("请输入密码");
		return false;
	}else if(qp == null || qp == ""){
		alert("请输入确认密码");
		return false;
	}
	if(ps.length < 6){
		alert("密码的长度应该大于等6");
		return false;
	}
	if(qp.length < 6){
		alert("密码的长度应该大于等6");
		return false;
	}
	if(ps != qp){
		alert("两次输入的密码不一至");
		return false;
	}else{
		document.getElementById("myf").action="zc.html?ssh=up";
		document.getElementById("myf").submit();
	}
}

</script>
</body>
</html>
