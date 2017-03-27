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
		<div class="block clearfix">
			<div id="search">
				<div class="f_l">
				</div>
			</div>
		</div>


		<div class="blank"></div>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				<a href="<%=basePath%>">首页 </a>
				<code>
					&gt;
				</code>
				旅游景点
			</div>
		</div>
		<div class="blank"></div>
		<div class="block clearfix">

			<div class="AreaL">
				<div id="category_tree">
					<h3>
						<span>线路类型 </span>
					</h3>
					<s:iterator value="map.cateList">
						<dl>
							<dt>
								<a href="index/cate.action?name=<s:property value="cateid"/>"><s:property
										value="catename" /> </a>
							</dt>
						</dl>
					</s:iterator>
				</div>
				<div class="blank"></div>
				<div class="blank5"></div>
			</div>


			<div class="AreaR">

				<div class="box">
					<div class="box_1">
						<h3>
							<span>旅游景点</span>
						</h3>
						<div class="clearfix goodsBox"
							style="border: none; padding: 11px 0 10px 5px;">
							<s:iterator value="map.attsList">
								<div class="goodsItem">
									<a
										href="index/attsDetail.action?name=<s:property value="attsid"/>"><img
											src="<s:property value="image"/>"
											alt="<s:property value="name"/>" class="goodsimg" /> </a>
									<br />
									<p>
										<a
											href="index/attsDetail.action?name=<s:property value="attsid"/>"
											title="<s:property value="name"/>"><s:property
												value="name" /> </a>
									</p>
								</div>
							</s:iterator>
						</div>
					</div>
				</div>
				<div class="blank5"></div>
			</div>

		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
