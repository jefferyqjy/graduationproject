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
				window.name="roomoperation_window";
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
			<form action="roomoperation/roomoperation_update.do" method="post" name="mainform" target="roomoperation_window">
				<table>
				<input type='hidden' name='id' value='${result.id }' />
					<tr>
						<td>roomgenid</td>
						<td>
							<input type="text" name="roomgenid" value="${result.roomgenid }" />
						</td>
						<td><span id="roomgenid_errMsg"></span></td>
					</tr>
					<tr>
						<td>roomid</td>
						<td>
							<input type="text" name="roomid" value="${result.roomid }" />
						</td>
						<td><span id="roomid_errMsg"></span></td>
					</tr>
					<tr>
						<td>custgenid</td>
						<td>
							<input type="text" name="custgenid" value="${result.custgenid }" />
						</td>
						<td><span id="custgenid_errMsg"></span></td>
					</tr>
					<tr>
						<td>custid</td>
						<td>
							<input type="text" name="custid" value="${result.custid }" />
						</td>
						<td><span id="custid_errMsg"></span></td>
					</tr>
					<tr>
						<td>identityid</td>
						<td>
							<input type="text" name="identityid" value="${result.identityid }" />
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					<tr>
						<td>remarks</td>
						<td>
							<input type="text" name="remarks" value="${result.remarks }" />
						</td>
						<td><span id="remarks_errMsg"></span></td>
					</tr>
					<tr>
						<td>begintime</td>
						<td>
							<input type="text" name="begintime" value="${result.begintime }" />
						</td>
						<td><span id="begintime_errMsg"></span></td>
					</tr>
					<tr>
						<td>endtime</td>
						<td>
							<input type="text" name="endtime" value="${result.endtime }" />
						</td>
						<td><span id="endtime_errMsg"></span></td>
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
