<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script language="javascript" src="css/calendar.js"></script>
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
        <td width="150" align="center" valign="middle" class="t3"><a href="sch.html?ssh=sc" target="right">班 级</a></td>
        <td width="150" align="center" valign="middle" class="t3"><a href="sch.html?ssh=allintro" target="right">成   员</a></td>
        <td width="150" align="center" valign="middle" class="t3"><a href="sch.html?ssh=forum">论  坛</a></td>
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
        	<tr>
        	<td>标题</td><td><input type="text" name="names" id="" value="${intro.name}"/></td>
        	</tr>
        	<tr>
        	<td>内容</td>
        	<td>
        	<textarea rows="20" name="count" cols="50"></textarea>
        	</td>
        	</tr>
        	
        	<tr><td></td><td><input type="button" value="保存" onclick="tijiao();"/></td></tr>
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
	document.getElementById("myf").action="sch.html?ssh=up";
	document.getElementById("myf").submit();
}

</script>
</body>
</html>
