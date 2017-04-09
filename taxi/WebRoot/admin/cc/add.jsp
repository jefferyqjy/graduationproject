<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>  
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
		String method=request.getParameter("method"); 
		String id="";String hm = "";String pp=""; String lx=""; String cj=""; String bz=""; 
		if(method.equals("upcc")){
			id=request.getParameter("id");
			List jlist = cb.get1Com("select * from cc where id='"+id+"'",6);
			hm=jlist.get(1).toString();
			pp=jlist.get(2).toString(); 
			lx=jlist.get(3).toString(); 
			cj=jlist.get(4).toString(); 
			bz=jlist.get(5).toString(); 
			
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
<form action="<%=basePath %>com.do?method=<%=method%>&id=<%=id%>" method="post" name="form1" onSubmit="return check()">
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
  <tbody> 
    <tr bgColor=#ffffff>
      <td class="font1" height="26" width="45%" align=right>合同名称：</td>
      <td class="font1" align=left><input type="text" name=hm  value="<%=hm %>" size="50"/></td>
    </tr>  
     <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>签订日期：</td>
      <td class="font1" align=left><input type="text" name=pp  value="<%=pp %>" size="20"  readonly onclick="SelectDate(this,'yyyy-MM-dd')"  this.Txt_Date.Attributes["onclick"] = "SelectDate(this,'yyyy-MM-dd')";></td>
    </tr>  
     <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>合同甲方：</td>
      <td class="font1" align=left><input type="text" name=lx  value="<%=lx %>" size="50"/></td>
    </tr>  
     <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>合同乙方：</td>
      <td class="font1" align=left><input type="text" name=cj  value="<%=cj %>" size="50" /></td>
    </tr>  
    <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>详细内容：</td>
      <td class="font1" align=left>
      <TEXTAREA  NAME="bz" ROWS="8" COLS="50"><%=bz %></TEXTAREA></td>
    </tr> 
    <tr bgColor=#ffffff>
      <td class="font1" colspan="2" height="23" align=center><input type="submit" value="确定"></td>
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
