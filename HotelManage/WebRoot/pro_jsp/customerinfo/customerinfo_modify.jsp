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
				window.name="customerinfo_window";
				function checkAndSubmit() {
					if(formValidation(true)){
						document.mainform.submit();
					}
				}
				
				//获得后台的值,把相应的select的option选为默认的值
			$(document).ready(function(){
			 selectcartype("sex","${result.sex}");
			 
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
			<div class="pageTitle">当前位置：修改客户信息</div>
			<div class="pageInput" align="center">
			<form action="customerinfo/customerinfo_update.do" method="post" name="mainform" target="customerinfo_window">
				<input type='hidden' name='id' value='${result.id }' />
				<table>
				
					<tr>
						<td>身份证号：</td>
						<td>
							${result.identityid }
							<input type='hidden' name='identityid' value='${result.identityid }' />
						</td>
						<td><span id="identityid_errMsg"></span></td>
					</tr>
					<tr>
						<td>客户姓名：</td>
						<td>
							${result.custname }
							<input type='hidden' name='custname' value='${result.custname }' />
						</td>
						<td><span id="custname_errMsg"></span></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>
							 <select name="sex" id="sex" value="${result.sex }">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</td>
						<td><span id="sex_errMsg"></span></td>
					</tr>
					<tr>
						<td>联系方式：</td>
						<td>
							<input type="text" name="phone" value="${result.phone }" class="NUMB_M"/>
						</td>
						<td><span id="phone_errMsg"></span></td>
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
