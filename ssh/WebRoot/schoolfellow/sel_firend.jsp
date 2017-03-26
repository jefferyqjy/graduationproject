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
<form name="myform" id="myf" action="" method="post">
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
            </th>
          </tr>
          <tr>
            <th scope="row"><p>&nbsp;</p>
                  </th>
          </tr>
        </table>
        
        <table height="200" width="210" border="0">
        <tr>
        	<td width="40">姓  名:</td>
        	<td>${intro.name}</td>
        </tr>
        <tr>
        	<td>性别:</td>
        	<td>${intro.sex}</td>
        </tr>
        <tr>
        	<td>籍贯:</td>
        	<td>${intro.address}</td>
        </tr>
        <tr>
        	<td>生日:</td>
        	<td>${intro.year }</td>
        </tr>
        </table>
        
        </th>
        <td width="15">
      </td>
        <td width="503" height="10" align="left" valign="top"><table width="503" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td background="images/i-9.jpg">
            <table width="503" height="30" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td class="t4"><span class="t3">个性签名</span></td>
                </tr>
            </table></td>
          </tr>
        </table>
          <table width="503" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="left" valign="top" class="xia"><br />
                   　${intro.per}
                  
                <br /></td>
            </tr>
          </table>
          <br />
          <table width="503" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="503" height="30" background="images/i-9.jpg" class="t4">　　<span class="t3">最新上传照片　　　　　　　　　　　　　　　　　　　　</span>
              <span class="STYLE2"></span></td>
            </tr>
          </table>
    
          <table width="503" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="100" valign="top" class="xia"><table width="100%" height="130" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="10">&nbsp;</td>
                  <td height="10">&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                <td width="10">&nbsp;</td>
                  <c:forEach items="${plist}" var="pl" varStatus="s">
                  <td width="10">&nbsp;</td>
                  <td width="110" align="center" valign="middle" class="zuo">
                  <table width="106" height="100" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><a href="fir.html?ssh=byid&id=${pl.id}&page=${s.index+1}"><img src="${pl.photo}" border="0" width="106" height="100" border="0"/></a></td>
                    </tr>
                  </table>
                  </td>
                  </c:forEach>
                  
                  <td width="10">&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td height="10">&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
              </table></td>
            </tr>
          </table>
          <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td>&nbsp;</td>
            </tr>
          </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="images/i-9.jpg" class="t4">　　<span class="t3">留　言 　　　　　　　　　　　　　　　　　　　　　　　　</span>
              <span class="STYLE3"><a href="fir.html?ssh=leaall">更多       </a></span></td>
            </tr>
          </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="center" valign="top" class="xia"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="10">&nbsp;</td>
                </tr>
              </table>
                <textarea name="textarea2" id="tex2" cols="60" rows="4"></textarea>
                
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="100%" height="21" valign="top"> 　　　　　　　　　　　　　　　　　　　                      
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="left"><input type="image" src="images/i-10.jpg" onclick="ly()"/></td>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                        </tr>
                        
                        <c:forEach items="${leavelist}" var="ll">
                        <tr>
                          <td width="52">&nbsp;<img src="${ll.url}" width="50" height="50"/></td>
                          <td align="left">
                          	<table>
                          		<tr><td><span class="t3">${ll.name}          ${ll.date}</span></td></tr>
                          		<tr><td>${ll.count}</td></tr>
                          	</table>
                          </td>
                        </tr>
                        </c:forEach>
                      </table></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <br /></td>
        <td width="15"><br />
          <br /></td>
        <td valign="top"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="200" height="30" background="images/i-11.jpg" class="t4"> 　　<span class="t3">好　友 </span></td>
          </tr>
        </table>
          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="xia">
            <tr>
              <td height="456" valign="top">
              <div class="pict">
              <table width="100%" height="380" border="0" cellpadding="0" cellspacing="0">
                <c:forEach items="${flist}" var="fl">
                
                <tr>
                  <td>
                  	<table border="0">
                  	<tr><td width="45">&nbsp;</td></tr>
                  		<tr><td>&nbsp;</td><td><a href="fir.html?ssh=find&fid=${fl.FId}"><img src="${fl.url}" border="0" width="70" height="70"/></a></td></tr>
                  		<tr><td>&nbsp;</td><td align="center">${fl.name}</td></tr>
                  	</table>
                  </td>
                </tr>
                </c:forEach>
              </table>
             </div>
            </td>
            </tr>
          </table>
          <br /></td>
      </tr>
    </table></td>
    <td width="41">&nbsp;</td>
  </tr>
</table>
</form>
<script type="text/javascript">
function qm(){
	var tex1 = document.getElementById("tex1").value;
	if(tex1 == null || tex1 == ""){
		alert("个性签名内容不能为空");
		return false;
	}else{
		document.getElementById("myf").action="gx.html";
		//document.getElementById("myf").submit();
	}
}
function ly(){
	var tex2 = document.getElementById("tex2").value;
	if(tex2 == null || tex2 == ""){
		alert("留言内容不能为空");
		return false;
	}else{
		document.getElementById("myf").action="fir.html?ssh=liuyan";
		//document.getElementById("myf").submit();
	}
}
</script>
</body>
</html>
