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
		
		<link href="css/validationEngine.jquery.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="js/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#formLogin").validationEngine();
			})
		</script>
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
					用户登录
				</div>
			</div>
			<div class="blank"></div>

			<div class="usBox clearfix">
				<div class="usBox_1 f_l">
					<div class="logtitle"></div>
					<form name="formLogin" id="formLogin" action="index/login.action" method="post">
						<table width="100%" border="0" align="left" cellpadding="3"
							cellspacing="5">
							<tr>
								<td width="15%" align="right">
									用户名
								</td>
								<td width="85%">
									<input name="users.username" id="username" type="text" size="25" class="inputBg validate[required]" />
								</td>
							</tr>
							<tr>
								<td align="right">
									密码
								</td>
								<td>
									<input name="users.password" id="password" type="password" size="25"
										class="inputBg validate[required]" />
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<div class="usernameformError parentFormformLogin formError" 
										style="opacity: 0.87; position: absolute; top: 316px; left: 719.5px; margin-top: -38px;">
										<div class="formErrorContent">* ${msg }<br></div>
										<div class="formErrorArrow">
											<div class="line10"><!-- --></div>
											<div class="line9"><!-- --></div>
											<div class="line8"><!-- --></div>
											<div class="line7"><!-- --></div>
											<div class="line6"><!-- --></div>
											<div class="line5"><!-- --></div>
											<div class="line4"><!-- --></div>
											<div class="line3"><!-- --></div>
											<div class="line2"><!-- --></div>
											<div class="line1"><!-- --></div>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
								</td>
								<td align="left">
									<input type="submit" value="" class="us_Submit" />
								</td>
							</tr>
						</table>
					</form>
					<div class="blank"></div>
				</div>
				<div class="usTxt">
					<div class="regtitle"></div>
					<div style="padding-left: 50px;">
						<strong>如果您不是会员，请注册</strong>
						<br />
						<strong class="f4">友情提示：</strong>
						<br />
						
						<br />
						但注册之后您可以：
						<br />
						1. 保存您的个人资料
						<br />
						2. 购买本店商品
						<br />
						<a href="index/preReg.action"><img
								src="themes/ecmoban_mbaobao/images/bnt_ur_reg.gif" /> </a>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
