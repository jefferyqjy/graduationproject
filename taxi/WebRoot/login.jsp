<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312" %>
<%@ include file="iframe/head.jsp" %>  
<SCRIPT language=javascript>
//��������ĺϷ���
function checklogin(e) {
	if (document.loginform.username.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\�����������û�����");
		document.loginform.username.focus();
		return false;
	}
	if (document.loginform.password.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\�������������룡");
		document.loginform.password.focus();
		return false;
	} 
}
</SCRIPT>
 
  <FORM name="loginform" method="post" action="<%=basePath %>login.do?method=mlogin" onSubmit="return checklogin();"> 
  <TABLE align=center height="180">
    <TBODY>
    <TR>
	  <TD width="20%" align="right">�û��ʺţ�</TD>
	  <TD align="left"><input type="text" size="30" name="username"></TD>
	</TR>
	<TR>
	  <TD width="20%" align="right">��¼���룺</TD>
	  <TD align="left"><input type="password" size="33" name="password"></TD>
	</TR> 
	<TR>
	  <TD width="20%" align="right">�û����ݣ�</TD>
	  <TD align="left"><select name="sf"> 
	  <option value="�û�">�û�</option>  
	  <option value="����Ա">����Ա</option>
	  </select></TD>
	</TR> 
    <TR>
      <TD align="center" colspan="2"><a href="<%=basePath %>login.do?method=reg">ע��</a>&nbsp;&nbsp;<INPUT value="��¼" type=submit>&nbsp;&nbsp;<INPUT value="����" type=reset></TD>
	</TR>
	</TBODY>
  </TABLE>
  </FORM>
<%@ include file="iframe/foot.jsp"%>