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
        <td width="200" align="center" valign="middle" class="t3"><a href="ge.html" >主 页</a></td>
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
    <td bgcolor="E3F7F8"><table width="100%" height="205" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <th width="205" height="205" align="left" valign="top" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <c:if test="${intro.url == null}">
            <th scope="row"><img src="images/i-3.jpg" width="205" height="206" class="zuo" /></th>
            </c:if>
            <c:if test="${intro.url != null}">
                 <th scope="row"><img src="${intro.url}" width="205" height="206" class="zuo" /></th>
            </c:if>
          </tr>
          <tr>
            <th scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <th colspan="2" scope="row">&nbsp;</th>
              </tr>
            </table>
                    <table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <th width="40" align="right" scope="row"><img src="images/i-5.jpg" width="22" height="18" /></th>
                        <td width="60"><span class="STYLE1"><a href="head.html?ssh=head">修改头像</a></span></td>
                        <td width="20"><img src="images/i-7.jpg" width="22" height="17" /></td>
                        <td><a href="da.html?ssh=datum">编辑资料</a></td>
                      </tr>
                  </table></th>
          </tr>
          <tr>
            <th scope="row"><p>&nbsp;</p>
                </th>
          </tr>
        </table></th>
        <td width="15">      </td>
        <td width="503" height="10" align="left" valign="top">
        <table width="503" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="503" height="30" background="images/i-9.jpg" class="t4">　　<span class="t3">相　册　　　　　　　　　　　　　　　　　　　　　　　　</span>
              <span class="STYLE2"><a href="ph.html?ssh=ap">上传照片</a></span></td>
              </tr>
            </table>
      
          <div class="xianp">
          <c:forEach items="${list}" var="li" varStatus="s">
          	<div class="tp"><a href="ph.html?ssh=byid&page=${s.index+1}"><img src="${li.photo}" width="106" height="100" border="0"/></a>
          	<div class="tc"><a href="ph.html?ssh=del&id=${li.id}">删除</a></div></div>
          	
          </c:forEach>
          </div>
          <a href="ph.html?ssh=all&page=1">首页</a>
          <a href="ph.html?ssh=all&page=${pageback}">上一页</a>
          <a href="ph.html?ssh=all&page=${pagenext}">下一页</a>
          <a href="ph.html?ssh=all&page=${pagetotal}">末页</a>
            <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table>
          <br /></td><td width="15"><br />
          <br /></td>
        <td valign="top"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="200" height="30" background="images/i-11.jpg" class="t4"> 　　<span class="t3">好　友 </span></td>
          </tr>
        </table>
          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="xia">
            <tr>
              <td height="400" valign="top">
              <table width="100%" height="380" border="0" cellpadding="0" cellspacing="0">
                <c:forEach items="${flist}" var="fl">
                
                <tr>
                  <td>
                  	<table border="0">
                  	<tr><td width="45">&nbsp;</td></tr>
                  		<tr><td>&nbsp;</td><td><img src="${fl.url}" width="70" height="70"/></td></tr>
                  		<tr><td>&nbsp;</td><td align="center">${fl.name}</td></tr>
                  	</table>
                  </td>
                </tr>
                </c:forEach>
              </table>
             
               </td>
            </tr>
           
          </table>
          <br /></td>
      </tr>
    </table></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
</body>
</html>
