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
				window.name="foodappoint_window";
				function checkAndSubmit() {
					document.mainform.submit();
				}
			</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：修改餐饮预订信息</div>
			<div class="pageInput" align="center">
			<form action="foodappoint/foodappoint_update.do" method="post" name="mainform" target="foodappoint_window">
				<input type='hidden' name='id' value='${result.id }' />
				<input type='hidden' name='custname' value='${result.custname }' />
				<input type='hidden' name='menuid' value='${result.menuid }' />
				<input type='hidden' name='createtime' value='${result.createtime }' />
				<input type='hidden' name='count' value='${result.count }' />
				<input type='hidden' name='status' value='${result.status }' />
				<table>
					<tr>
						<td>客人姓名：</td>
						<td>
							${result.custname }
						</td>
						<td><span id="custname_errMsg"></span></td>
					</tr>
					<tr>
						<td>菜品：</td>
						<td>
							${result.menuid }
						</td>
						<td><span id="menuid_errMsg"></span></td>
					</tr>
					<tr>
						<td>数量：</td>
						<td>
							${result.count }
						</td>
						<td><span id="count_errMsg"></span></td>
					</tr>
					<tr>
						<td>状态：</td>
						<td>
							<select name="status" id="status"  value="${result.status }">
								<option value="接受预定">接受预定</option>
								<option value="拒绝预定">拒绝预定</option>
							</select>
						</td>
						<td><span id="status_errMsg"></span></td>
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
