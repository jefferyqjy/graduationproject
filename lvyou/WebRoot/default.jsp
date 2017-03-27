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

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<table cellspacing="0" cellpadding="0" width="980" align="center"
			border="0">
			<tbody>
				<tr>
					<td height="28" width="100%">
						<marquee scrollamount="4" scrolldelay="90" direction="rtl">欢迎访问本站
						</marquee>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="blank"></div>
		<div class="block clearfix">
			<div class="box clearfix">
				<div style="float: left; width: 700px;">
					<div class="index_ad">

						<script type="text/javascript">
	var swf_width = 950;
	var swf_height = 440;
</script>

						<script type="text/javascript"
							src="data/flashdata/default/cycle_image.js"></script>

					</div>
					<div class="blank">
					</div>
				</div>
			</div>
			<div class="blank"></div>
			<div class="box  ">
				<div class="tit1">
					<span>旅游景点</span>
					<a class="more" href="index/atts.action">更多 </a>
				</div>
				<div class="blank"></div>
				<div id="show_best_area" class="clearfix">
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
			<div class="blank"></div>
			<div class="box  ">
				<div class="tit1">
					<span>特价旅游线路</span>
					<a class="more" href="index/special.action">更多</a>
				</div>
				<div class="blank"></div>
				<div id="show_hot_area" class="clearfix">
					<s:iterator value="map.specialList">
						<div class="goodsItem">
							<a
								href="index/detail.action?name=<s:property value="linesid"/>"><img
									src="<s:property value="image"/>"
									alt="<s:property value="linename"/>" class="goodsimg" />
							</a>
							<br />
							<p>
								<a
									href="index/detail.action?name=<s:property value="linesid"/>"
									title="<s:property value="linename"/>"><s:property
										value="linename" /> </a>
							</p>
						</div>
					</s:iterator>
				</div>
			</div>
			<div class="blank"></div>
			<div class="blank"></div>
			<div class="box  ">
				<div class="tit1">
					<span>推荐旅游线路</span>
					<a class="more" href="index/recommend.action">更多</a>
				</div>
				<div class="blank"></div>
				<div id="show_hot_area" class="clearfix">
					<s:iterator value="map.recommendList">
						<div class="goodsItem">
							<a
								href="index/detail.action?name=<s:property value="linesid"/>"><img
									src="<s:property value="image"/>"
									alt="<s:property value="linename"/>" class="goodsimg" /> </a>
							<br />
							<p>
								<a
									href="index/detail.action?name=<s:property value="linesid"/>"
									title="<s:property value="linename"/>"><s:property
										value="linename" /> </a>
							</p>
						</div>
					</s:iterator>
				</div>
			</div>
			<div class="blank"></div>
			<div class="blank"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
