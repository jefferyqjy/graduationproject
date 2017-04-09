<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>/sys_jsp/admin/checkcategory2.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
				//获得后台的值,把相应的select的option选为默认的值
			$(document).ready(function(){
			 selectCheckPayStats("gender","${result.gender}");
		
			 
			});
			//修改select的option默认显示项的方法
			  function selectCheckPayStats(id,value)
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
  
  <body id="page" onLoad="loadProvince()">
  <div id="contentWrap">
  	<div id="widget table-widget">
  	<div class="pageTitle">当前位置：修改信息</div>
  	<div class="pageInput" align="center">
  <form action="admin/admin_update3.do" name="form1" method="post">
    <table id="normalT">
    	<tr>
    		<td>用&nbsp;户&nbsp;名：</td>
    		<td>
    		<input type="hidden" name="username" value="${result.username }"/>
    		<input type="hidden" name="password" value="${result.password }"/>
    		${result.username }
    		</td>
    	</tr>
    	<tr>
    		<td>昵&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
    		<td>
    			<input type="text" name="name" value="${result.name }"/>
    		</td>
    	</tr>
    	<tr>
    		<td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    		<td>
    			<select name="gender" value="${result.gender }" id="gender">
    				<option value="男">男</option>
    				<option value="女">女</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td>生&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
    		<td>
    			<input type="text" readonly="readonly" name="birthday" value="${result.birthday }" onfocus="calendar.show(this)">
    		</td>
    	</tr>
    	<tr>
    		<td>省&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
    		<td>
    			 <select name="province" id="province" onchange="cityName(this.selectedIndex)">
				    <option value="">
				     请选择省名
				    </option>
   				</select>

    			
    		</td>
    	</tr>
    	<tr>
    		<td>城&nbsp;&nbsp;&nbsp;&nbsp;市：</td>
    		<td>
    			 <select name="city" id="city">
				    <option value="">
				     请选择城名
				    </option>
				   </select>
    			
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2">
    			<input type="submit" value="提交修改" />
    		</td>
    	</tr>
    </table>
    </form>
    </div></div></div>
  </body>
</html>
