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
			<div class="pageTitle">当前位置：添加菜单信息</div>
			<div class="pageInput" align="center">
			<form action="menu/menu_add.do" method="post" name="mainform">
				<table>
					<tr>
						<td>菜品名称:</td>
						<td>
							<input type="text" name="name" />
						</td>
						<td><span id="name_errMsg"></span></td>
					</tr>
					<tr>
						<td>菜品价格:</td>
						<td>
							<input type="text" name="price" />
						</td>
						<td><span id="price_errMsg"></span></td>
					</tr>
					<tr>
						<td>菜品类型：</td>
						<td>
							<select name="type" id="type" >
								<option value="本店特色">本店特色</option>
								<option value="荤菜">荤菜</option>
								<option value="鲜蔬">鲜蔬</option>
								<option value="点心">点心</option>
								<option value="主食">主食</option>
								<option value="汤羹">汤羹</option>
								<option value="酒水">酒水</option>
								<option value="饮料">饮料</option>
							</select>
						</td>
						<td><span id="type_errMsg"></span></td>
					</tr>
					<tr>
						<td>计量单位:</td>
						<td>
							<input type="text" name="unit" />
						</td>
						<td><span id="unit_errMsg"></span></td>
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
