<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
  <h2>当前位置：上传文件</h2>
  
   		<form action="file/file_upload.do" enctype="multipart/form-data" method="post">
   	 <table id="normalT">
   	 <tr>
   	 <td>
   		<input name="attach" type="file" required/>
   		<input type="submit" value="上传">
   		</td>
   		</tr>
   	</table>
   	<hr>
   	<font color="red" size="2px">注意：<br>
   	Excel中的日期格式必须遵循yyyy/MM/dd 格式<br>
   	Excel文件版本必须是2003,后缀为xls,而不是xlsx.如果已有2007版本，请按照如下方式改为2003版本：<br>
   	<img alt="" src="<%=basePath%>/img/step1.jpg">
   	<img alt="" src="<%=basePath%>/img/step2.jpg">
   	<br>
   	文件内容遵循如下图所示格式：</font><br>
   	<img alt="" src="<%=basePath%>/img/import.jpg">
   	</form>
  </body>
</html>
