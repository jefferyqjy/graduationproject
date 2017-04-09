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
			<div class="pageTitle">当前位置：添加客房信息</div>
			<div class="pageInput" align="center">
			<form action="roominfo/roominfo_add.do" method="post" name="mainform">
				<table>
					<tr>
						<td>客房编号：</td>
						<td>
							<input type="text" name="roomid" class="CHAR_M"/>
						</td>
						<td><span id="roomid_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房类型：</td>
						<td>
							
							<select name="roomtype" id="roomtype" >
								<option value="普通单间">普通单间</option>
								<option value="普通双人间">普通双人间</option>
								<option value="标准单间">标准单间</option>
								<option value="标准双人间">标准双人间</option>
								<option value="豪华单间">豪华单间</option>
								<option value="豪华双人间">豪华双人间</option>
								<option value="总统套房">总统套房</option>
							</select>
						</td>
						<td><span id="roomtype_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房位置:</td>
						<td>
							<input type="text" name="roomposition" />
						</td>
						<td><span id="roomposition_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房描述：</td>
						<td>
							<input type="text" name="roomdesc" />
						</td>
						<td><span id="roomdesc_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房状态：</td>
						<td>
							
							<select name="status" id="status" >
								<option value="入住">入住</option>
								<option value="空闲">空闲</option>
							</select>
						</td>
						<td><span id="status_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房价格：</td>
						<td>
							<input type="text" name="price" class="NUMB_M"/>
						</td>
						<td><span id="price_errMsg"></span></td>
					</tr>
					<tr>
						<td>配置电视：</td>
						<td>
						
							<select name="tv" id="tv" >
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</td>
						<td><span id="tv_errMsg"></span></td>
					</tr>
					<tr>
						<td>配置空调：</td>
						<td>
							<select name="airconition" id="airconition" >
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</td>
						<td><span id="airconition_errMsg"></span></td>
					</tr>
					<tr>
						<td>床位配置：</td>
						<td>
							<input type="text" name="bednum" class="NUMB_M"/>
						</td>
						<td><span id="bednum_errMsg"></span></td>
					</tr>
					<tr>
						<td>备注信息：</td>
						<td>
							<input type="text" name="remark" />
						</td>
						<td><span id="remark_errMsg"></span></td>
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
