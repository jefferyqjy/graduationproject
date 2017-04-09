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
			<div class="pageTitle">当前位置：酒店预定</div>
			<div class="pageInput" align="center">
			<form action="foodappoint/foodappoint_add.do" method="post" name="mainform">
				<table>
					<tr>
						<td>客人姓名：</td>
						<td>
							<input type="text" name="custname" class="CHAR_M" value="${username }"/>
						</td>
						<td><span id="custname_errMsg"></span></td>
					</tr>
					<tr>
						<td>菜品：</td>
						<td>
							<select name="menuid" class="NUMB_M">
								<c:forEach items="${menus }" var="m">
									<option value="${m.id }">${m.name }</option>
								</c:forEach>
							</select>
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					<tr>
						<td>数量：</td>
						<td>
							<input type="text" name="count" class="NUMB_M"/>
						</td>
						<td><span id="count_errMsg"></span></td>
					</tr>
					<tr>
						<td>用餐时间：</td>
						<td>
							<input type="text" readonly="readonly" name="createtime" id="createtime" onfocus="calendar.show(this)" class ="DATE_M" >
						</td>
						<td><span id="createtime_errMsg"></span></td>
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
