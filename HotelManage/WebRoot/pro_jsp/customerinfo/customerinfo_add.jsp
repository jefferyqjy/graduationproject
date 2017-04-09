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
			<div class="pageTitle">当前位置：添加客户信息</div>
			<div class="pageInput" align="center">
			<form action="customerinfo/customerinfo_add.do" method="post" name="mainform">
				<table>
					<tr>
						<td>身份证号:</td>
						<td>
							<input type="text" name="identityid" class="CHAR_M_18"/>
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					<tr>
						<td>客户姓名：</td>
						<td>
							<input type="text" name="custname" class="CHAR_M"/>
						</td>
						<td><span id="custname_errMsg"></span></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>
							<select name="sex" id="sex" >
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</td>
						<td><span id="sex_errMsg"></span></td>
					</tr>
					<tr>
						<td>联系方式：</td>
						<td>
							<input type="text" name="phone" class="CHAR_M"/>
						</td>
						<td><span id="phone_errMsg"></span></td>
					</tr>
					 <!-- 
					<tr>
						<td>roomgenid</td>
						<td>
							<input type="text" name="roomgenid" />
						</td>
						<td><span id="roomgenid_errMsg"></span></td>
					</tr>
					<tr>
						<td>roomid</td>
						<td>
							<input type="text" name="roomid" />
						</td>
						<td><span id="roomid_errMsg"></span></td>
					</tr>
					 -->
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
