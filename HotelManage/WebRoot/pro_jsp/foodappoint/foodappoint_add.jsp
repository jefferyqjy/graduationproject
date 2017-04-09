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
			<form action="appoint/appoint_add.do" method="post" name="mainform">
				<table>
					<tr>
						<td>客人姓名：</td>
						<td>
							<input type="text" name="custname" class="CHAR_M"/>
						</td>
						<td><span id="custname_errMsg"></span></td>
					</tr>
					<tr>
						<td>身份证号：</td>
						<td>
							<input type="text" name="identityid" class="NUMB_M"/>
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					
					<tr>
						<td>入住时间：</td>
						<td>
							
							<input type="text" readonly="readonly" name="begintime" id="begintime" onfocus="calendar.show(this)" class ="DATE_M" >
						</td>
						<td><span id="begintime_errMsg"></span></td>
					</tr>
					<tr>
						<td>退房时间：</td>
						<td>
							<input type="text" readonly="readonly" name="endtime" id="endtime" onfocus="calendar.show(this)" class ="DATE_M" >
						</td>
						<td><span id="endtime_errMsg"></span></td>
					</tr>
					<!-- 
					<tr>
						<td>状态：</td>
						<td>
							<select name="status" id="status" >
								<option value="提交预定">提交预定</option>
								<option value="接受预定">接受预定</option>
								<option value="拒绝预定">拒绝预定</option>
							</select>
						</td>
						<td><span id="status_errMsg"></span></td>
					</tr>
					
					<tr>
						<td>personnum</td>
						<td>
							<input type="text" name="personnum" />
						</td>
						<td><span id="personnum_errMsg"></span></td>
					</tr>
					 -->
					<tr>
						<td>备注：</td>
						<td>
							<input type="text" name="remarks" />
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
