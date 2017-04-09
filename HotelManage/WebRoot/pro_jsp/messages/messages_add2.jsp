<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<html>
		<head>
			<base href="<%=basePath%>">
			<title>Add</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<script type="text/javascript">
				function checkAndSubmit() {
					if(formValidation(true)){
						document.mainform.submit();
					}
				}
			</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：客人留言</div>
			<div class="pageInput" align="center">
			<form action="messages/messages_add.do" method="post" name="mainform">
				<table>
					<tr>
						<td>标题：</td>
						<td>
							<input type="text" name="title" class="CHAR_M"/>
						</td>
						<td><span id="title_errMsg"></span></td>
					</tr>
					<!-- 
					<tr>
						<td>usergenid</td>
						<td>
							<input type="text" name="usergenid" />
						</td>
						<td><span id="usergenid_errMsg"></span></td>
					</tr>
					 -->
					<tr>
						<td>客人姓名：</td>
						<td>
							<input type="text" name="userid" />
						</td>
						<td><span id="userid_errMsg"></span></td>
					</tr>
					<!-- 
					<tr>
						<td></td>
						<td>
							<input type="text" name="messagedate" />
						</td>
						<td><span id="messagedate_errMsg"></span></td>
					</tr>
					 -->
					<tr>
						<td>内容:</td>
						<td>
							<input type="text" name="content" class="CHAR_M"/>
						</td>
						<td><span id="content_errMsg"></span></td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="button" class="bt" value="提交" onClick="checkAndSubmit()" />
						</td>
					</tr>
				</table>
			</form>
			</div>
			</div>
			</div>
		</body>
	</html>
