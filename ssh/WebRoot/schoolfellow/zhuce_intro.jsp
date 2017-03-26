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
        	<tr>
        	<td>姓  名</td><td><input type="text" name="names" id="un" /></td>
        	</tr>
        	<tr>
        	<td>性  别</td>
        	<td>
        	<input type="radio" name="sex" value="男" checked/>男
        	<input type="radio" name="sex" value="女"/>女
        	</td>
        	</tr>
        	<tr>
        	<td>生  日</td>
        	<td>
        	<input type="text" name="year" onfocus="calendar();" id="s2" /></td>
        	</tr>
        	
        	<tr>
        	<td>入学时间</td><td><input type="text" name="time" onfocus="calendar();" id="s3" /></td>
        	</tr>
        	<tr>
        	<td>家乡</td><td><input type="text" name="address" id="ad" /></td>
        	</tr>
        	<tr>
        	<td>电话</td><td><input type="text" name="tel" id="te" /></td>
        	</tr>
        	<tr>
        	<td>QQ</td><td><input type="text" name="qq" id="qq"/></td>
        	</tr>
        	<tr>
        	<td>MSN</td><td><input type="text" name="msn" id="md" /></td>
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
	var um = document.getElementById("un").value;
	//var s2 = document.getElementById("s2").value;
	var s3 = document.getElementById("s3").value;
	//var ad = document.getElementById("ad").value;
	//var te = document.getElementById("te").value;
	if(um == null || um == ""){
		alert("请输入姓户名");
		return false;
	}else if(s3 == null || s3 == ""){
		alert("请输入入学时间");
		return false;
	}else{
		document.getElementById("myf").action="zc.html?ssh=suc";
		document.getElementById("myf").submit();
	}
}

</script>
</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
