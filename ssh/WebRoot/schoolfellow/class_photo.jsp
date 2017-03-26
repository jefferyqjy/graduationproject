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
	font-size: 14px;
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

.xianp{ border:1px solid #0099CC; border-top:0px; height:400px; overflow:hidden;}
.xianp .tp{ border:1px solid #bbb; width:106px; height:100px; float:left; margin-left:14px; margin-top:20px; display:inline;}
.xianp .tp .tc{width:106px; height:10px; float:center; margin-left:14px; margin-top:20px; display:inline;}
-->
</style></head>

<body>
<table width="1005" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" height="32">&nbsp;</td>
    <td width="916" height="58" background="images/i-2.jpg"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="30">&nbsp;</td>
        <td width="150" align="center" valign="middle" class="t3"><a href="cla.html?ssh=find" target="right">主 页</a></td>
        <td width="150" align="center" valign="middle" class="t3"><a href="cla.html?ssh=photoall" target="right">相 册</a></td>
        <td width="150" align="center" valign="middle" class="t3"><a href="cla.html?ssh=leavall" target="right">留言板</a></td>
        <td width="150" align="center" valign="middle" class="t3"><a href="cla.html?ssh=txl">通讯录</td>
        <td width="150" align="center" valign="middle" class="t3"><a href="cla.html?ssh=cy">成　员</a></td>
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
    <td bgcolor="E3F7F8"><table width="100%" height="205" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <th width="205" height="205" align="left" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <th scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <th colspan="2" scope="row">&nbsp;</th>
              </tr>
            </table>
          </tr>
        </table></th>
        <td width="15">      </td>
        <td width="870" height="10" align="center" valign="top">
        <table width=870 border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="870" height="30" background="images/i-9.jpg" class="t4">　　<span class="t3">相　册　　　　　　　　　　　　　　　　　　　　　　　　</span>
              <span class="STYLE2"><a href="cla.html?ssh=up">上传照片</a></span></td>
              </tr>
            </table>
      
          <div class="xianp">
          <c:forEach items="${list}" var="li" varStatus="s">
          	<div class="tp"><a href="cla.html?ssh=byid&page=${s.index+1 }"><img border="0" src="${li.photo}" width="106" height="100"/></a>
          	<div class="tc"><a href="cla.html?ssh=delphoto&pid=${li.id}">删除</a></div></div>
          	
          </c:forEach>
          </div>
          <a href="cla.html?ssh=photoall&page=1">首页</a>
          <a href="cla.html?ssh=photoall&page=${pageback}">上一页</a>
          <a href="cla.html?ssh=photoall&page=${pagenext}">下一页</a>
          <a href="cla.html?ssh=photoall&page=${pagetotal}">末页</a>
            <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table>
          <br /></td><td width="15"><br />
          <br /></td>
      </tr>
    </table></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
</body>
</html>
