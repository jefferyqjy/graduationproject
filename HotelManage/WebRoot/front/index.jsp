<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tld/public.tld" prefix="public" %>
<%@ page import="com.sys.common.util.DateUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
String nowTime = DateUtil.convDate2String(date,DateUtil.DEFAULT_DATE_TIME_PATTERN);
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
 <script type="text/javascript" src="<%=basePath%>/front/front_js/calendar.js" charset="utf-8"></script>
 <script type="text/javascript" src="<%=basePath%>/front/front_js/public.js" charset="utf-8"></script>
 <script type="text/javascript">
 	function showDiv(divId){
 		var test = document.getElementById(divId);
 		var dis = test.style.display;
 		if(dis == "block") {
 			test.style.display="none";
 		}else if(dis == "none"){
 			test.style.display="block";
 		}
 	}
 </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/front/style.css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="header" class="container">
		<div id="banner"  style="padding-left: 10px"><img src="<%=basePath %>/front/images/img01.jpg"  alt="" /></div>
	</div>
	<div id="menu" class="container">
		<ul>
			<li class="active"><a href="<%=basePath %>/front/welcome.jsp" target="mainFrame">首页</a></li>
			<%if(request.getSession().getAttribute("frontUsername") != null) {%>
			
			<li>
				<a href="#" onclick="showDiv('child1')">酒店预定</a>
				<br><br>
				<div id="child1" style="display: none;position: absolute;z-index: 9999;background-color: black;">
					<a href="<%=basePath %>/pro_jsp/appoint/appoint_add2.jsp" onclick="showDiv('child1')" target="mainFrame">酒店预定</a><br><br>
					<a href="<%=basePath %>/appoint/appoint_query2.do" onclick="showDiv('child1')" target="mainFrame">查询预定</a><br/><br/>
					<a href="<%=basePath %>/foodappoint/foodappoint_add2.do" onclick="showDiv('child1')" target="mainFrame">餐饮预定</a><br/><br/>
					<a href="<%=basePath %>/foodappoint/foodappoint_query2.do" onclick="showDiv('child1')" target="mainFrame">查询预定</a><br/><br/>
				</div>
			</li>
			
			
			<%} %>
			<li>
				<a href="#" onclick="showDiv('child2')">客人留言</a>
				<br><br>
				<div id="child2" style="display: none;position: absolute;z-index: 9999;background-color: black;">
					<a href="<%=basePath %>/messages/messages_query2.do" onclick="showDiv('child2')" target="mainFrame">查看留言板</a><br><br>
					<a href="<%=basePath %>/pro_jsp/messages/messages_add2.jsp" onclick="showDiv('child2')" target="mainFrame">客人留言</a><br/><br/>
				</div>
			</li>
			
			<!--<li><a href="<%=basePath %>/base/base.do?ACT_ID=frontFileQuery" target="mainFrame">公共下载</a></li>-->
			<li><a href="<%=basePath %>/login.jsp" target="_blank">后台管理</a></li>
		</ul>
	</div>
	<div id="page" class="container">
	
		<div id="content">
				<iframe id="mainFrame" name="mainFrame" frameborder="0" width="100%" height="100%" src="<%=basePath %>/front/welcome.jsp"></iframe>
		</div>
		<div id="sidebar">
			<ul>
				<li>
					<h5>当前时间</h5>
					<p>
						<%=nowTime %>
					</p>
				</li>
				<li>
				<%if(request.getSession().getAttribute("frontUsername") == null) {%>
						<h2>用户登录</h2>
						<form action="<%=basePath %>/admin/admin_login.do" method="post">
							<input type="hidden" name="loginType" value="2">
							<p>帐&nbsp;&nbsp;号: <input type="text" name="username" required/></p>
							<p>密&nbsp;&nbsp;码: <input type="password" name="password" required/></p>
							<p>
								<input type="submit" value="登录"/>
								<a target="mainFrame" href="<%=basePath %>sys_jsp/admin/admin_add2.jsp">新用户注册</a>
							</p>
						</form>
					</li>
					<%}else { %>
						<h2>个人信息</h2>
						<p>您的帐号：<%=request.getSession().getAttribute("frontUsername") %></p>
							<a href="<%=basePath %>/admin/admin_changePwd2.do" target="mainFrame">修改密码</a>
							<a href="<%=basePath %>/admin/admin_modify2.do" target="mainFrame">修改个人信息</a>
							<a href="<%=basePath %>/admin/admin_logout.do?type=2">退出</a>
						</p>
					<%} %>
				<li>
					<h2>公告</h2>
					<ul>
						<li>
							>>>>>>>>>>>>>>>>>>>>>>>>>>>
							<!-- 
							<a target="mainFrame" href="<%=basePath %>/announce/announce_query2.do">更多...</a>
							 -->
						</li>
						<!-- 
						<public:showNote></public:showNote>
						 -->
					</ul>
				</li>
			</ul>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div id="footer-bar" class="two-cols">
			<div class="col1">
				<h2>欢迎您的到来</h2>
			</div>
			<div class="col2">
				<!--<ul>
					<li><a href="#">Faucibus non sit amet elit nulla</a></li>
					<li><a href="#">Consectetur adipiscing elit integer</a></li>
					<li><a href="#">Placerat dui sed posuere molestie</a></li>
					<li><a href="#">Urna sapien porta purus vel</a></li>
				</ul>
			--></div>
			<div class="clearfix">&nbsp;</div>
		</div>
	</div>
</div>
<div id="footer" class="container">
	<p>copy right 2017</p>
</div>
</body>
</html>
