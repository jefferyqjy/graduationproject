<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="cb" scope="page" class="com.bean.ComBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>��̨������</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link href="<%=basePath %>admin/images/style.css" rel="stylesheet" type="text/css"> 
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "����";
	font-size: 12px;
	color: #333333;
	background-color: #2286C2;
}
-->
</style>
</head>
<SCRIPT language=javascript>
//��������ĺϷ���
function check() {//username,password,realname,sex,age,tel,address
	if (document.form1.username.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\����д��ţ�");
		document.form1.username.focus();
		return false;
	}
	if (document.form1.password.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\����д���պţ�");
		document.form1.password.focus();
		return false;
	} 
	if (document.form1.realname.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\����д������");
		document.form1.realname.focus();
		return false;
	} 
	if (document.form1.age.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\����д���䣡");
		document.form1.age.focus();
		return false;
	} 
	if (document.form1.tel.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\����д��ϵ�绰��");
		document.form1.tel.focus();
		return false;
	} 
	if (document.form1.address.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\����д��ע��Ϣ��");
		document.form1.address.focus();
		return false;
	} 
}
</SCRIPT>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message"); 
	
	String user=(String)session.getAttribute("user"); 
	if(user==null){
		response.sendRedirect(basePath+"index.jsp");
	}
	else{//username,password,realname,sex,age,tel,address
		String method=request.getParameter("method");
		String id=""; String username="";String password="";String realname="";String sex="";String age="";String tel=""; String address="";
		if(method.equals("upjsy")){
			id=request.getParameter("id");
			List alist=cb.get1Com("select * from jsy where id='"+id+"'",8);
			username=alist.get(1).toString();
			password=alist.get(2).toString();
			realname=alist.get(3).toString();
			sex=alist.get(4).toString();
			age=alist.get(5).toString();
			tel=alist.get(6).toString(); 
			address=alist.get(7).toString(); 
		}
%>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td height="2">&nbsp;</td>
  </tr>
  <tr>
	<td background="<%=basePath %>admin/images/index1_45.gif"></td>
	<td bgcolor="#FFFFFF" style="height:490px; vertical-align:top;">
	  <table width="100%" border="0" cellspacing="10" cellpadding="0">
		<tr>
		  <td>
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C4E7FB">
			  <tr>
				<td>
				  <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
					<tr>
					  <td class="font2">&nbsp;��ʻԱ��Ϣ����</td>
					</tr>
				  </table>
				</td>
			  </tr>
			</table>
		  </td>
		</tr>
		<tr>
		  <td>
<form action="<%=basePath %>admin.do?method=<%=method%>&id=<%=id%>" method="post" name="form1" onSubmit="return check()">
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
  <tbody> 
    <TR bgColor=#ffffff>
      <TD class="font1" height="26" width="45%" align=right>��ʻԱ��ţ�</td>
      <TD class="font1" align=left><input type="text" size="30" name="username" value="<%=username %>"></td>
    </tr>
    <TR bgColor=#ffffff>
      <TD class="font1" width="45%" align=right height="26">��ʻ֤���룺</td>
      <TD class="font1" align=left><input type="text" size="30" name="password" value="<%=password %>"></td>
    </tr>
    <TR bgColor=#ffffff>
      <TD class="font1" width="45%" align=right height="26">��ʻԱ������</td>
      <TD class="font1" align=left><input type="text" size="30" name="realname" value="<%=realname %>"></td>
    </tr>
    <TR bgColor=#ffffff>
      <TD class="font1" width="45%" align=right height="26">��ʻԱ�Ա�</td>
      <TD class="font1" align=left><input type="radio" name="sex" value="��" checked="checked"> �� <input type="radio" name="sex" value="Ů"> Ů</td>
    </tr> 
    <TR bgColor=#ffffff>
      <TD class="font1" width="45%" align=right height="26">��ʻԱ���䣺</td>
      <TD class="font1" align=left><input type="text" size="30" name="age" value="<%=age %>"></TD>
    </tr>
    <TR bgColor=#ffffff>
      <TD class="font1" width="45%" align=right height="26">��ϵ�绰��</td>
      <TD class="font1" align=left><input type="text" size="30" name="tel" value="<%=tel %>"></TD>
    </tr>  
    <TR bgColor=#ffffff>
      <TD class="font1" width="45%" align=right height="26">��ע��Ϣ��</td>
      <TD class="font1" align=left><textarea name="address" cols=50 rows=8><%=address %></textarea></TD>
    </tr> 
    
    <TR bgColor=#ffffff>
      <td class="font1" colspan="2" align=center height="26">
      <input type="submit" value="ȷ��"></td>
    </tr> 
  </tbody>
</table>
</form>
</td>
</tr> 
	  </table>
	</td>
	<td background="images/index1_47.gif"></td>
  </tr>
  <tr>
	<td width="8" height="8"><img src="images/index1_91.gif" width="8" height="8" /></td>
	<td background="images/index1_92.gif"></td>
	<td width="8" height="8"><img src="images/index1_93.gif" width="8" height="8" /></td>
  </tr>
</table>
</body>
<%} %>