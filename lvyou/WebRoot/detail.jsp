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
				<div class="buy_car_bg_box"
					style="float: right; padding-top: 5px; padding-right: 8px;">
				</div>
			</div>
		</div>


		<div class="blank"></div>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				<a href="index/cate.cation?name=${map.lines.cateid }">${map.lines.cate.catename
					}</a>
				<code>
					&gt;
				</code>
				${map.lines.linename }
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

				<div id="goodsInfo" class="clearfix">


					<div class="imgInfo">
						<a href="${map.lines.image }" id="zoom1"
							class="MagicZoom MagicThumb" title="${map.lines.linename }">
							<img src="${map.lines.image }" alt="${map.lines.linename }"
								width="310px;" height="310px" /> </a>
						<div class="blank5"></div>
					</div>

					<div class="textInfo">
						<form action="index/addCart.action" method="post"
							name="ECS_FORMBUY" id="ECS_FORMBUY">
							<div class="clearfix"
								style="font-size: 14px; font-weight: bold; padding-bottom: 8px;">
								${map.lines.linename }
							</div>
							<ul>
								<li class="clearfix">
									<dd>

										<strong>线路类型：</strong>${map.lines.cate.catename }
									</dd>
								</li>
								<li class="clearfix">
									<dd>
										<strong>价格：</strong><font class="shop" id="ECS_SHOPPRICE">￥${map.lines.price }元/人</font>
									</dd>
								</li>
								<li class="clearfix">
									<strong>参团人数：</strong>
									<input name="cart.num" type="text" id="number" value="1" size="4" style="border: 1px solid #ccc;" />
									<input type="hidden" name="cart.linesid" value="${map.lines.linesid }" />
									<input type="hidden" name="cart.price" value="${map.lines.price }" />
								</li>


								<li class="padd">
									<input type="image"
										src="themes/ecmoban_mbaobao/images/goumai2.gif" />
								</li>

							</ul>
						</form>
					</div>
				</div>
				<div class="blank"></div>


				<div class="box">
					<div class="box_1">
						<h3 style="padding: 0 5px;">
							<div id="com_b" class="history clearfix">
								<h2>
									线路描述：
								</h2>
							</div>
						</h3>
						<div id="com_v" class="boxCenterList RelaArticle"></div>
						<div id="com_h">
							<blockquote>
								<p>
									&nbsp;${map.lines.intro }
								</p>
							</blockquote>
						</div>
					</div>
				</div>
				<div class="blank"></div>


				<div class="blank5"></div>
				<div id="ECS_COMMENT">
					<div class="box">
						<div class="box_1">
							<h3>
								<span class="text">用户评论</span>
							</h3>
							<div class="boxCenterList clearfix" style="height: 1%;">
								<ul class="comments">
									<s:iterator value="map.topicList" var="x">
										<li class="word">
											<font class="f2"><s:property value="users.realname" /> </font>
											<font class="f3">(<s:property value="addtime" />)</font>
											<br />
											<p>
												<s:property value="contents" />
											</p>
											<s:iterator value="#x.retopic">
												<p>
													<font class="f2">管理员回复</font>:${contents }
												</p>
											</s:iterator>
										</li>
									</s:iterator>
								</ul>

								<div id="pagebar" class="f_r">
								</div>

								<div class="blank5"></div>

								<div class="commentsList">
									<form action="index/addtopic.action" method="post"
										name="commentForm" id="commentForm">
										<table width="710" border="0" cellspacing="5" cellpadding="0">
											<tr>
												<td width="64" align="right">
													用户名：
												</td>
												<td width="631">
													${sessionScope.realname }
												</td>
											</tr>
											<tr>
												<td align="right" valign="top">
													评论内容：
												</td>
												<td>
													<textarea name="topic.contents" class="inputBorder" style="height: 50px; width: 620px;"></textarea>
													<input type="hidden" name="topic.linesid" value="${map.lines.linesid }" />
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<input type="submit" value="评论" class="f_r bnt_blue_1"
														style="margin-right: 8px;" />
												</td>
											</tr>
										</table>
									</form>
								</div>

							</div>
						</div>
					</div>
					<div class="blank5"></div>

				</div>
			</div>

		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
