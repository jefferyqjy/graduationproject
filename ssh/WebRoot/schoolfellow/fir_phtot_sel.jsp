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
        <td width="200" align="center" valign="middle" class="t3"><a href="fir.html?ssh=find&fid=${intro.id }">主 页</a></td>
        <td width="200" align="center" valign="middle" class="t3"><a href="fir.html?ssh=photoall">相 册</td>
        <td width="200" align="center" valign="middle" class="t3"><a href="fir.html?ssh=leaall">留言板</a></td>
        <td width="200" align="center" valign="middle" class="t3"><a href="fir.html?ssh=firall">好 友</a></td>
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
        <table width="800" border="0" align="center" cellspacing="0" cellpadding="0">
        	<tr>
        		<td width="100"></td>
        		<td align="center"><img src="${photo.photo}" /></td>
        	</tr>
        	<tr>
        	<td></td>
        	<td align="center" height="26">
        	<a href="fir.html?ssh=byid&page=1">首页</a>
        	<a href="fir.html?ssh=byid&page=${pageback }">上一页</a>
        	<a href="fir.html?ssh=byid&page=${pagenext }">下一页</a>
        	<a href="fir.html?ssh=byid&page=${pagetotal }">末页</a>
        	</td></tr>
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
	var f = document.getElementById("fi").value;
	
	var i = f.lastIndexOf('.');//从右边开始找第一个'.'
	var len = f.length;//取得总长度
	var str = f.substring(len,i+1);//取得后缀名
	var exName = "JPEG,GIF,JPG,PNG,BMP"; //允许的后缀名
	var k = exName.indexOf(str.toUpperCase());//转成大写后判断
	if(k==-1){//没有符合的
		alert("图片不正确格式!请选择 JPEG,GIF,JPG,PNG,BMP 格式");
		return false;
	}
	document.getElementById("myf").action="head.html?ssh=up";
	document.getElementById("myf").submit();
}

</script>
</body>
</html>
