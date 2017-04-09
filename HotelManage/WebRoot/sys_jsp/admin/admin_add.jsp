<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Add Administrator&User</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		.required {
			color: red;
		}
	</style>
	<script type="text/javascript">
		function checkAndSumbit() {
			if(isEmpty(document.mainform.username.value)) {
				alert("用户名不能为空");
				return;
			}
			if(isEmpty(document.mainform.password.value)) {
				alert("密码不能为空");
				return;
			}
			if(isEmpty(document.mainform.cpassword.value)) {
				alert("确认密码不能为空");
				return;
			}
			if(document.mainform.password.value != document.mainform.cpassword.value){
				alert("密码和确认密码不一致");
				return;
			}
			document.mainform.submit();
		}
	</script>
  </head>
  
  <body id="page">
  <div id="contentWrap">
  	<div id="widget table-widget">
  	<div class="pageTitle">当前位置：添加用户</div>
  	<div class="pageInput">
		  <form action="admin/admin_add.do" method="post" name="mainform">
		    <table>
		    	<tr>
		    		<td>用&nbsp;户&nbsp;名：</td>
		    		<td>
		    			<input type="text" name="username" required/>
		    		</td>
		    		<td><span class="required">*</span></td>
		    	</tr>
		    	<tr>
		    		<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
		    		<td>
		    			<input type="password" name="password" required/>
		    		</td>
		    		<td><span class="required">*</span></td>
		    	</tr>
		    	<tr>
		    		<td>确认密码：</td>
		    		<td>
		    			<input type="password" name="cpassword" required/>
		    		</td>
		    		<td><span class="required">*</span></td>
		    	</tr>
		    	<tr>
		    		<td>类&nbsp;&nbsp;&nbsp;&nbsp;型：</td>
		    		<td colspan="2">
		    			<input type="radio" name="userType" value="1" checked="checked"/>管理员
		    		</td>
		    	</tr>
		    	
		    	<tr>
		    		<td colspan="3">
		    			<input type="button" value="提交" onclick="checkAndSumbit();"/>
		    		</td>
		    	</tr>
		    </table>
		    </form>
		    </div>
		   </div>
	    </div>
  </body>
</html>
