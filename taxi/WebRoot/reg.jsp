<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312" %>
<%@ include file="iframe/head.jsp" %>  
<SCRIPT language=javascript>
//检验表单的合法性
function checklogin() {
	if (document.loginform.username.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\请输入您的用户名！");
		document.loginform.username.focus();
		return false;
	}
	if (document.loginform.password.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\请输入您的密码！");
		document.loginform.password.focus();
		return false;
	} 
}
</SCRIPT>
 
  <FORM name="loginform" method="post" action="<%=basePath %>login.do?method=doReg" onSubmit="return checklogin();"> 
  <TABLE align=center height="180">
    <TBODY>
    <TR>
	  <TD width="20%" align="right">用户帐号：</TD>
	  <TD align="left"><input type="text" size="30" name="username"></TD>
	</TR>
	<TR>
	  <TD width="20%" align="right">登录密码：</TD>
	  <TD align="left"><input type="password" size="33" name="password"></TD>
	</TR>
	<TR>
	  <TD width="20%" align="right">确认密码：</TD>
	  <TD align="left"><input type="password" size="33" name="confirmpassword"></TD>
	</TR> 
	<TR>
	  <TD width="20%" align="right">性别：</TD>
	  <TD align="left">
	  	<select name="sex" >
	  		<option value="男">男</option>
	  		<option value="女">女</option>
	  	</select>
	  </TD>
	</TR>
	<TR>
	  <TD width="20%" align="right">年龄：</TD>
	  <TD align="left"><input type="text" size="33" name="age"></TD>
	</TR>
	<TR>
	  <TD width="20%" align="right">电话：</TD>
	  <TD align="left"><input type="text" size="33" name="tel"></TD>
	</TR> 
	<TR>
	  <TD width="20%" align="right">地址：</TD>
	  <TD align="left"><input type="text" size="33" name="address"></TD>
	</TR>        
	<TR>
	  <TD width="20%" align="right">用户身份：</TD>
	  <TD align="left"><select name="sf"> 
	  <option value="用户">用户</option>  
	  <option value="管理员">管理员</option>
	  </select></TD>
	</TR> 
    <TR>
      <TD align="center" colspan="2"><INPUT value="确认" type=submit>&nbsp;&nbsp;</TD>
	</TR>
	</TBODY>
  </TABLE>
  </FORM>
<%@ include file="iframe/foot.jsp"%>
