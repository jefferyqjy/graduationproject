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
		<script type="text/javascript" src="js/date.js"></script>
		<script type="text/javascript" src="js/tourismusers.js"></script>
	</head>

	<body class="index_body">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="block clearfix">
			<div id="search">
				<div class="f_l">

				</div>
			</div>
		</div>
		<div class="blank"></div>
		<div class="block block1">
			<div class="block box">
				<div class="blank"></div>
				<div id="ur_here">
					<a href="<%=basePath%>">首页</a>
					<code>
						&gt;
					</code>
					个人信息
				</div>
			</div>
			<div class="blank"></div>

			<div class="usBox">
				<div class="usBox_2 clearfix">
					<div class="logtitle3"></div>
					<form action="index/userCenter.action" method="post" name="myform"
						onsubmit="return check();">
						<table width="100%" border="0" align="left" cellpadding="5"
							cellspacing="3">
							<tr>
								<td width="13%" align="right">
									用户名
								</td>
								<td width="87%">
									${sessionScope.userinfo.username }
									<input type="hidden" name="users.username" class="inputBg"
										size="25" id="username" value="${sessionScope.userinfo.username }" />
									<input type="hidden" name="users.password" class="inputBg"
										size="25" id="password" value="${sessionScope.userinfo.password }" />
										<input type="hidden" name="users.usersid" class="inputBg"
										size="25" id="usersid" value="${sessionScope.userinfo.usersid }" />
									<span id="username_notice" style="color: #FF0000"> *</span>
								</td>
							</tr>
							<tr>
								<td align="right" id="extend_field1i">
									姓名
								</td>
								<td>
									<input type="text" name="users.realname" class="inputBg"
										size="25" id="realname" value="${sessionScope.userinfo.realname }"/>
									<span style="color: #FF0000"> *</span>
								</td>
							</tr>
							<tr>
								<td align="right" id="extend_field2i">
									性别
								</td>
								<td>
									<input type="radio" name="users.sex" value="女" id="sex" checked />
									女 &nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="users.sex" value="男" id="sex" />
									男
									<span style="color: #FF0000"> *</span>
								</td>
							</tr>
							<tr>
								<td align="right" id="extend_field3i">
									出生日期
								</td>
								<td>
									<input type="text" name="users.birthday" class="inputBg" value="${sessionScope.userinfo.birthday }"
										readonly="readonly" onclick="setDay(this)" size="25"
										id="birthday" />
									<span style="color: #FF0000"> *</span>
								</td>
							</tr>
							<tr>
								<td align="right" id="extend_field5i">
									联系方式
								</td>
								<td>
									<input type="text" name="users.contact" class="inputBg" value="${sessionScope.userinfo.contact }"
										size="25" id="contact" />
									<span style="color: #FF0000"> *</span>
								</td>
							</tr>
							<tr>
								<td align="right" id="extend_field5i">
									联系地址
								</td>
								<td>
									<input type="text" name="users.address" class="inputBg" value="${sessionScope.userinfo.address }"
										size="25" id="address" />
									<span style="color: #FF0000"> *</span>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td align="left">
									<input type="submit" value="修改个人信息" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
