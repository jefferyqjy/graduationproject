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
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				购物车
			</div>
		</div>
		<div class="blank"></div>

		<div class="blank"></div>
		<div class="block">

			<div class="flowBox">
				<h6>
					<span>购物车</span>
				</h6>
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="1" bgcolor="#dddddd">
					<tr>
						<th bgcolor="#ffffff">
							线路
						</th>
						<th bgcolor="#ffffff">
							单价
						</th>
						<th bgcolor="#ffffff">
							人数
						</th>
						<th bgcolor="#ffffff">
							报名日期
						</th>
						<th bgcolor="#ffffff">
							移除
						</th>
					</tr>
					<s:iterator value="map.cartList">
						<tr>
							<td bgcolor="#ffffff" align="center">
								<s:property value="lines.linename" />
							</td>
							<td align="right" bgcolor="#ffffff">
								￥
								<s:property value="price" />
								元
							</td>
							<td align="center" bgcolor="#ffffff">
								<s:property value="num" />
							</td>
							<td align="center" bgcolor="#ffffff">
								<s:property value="addtime" />
							</td>
							<td align="center" bgcolor="#ffffff">
								<a href="index/deleteCart.action?name=${cartid }" >移除</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="0" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff">
							<a href="<%=basePath%>"><img
									src="themes/ecmoban_mbaobao/images/continue.gif"
									alt="continue" /> </a>
						</td>
						<td bgcolor="#ffffff" align="right">
							<a href="index/checkOut.action"><img
									src="themes/ecmoban_mbaobao/images/checkout.gif"
									alt="checkout" /> </a>
						</td>
					</tr>
				</table>
			</div>

			<div class="blank"></div>

			<div class="blank5"></div>
		</div>
		<div class="blank"></div>


		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
