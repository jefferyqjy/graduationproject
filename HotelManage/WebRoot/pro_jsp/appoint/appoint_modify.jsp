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
				window.name="appoint_window";
				function checkAndSubmit() {
					document.mainform.submit();
				}
			</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：审核预定</div>
			<div class="pageInput" align="center">
			<form action="appoint/appoint_update.do" method="post" name="mainform" target="appoint_window">
				<input type='hidden' name='id' value='${result.id }' />
				<input type='hidden' name='custname' value='${result.custname }' />
				
				<input type='hidden' name='identityid' value='${result.identityid }' />
				
				<input type='hidden' name='begintime' value='${result.begintime }' />
				
				<input type='hidden' name='endtime' value='${result.endtime }' />
				<input type='hidden' name='phone' value='${result.phone }' />
				<table>
				
					<tr>
						<td>客人姓名：</td>
						<td>
							${result.custname }
							
						</td>
						<td><span id="custname_errMsg"></span></td>
					</tr>
					<tr>
						<td>身份证号：</td>
						<td>
							${result.identityid }
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					
					<tr>
						<td>入住时间：</td>
						<td>
							${result.begintime }
						</td>
						<td><span id="begintime_errMsg"></span></td>
					</tr>
					<tr>
						<td>退房时间：</td>
						<td>
							${result.endtime }
						</td>
						<td><span id="endtime_errMsg"></span></td>
					</tr>
					
					<tr>
						<td>状态：</td>
						<td>
							<select name="status" id="status"  value="${result.status }">
								<option value="提交预定">提交预定</option>
								<option value="接受预定">接受预定</option>
								<option value="拒绝预定">拒绝预定</option>
							</select>
						</td>
						<td><span id="status_errMsg"></span></td>
					</tr>
					
					<tr>
						<td>联系方式：</td>
						<td>
							${result.phone }
						</td>
						<td><span id="phone_errMsg"></span></td>
					</tr>
					<tr>
						<td>备注：</td>
						<td>
							<input type="text" name="remarks" value="${result.remarks }" />
						</td>
						<td><span id="remarks_errMsg"></span></td>
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
