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
				window.name="roominfo_window";
				function checkAndSubmit() {
						if(formValidation(true)){
						document.mainform.submit();
					}
					}
				
				
				//获得后台的值,把相应的select的option选为默认的值
			$(document).ready(function(){
			 selectcartype("roomtype","${result.roomtype}");
			 
			 selectcartype("status","${result.status}");
			 
			 selectcartype("airconition","${result.airconition}");
			 
			 selectcartype("tv","${result.tv}");
			 
			});
			//修改select的option默认显示项的方法
			  function selectcartype(id,value)
			   {
			    //获得下拉列表的id
			    var select = document.getElementById(id);
			    //获得下拉列表的所有option
			    var options = select.options;
			    //循环获得对应的节点
			    for(var i=0;i<options.length;i++)
			    {
			     //获得节点的值和后台传来的值进行比较
			     if (options[i].value == value)
			     {
			      //如果当前节点与后台传来的值一致，则将当前节点设置为选中状态，并跳出循环
			      options[i].selected = true;
			      break;
			     }
			    }
			   }
			</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：修改客房信息</div>
			<div class="pageInput" align="center">
			<form action="roominfo/roominfo_update.do" method="post" name="mainform" target="roominfo_window">
				<table>
				<input type='hidden' name='id' value='${result.id }' />
					<tr>
						<td>客房编号：</td>
						<td>
							<input type="text" name="roomid" value="${result.roomid }" class="CHAR_M"/>
						</td>
						<td><span id="roomid_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房类型：</td>
						<td>
							
							<select name="roomtype" id="roomtype" value="${result.roomtype }">
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
							<input type="text" name="roomposition" value="${result.roomposition }" />
						</td>
						<td><span id="roomposition_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房描述:</td>
						<td>
							<input type="text" name="roomdesc" value="${result.roomdesc }" />
						</td>
						<td><span id="roomdesc_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房状态：</td>
						<td>
							
							<select name="status" id="status" value="${result.status }">
								
								<option value="空闲">空闲</option>
								<option value="入住">入住</option>
							</select>
						</td>
						<td><span id="status_errMsg"></span></td>
					</tr>
					<tr>
						<td>客房价格：</td>
						<td>
							<input type="text" name="price" value="${result.price }" class="NUMB_M"/>
						</td>
						<td><span id="price_errMsg"></span></td>
					</tr>
					<tr>
						<td>电视配置：</td>
						<td>
							
							<select name="tv" id="tv" value="${result.tv }">
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</td>
						<td><span id="tv_errMsg"></span></td>
					</tr>
					<tr>
						<td>空调配置：</td>
						<td>
							
							
							<select name="airconition" id="airconition" value="${result.airconition }">
								<option value="是">是</option>
								<option value="否">否</option>
							</select>
						</td>
						<td><span id="airconition_errMsg"></span></td>
					</tr>
					<tr>
						<td>床位配置：</td>
						<td>
							<input type="text" name="bednum" value="${result.bednum }" class="NUMB_M"/>
						</td>
						<td><span id="bednum_errMsg"></span></td>
					</tr>
					<tr>
						<td>备注信息：</td>
						<td>
							<input type="text" name="remark" value="${result.remark }" />
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
