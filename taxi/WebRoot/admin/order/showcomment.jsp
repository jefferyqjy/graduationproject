<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>  
<%@ page import="java.math.*" %>
<jsp:useBean id="cb" scope="page" class="com.bean.ComBean" />
<%@ page language="java" import="com.fredck.FCKeditor.*" %> 
<%@ taglib uri="/WEB-INF/FCKeditor.tld" prefix="FCK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>后台操作区</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link href="<%=basePath %>admin/images/style.css" rel="stylesheet" type="text/css"> 
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	background-color: #2286C2;
}
-->
</style>
</head> 
<SCRIPT language=JavaScript src="<%=basePath %>admin/images/calendar.js"></SCRIPT>
<script type="text/javascript">
function check()
{
	if(document.form1.hm.value==""||document.form1.pp.value==""||document.form1.lx.value==""||document.form1.cj.value==""||document.form1.bz.value=="" )
	{
		alert("全部内容都要填写！");
		//document.form1.xzryj.focus();
		return false;
	}
}
</script>

<%
String message = (String)request.getAttribute("message");
String sf=(String)session.getAttribute("sf"); 
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message"); 
	
	String username=(String)session.getAttribute("user"); 
	if(username==null){
		response.sendRedirect(path+"index.jsp");
	}
	else{ 
		String id=request.getParameter("id");
		List list = cb.getMessage(1,"select * from taxi.order where id = '" + id + "'",11);
		String comment = "";
		if(!list.isEmpty()){
			List list2 =(ArrayList)list.get(0);
			comment = list2.get(10).toString();
		}
			
%>
<BODY  onLoad="document.form1.infoContent.value=document.form1.content.value" >
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
					  <td class="font2">&nbsp;订单管理</td>
					</tr>
				  </table>
				</td>
			  </tr>
			</table>
		  </td>
		</tr>
		<tr>
		  <td>
<form action="<%=basePath %>com.do?method=commentorder&id=<%=id%>" method="post" name="form1" onSubmit="return check()">
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
  	<tbody>
    	<tr bgColor=#ffffff>
      		<td class="font1" height="26" width="25%" align=right>评价：</td>
      		<td class="font1" align=left width="75%" >	
      			<textarea rows="10" cols="80" name=comment ><%=comment %></textarea>
      		</td>
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
