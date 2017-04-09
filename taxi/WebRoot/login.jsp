<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312" %>
<%@ include file="iframe/head.jsp" %>  
<SCRIPT language=javascript>
//检验表单的合法性
function checklogin(e) {
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
 
  <FORM name="loginform" method="post" action="<%=basePath %>login.do?method=mlogin" onSubmit="return checklogin();"> 
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
	  <TD width="20%" align="right">用户身份：</TD>
	  <TD align="left"><select name="sf"> 
	  <option value="用户">用户</option>  
	  <option value="管理员">管理员</option>
	  </select></TD>
	</TR> 
    <TR>
      <TD align="center" colspan="2"><a href="<%=basePath %>login.do?method=reg">注册</a>&nbsp;&nbsp;<INPUT value="登录" type=submit>&nbsp;&nbsp;<INPUT value="重置" type=reset></TD>
	</TR>
	</TBODY>
  </TABLE>
  </FORM>
<%@ include file="iframe/foot.jsp"%>
