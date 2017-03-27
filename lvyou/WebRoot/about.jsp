<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>美丽的西双版纳旅行平台</title>
		<link href="themes/ecmoban_mbaobao/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="js/index.js"></script>
	</head>

	<body class="index_body">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="blank"></div>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				公司简介
			</div>
		</div>
		<div class="blank"></div>
		<div class="block">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>公司简介</span>
					</h3>
					<div class="boxCenterList">
						<p>
							&nbsp;${map.about.contents }
						</p>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
