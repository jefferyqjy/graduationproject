<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<html>
		<head>
			<base href="<%=basePath%>">
			<title>Add</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
		</head>

		<body id="page">
  		<h2>文件生成成功,请点击下载</h2>
			<form action="file/file_download2.do" method="post">
				
				<input type="hidden" name="fileName" value="${fileName }">
				<input type="submit" value="点击下载"> 
			</form>
		</body>
	</html>
