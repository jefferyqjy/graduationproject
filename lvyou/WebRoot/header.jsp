<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div id="topNav">
	<div class="block">
		<div class="f_l" style="_padding-top: 3px;">
			<span> <img src="themes/ecmoban_mbaobao/images/biao13.gif">
				咨询热线：<b> 123123123</b> </span>
		</div>
		<div class="f_r log">

			<ul>
				<s:if test="#session.userid == null">
					<li style="float: left" class="clearfix">
						<font id="ECS_MEMBERZONE">欢迎访问本站
						 <a href="index/preLogin.action">[用户登录]</a>|
							<a href="index/preReg.action">[用户注册]</a> </font>
					</li>
				</s:if>
				<s:if test="#session.userid != null">
					<li style="float: left" class="clearfix">
						<font id="ECS_MEMBERZONE"> 欢迎访问本站, 
						<a href="userinfo.jsp"><font color="red"><b>${sessionScope.realname }</b></font></a>！ 
						<a href="index/prePwd.action">修改密码</a>，
						<a href="index/showCart.action">查看购物车</a>，
						<a href="index/showOrders.action">购买记录</a>，
						<a href="index/exit.action">退出登录</a> </font>
					</li>
				</s:if>
			</ul>
		</div>

	</div>
</div>
<div style="clear: both"></div>
<div class="block clearfix" style="height: 73px;">
	<div class="f_l" style="padding-top: 15px">
		<a href="index.php" name="top"><img style="float: left"
				src="themes/ecmoban_mbaobao/images/logo.gif" /> </a>
	</div>

	<form id="searchForm" name="searchForm" method="post"
		action="index/query.action" onSubmit="return checkSearchForm()">
		<div class="clearfix" onclick="this.className = 'clearfix ul2_on';">

			<div style="float: left; position: relative">
				<input name="name" type="text" id="name" value="旅游线路"
					onclick="javascript: this.value = '';" class="B_input" />
				<img style="position: absolute; left: 4px; top: 4px;"
					src="themes/ecmoban_mbaobao/images/biao14.gif">
			</div>
			<input type="submit" value="搜索" class="go"
				style="cursor: pointer;" />
		</div>
		<div class="keys">
		</div>
	</form>
</div>

<div class="block" style="position: relative; z-index: 99999999;">
	<div id="mainNav" class="clearfix">
		<a class="a2" href="<%=basePath %>" id="a1_on">首页</a>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/article.action">新闻公告</a>
		</ul>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/atts.action">旅游景点</a>
		</ul>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/special.action">特价旅游线路</a>
		</ul>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/recommend.action">推荐旅游线路</a>
		</ul>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/lines.action">全部旅游线路</a>
		</ul>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/aboutus.action">公司简介</a>
		</ul>
		<ul class="u1" onmouseover="this.className = 'u1 u1_over';"onmouseout="this.className = 'u1';">
			<a class="a1" href="index/contactus.action">联系我们</a>
		</ul>
	</div>
</div>
<div class="block clearfix">
	<div id="search">
		
	</div>
</div>