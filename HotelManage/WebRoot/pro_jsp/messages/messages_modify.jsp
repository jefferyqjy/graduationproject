<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<html>
		<head>
			<base href="<%=basePath%>">
			<title>Modify</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<script type="text/javascript">
				window.name="messages_window";
				function checkAndSubmit() {
					document.mainform.submit();
				}
			</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：修改</div>
			<div class="pageInput">
			<form action="messages/messages_update.do" method="post" name="mainform" target="messages_window">
				<table>
				<input type='hidden' name='id' value='${result.id }' />
					<tr>
						<td>title</td>
						<td>
							<input type="text" name="title" value="${result.title }" />
						</td>
						<td><span id="title_errMsg"></span></td>
					</tr>
					<tr>
						<td>usergenid</td>
						<td>
							<input type="text" name="usergenid" value="${result.usergenid }" />
						</td>
						<td><span id="usergenid_errMsg"></span></td>
					</tr>
					<tr>
						<td>userid</td>
						<td>
							<input type="text" name="userid" value="${result.userid }" />
						</td>
						<td><span id="userid_errMsg"></span></td>
					</tr>
					<tr>
						<td>messagedate</td>
						<td>
							<input type="text" name="messagedate" value="${result.messagedate }" />
						</td>
						<td><span id="messagedate_errMsg"></span></td>
					</tr>
					<tr>
						<td>content</td>
						<td>
							<input type="text" name="content" value="${result.content }" />
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
