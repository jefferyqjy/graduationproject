<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>校友录</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 14px;
	color: #00AE9C;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.t1 {
	font-family: "宋体";
	font-size: 15px;
	font-weight: bold;
	color: #00AE9C;
	border-bottom-width: 2px;
	border-bottom-style: solid;
	border-bottom-color: #63D7C6;
}
-->
</style>
</head>

<body>
<form action="" method="post" id="myf" name="myform">
<table width="1005" height="77" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/index_01.jpg" width="1005" height="77" /><br />
      <table width="1005" height="10" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<br />
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="32">&nbsp;</td>
    <td><img src="images/index_04.jpg" width="919" height="32" /></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="52">&nbsp;</td>
    <td width="521"><img src="images/index_06.jpg" width="521" height="52" /></td>
    <td><table width="100%" height="52" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20" height="5"><img src="" alt="" name="h" width="10" height="5" id="h" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td class="t1">校友录用户登陆</td>
        <td width="20">&nbsp;</td>
      </tr>
      <tr>
        <td height="5"><img src="" alt="" name="h" width="10" height="5" id="h" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    <td width="21"><img src="images/index_02.jpg" width="21" height="52" /></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="72">&nbsp;</td>
    <td width="521"><img src="images/index_08.jpg" width="521" height="72" /></td>
    <td><table width="100%" height="72" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20">&nbsp;</td>
        <td width="80" align="center">用户名：</td>
        <td align="left" valign="middle">
        <input type="text" size="24" id="un" name="username" height="20"/></td>
        <td width="20">&nbsp;</td>
      </tr>
      <tr>
        <td height="5"><img src="" alt="" name="h" width="10" height="5" id="h" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center">密 码：</td>
        <td align="left" valign="middle">
	        <input type="password" size="24" id="ps" name="passwords" height="20"/></td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    <td width="21"><img src="images/index_05.jpg" width="21" height="72" /></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="90">&nbsp;</td>
    <td width="521"><img src="images/index_22.jpg" width="521" height="90" /></td>
    <td><table width="100%" height="90" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td width="150" align="right"><input type="image" name="button" src="images/index_27.jpg" onclick="return log()"/></td>
        <td align="center">&nbsp;</td>
        <td width="150"><input type="image" name="button" src="images/zc2.jpg" onclick="zc();"/></td>
      </tr>
      <tr>
        <td colspan="3" align="center">&nbsp;<font color="red">${error }</font></td>
      </tr>
    </table></td>
    <td width="21"><img src="images/index_24.jpg" width="21" height="90" /></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="122">&nbsp;</td>
    <td><img src="images/ingdexg_16.jpg" width="919" height="122" /></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="87">&nbsp;</td>
    <td height="7"><img src="images/index_34.jpg" width="521" height="87" /></td>
    <td width="398"><img src="images/index_35.jpg" width="398" height="87" /></td>
    <td width="41">&nbsp;</td>
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
