<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body id="page">
  <div id="contentWrap">
  	<div id="widget table-widget">
  	<div class="pageTitle">当前位置：修改信息</div>
  	<div class="pageInput">
  <form action="admin/admin_update2.do" method="post">
    <table id="normalT">
    	<tr>
    		<td>用&nbsp;户&nbsp;名：</td>
    		<td>
    		<input type="hidden" name="username" value="${result.username }"/>
    		${result.username }
    		</td>
    	</tr>
    	<tr>
    		<td>联系QQ：</td>
    		<td>
    			<input type="text" name="qq" value="${result.qq }"/>
    		</td>
    	</tr>
    	<tr>
    		<td>联系Email：</td>
    		<td>
    			<input type="text" name="email" value="${result.email }"/>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2">
    			<input type="submit" class="bt" value="提交修改" />
    		</td>
    	</tr>
    </table>
    </form>
    </div></div></div>
  </body>
</html>
