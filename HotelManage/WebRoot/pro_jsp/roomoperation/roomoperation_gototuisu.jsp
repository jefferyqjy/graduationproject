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
			<div class="pageTitle">当前位置：客人退宿</div>
			<div class="pageInput" align="center">
			<form action="roomoperation/roomoperation_tuisu.do" method="post" name="mainform" target="roomoperation_window">
				<input type='hidden' name='id' value='${result.id }' />
				
				<input type='hidden' name='roomgenid' value='${result.roomgenid }' />
				<input type='hidden' name='roomid' value='${result.roomid }' />
				<input type='hidden' name='custgenid' value='${result.custgenid }' />
				<input type='hidden' name='totalprice' value='${result.totalprice }' />
				
				<table>
				
					<!-- 
					<tr>
						<td>roomgenid</td>
						<td>
							<input type="text" name="roomgenid" value="${result.roomgenid }" />
						</td>
						<td><span id="roomgenid_errMsg"></span></td>
					</tr>
					 -->
					<tr>
						<td>房间编号：</td>
						<td>
							${result.roomid }
						</td>
						<td><span id="roomid_errMsg"></span></td>
					</tr>
					<tr>
						<td>客户姓名：</td>
						<td>
							${result.custid }
						</td>
						<td><span id="custid_errMsg"></span></td>
					</tr>
					<tr>
						<td>身份证号：</td>
						<td>
							${result.identityid }
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					<tr>
						<td>备注信息：</td>
						<td>
							${result.remarks }
						</td>
						<td><span id="remarks_errMsg"></span></td>
					</tr>
					<tr>
						<td>入住时间：</td>
						<td>
							${result.begintime2 }
						</td>
						<td><span id="begintime_errMsg"></span></td>
					</tr>
					<tr>
						<td>退房时间：</td>
						<td>
							${result.endtime2 }
						</td>
						<td><span id="endtime_errMsg"></span></td>
					</tr>
					<tr>
						<td>合计费用：</td>
						<td>
							${result.totalprice }
						</td>
						<td><span id="endtime_errMsg"></span></td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="button" class="bt" value="退房" onClick="checkAndSubmit()" />
						</td>
					</tr>
				</table>
			</form>
			</div>
			</div>
			</div>
		</body>
	</html>
