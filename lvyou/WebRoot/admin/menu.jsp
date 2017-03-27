<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<base href="<%=basePath%>" />
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ecf4ff;
}

.dtree {
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #0000ff;
	white-space: nowrap;
}

.dtree img {
	border: 0px;
	vertical-align: middle;
}

.dtree a {
	color: #333;
	text-decoration: none;
}

.dtree a.node,.dtree a.nodeSel {
	white-space: nowrap;
	padding: 1px 2px 1px 2px;
}

.dtree a.node:hover,.dtree a.nodeSel:hover {
	color: #0000ff;
}

.dtree a.nodeSel {
	background-color: #AED0F4;
}

.dtree .clip {
	overflow: hidden;
}
-->
</style>
		<link href="css/four.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/dtree.js"></script>
	</head>
	<body>
		<table width="96%" border="0" cellpadding="10" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
					<div class="menu">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<script type="text/javascript">
	d = new dTree('d');
	d.config.target = "main";
	d.add(0, -1, '管理菜单');
	d.add(1, 0, '系统用户', '');
	d.add(11, 1, '新增系统用户', 'users/createUsers.action');
	d.add(12, 1, '系统用户列表', 'users/getAllUsers.action');
	d.add(13, 1, '修改密码', 'admin/editpwd.jsp');
	d.add(2, 0, '活动公告', '');
	d.add(21, 2, '新增活动公告', 'article/createArticle.action');
	d.add(22, 2, '活动公告列表', 'article/getAllArticle.action');
	d.add(3, 0, '联系我们', '');
	d.add(32, 3, '联系我们列表', 'contactus/getAllContactus.action');
	d.add(4, 0, '公司简介', '');
	d.add(42, 4, '公司简介列表', 'aboutus/getAllAboutus.action');
	d.add(5, 0, '景点', '');
	d.add(51, 5, '新增景点', 'atts/createAtts.action');
	d.add(52, 5, '景点列表', 'atts/getAllAtts.action');
	d.add(6, 0, '线路类型', '');
	d.add(61, 6, '新增线路类型', 'cate/createCate.action');
	d.add(62, 6, '线路类型列表', 'cate/getAllCate.action');
	d.add(7, 0, '旅游线路', '');
	d.add(71, 7, '新增旅游线路', 'lines/createLines.action');
	d.add(72, 7, '旅游线路列表', 'lines/getAllLines.action');
	d.add(9, 0, '订单', '');
	d.add(92, 9, '订单列表', 'orders/getAllOrders.action');
	d.add(012, 0, '用户留言', '');
	d.add(0122, 012, '用户留言列表', 'topic/getAllTopic.action');
	document.write(d);
	//-->
</script>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>