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
					if(formValidation(true)){
						document.mainform.submit();
					}
				}
				
				function checkAndSubmit2(custgenid) {
					//alert(custgenid);
					if(formValidation(true)){
					 	//var bb =  $('begintime').val();
					 	//var ee =  $('endtime').val();
					 	var bb = document.getElementById('begintime').value;
					 	var ee = document.getElementById('endtime').value;
					 	var id = document.getElementById('id').value;
						var url = "roomoperation/roomoperation_searchfreeroom2.do?id="+id+"&custgenid="+custgenid+"&begintime="+bb+"&endtime="+ee;
						self.location.href = encodeURI(url);
					}
					
				}
			</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：客户调房</div>
			<div class="pageInput" align="center">
			<form action="roomoperation/roomoperation_add.do" method="post" name="mainform" target="roomoperation_window">
				<input type='hidden' name='id' id ="id" value='${result.id }' />
				<input type='hidden' name='custgenid' value='${result.custgenid }' />
				<input type='hidden' name='identityid' value='${result.identityid }' />
				
				<input type='hidden' name='roomgenid' value='${result.roomgenid }' />
				<input type='hidden' name='custid' value='${result.custid }' />
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
					<!-- 
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
					 -->
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
						<td>入住时间：</td>
						<td>
							<input type='hidden' name='begintime' id="begintime" value='${result.begintime }' />
							${result.begintime }
							
							
						</td>
						<td><span id="begintime_errMsg"></span></td>
					</tr>
					<tr>
						<td>退房时间：</td>
						<td>
							<input type='hidden' name='endtime' id="endtime" value='${result.endtime }' />
							${result.endtime }
							
						</td>
						<td><span id="endtime_errMsg"></span></td>
					</tr>
					
					
					<tr>
						<td>房间编号：</td>
						<td>
							<input type="text" name="roomid" value="${result.roomid }" readonly="readonly"/>
							<!-- 
							<img title="查找" src="<%=basePath%>/sys_css/icon/edit2.png" width="16" height="16" onclick="mdy('<%=basePath%>/roomoperation/roomoperation_searchfreeroom.do?custgenid=${record.custgenid}')"/>
							 -->
							<input type="button" class="bt" value="查找房间" onClick="checkAndSubmit2(${result.custgenid})" />
						</td>
						<td><span id="roomid_errMsg"></span></td>
					</tr>
					
					<tr>
						<td>备注：</td>
						<td>
							<input type="text" name="remarks" value="${result.remarks }" />
						</td>
						<td><span id="remarks_errMsg"></span></td>
					</tr>
					<!-- 
					<tr>
						<td colspan="3">
							<input type="button" class="bt" value="入住" onClick="checkAndSubmit()" />
						</td>
					</tr>
					 -->
				</table>
			</form>
			</div>
			</div>
			</div>
		</body>
	</html>
