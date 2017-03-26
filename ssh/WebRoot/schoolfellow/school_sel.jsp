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
<input type="hidden" name="ids" value="${sf.id }"/>
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
      <td width="80">&nbsp;</td>
        <td width="703" height="10" align="left" valign="top">
          <table width="100%" border="0" align="center" cellspacing="0" cellpadding="0">
          	  <tr><td>
          	  <table border="0" width="100%">
          	  <tr><td align="center" height="26">${sf.title }</td></tr>
          	  <tr><td>作者:${sf.name }</td></tr>
          	  <tr><td align="left" height="26">时间:${sf.date}</td></tr>
          	  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;${sf.count}</td></tr>
          	  
          	  </table>
          	  </td></tr>
              <tr>
                <td height="30" background="images/i-9.jpg" class="t4">　　<span class="t3">留　言 　　　　　　　　　　　　　　　　　　　　　　　　</span>
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center" valign="top" class="xia"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="10">&nbsp;</td>
                  </tr>
                  </table>
                  <textarea name="textarea2" id="tex2" cols="58" rows="4"></textarea>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="100%" height="21" valign="top"> 　　　　　　　　　　　　　　　　　　　                      
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left"><input type="image" src="images/i-10.jpg" name="button" onclick="tj();"/></td>
                          </tr>
                          <tr>
                          <td height="30" background="images/i-9.jpg" class="t4" align="left"><span class="t3">评　论</span></td>
                          <td height="30" background="images/i-9.jpg" class="t4"><a href="sch.html?ssh=findleave&id=${sf.id}">更多</td>
                          </tr>
                          <c:forEach items="${list}" var="li">
                          <tr><td height="26" align="left">${li.count }</td></tr>
                          </c:forEach>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table>
          <br />
          <table width="100%" height="300" border="0" cellpadding="0" cellspacing="0">
          
            
          </table></td><td width="15"><br />
          <br /></td>
      </tr>
    </table></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
</form>
<script type="text/javascript">
function tj(){
	var tx = document.getElementById("tex2").value;
	if(tx == null || tx == ""){
		alert("留言内容不能为空");
		return false;
	}else{
		document.getElementById("myf").action="sch.html?ssh=addleave";
	}
}
</script>
</body>
</html>
