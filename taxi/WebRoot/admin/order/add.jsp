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
		String method=request.getParameter("method"); 
		String id="";
		String orderUsername = "";
		String jsyname=""; 
		String hm=""; 
		String departure=""; 
		String arrival="";
		String distance = "";
		String createtime = "";
		String amount = "";
		String status = "";
		String comment = "";
		if(method.equals("uporder")){
			id=request.getParameter("id");
			List jlist = cb.get1Com("select * from order where id='"+id+"'",11);
			orderUsername=jlist.get(1).toString();
			jsyname=jlist.get(2).toString(); 
			hm=jlist.get(3).toString(); 
			departure=jlist.get(4).toString(); 
			arrival=jlist.get(5).toString(); 
			distance=jlist.get(6).toString();
			createtime = jlist.get(7).toString();
			amount = jlist.get(8).toString();
			status = jlist.get(9).toString();
			comment = jlist.get(10).toString();
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
<form action="<%=basePath %>com.do?method=<%=method%>&id=<%=id%>" method="post" name="form1" onSubmit="return check()">
<input type="hidden" name="username" value="<%=username %>" />
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
  <tbody>
    <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>选择车辆：</td>
      <td class="font1" align=left>
      	<!-- <input type="text" name=hm  value="<%=hm %>" size=50/> -->
      	<select name=hm>
   			<option value="<%=hm %>"><%=hm %></option>
      		<%
      			List list1=cb.getCom("select * from classes where isactive = '是' order by id desc",6);
      			if(!list1.isEmpty()){
      				for(int i=0;i<list1.size();i++){
      					List list2 =(List)list1.get(i); 
			%>
    			<option value=<%=list2.get(1).toString() %>><%=list2.get(1).toString() %></option>
    		<%}} %>
      	</select>
      </td>
    </tr>  
     <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>选择驾驶员：</td>
      <td class="font1" align=left>
      	<select name=jsyname>
   			<option value="<%=jsyname %>"><%=jsyname %></option>
      		<%
      			List list3=cb.getCom("select * from jsy order by id desc",6);
      			if(!list1.isEmpty()){
      				for(int i=0;i<list3.size();i++){
      					List list4 =(List)list3.get(i); 
			%>
    			<option value=<%=list4.get(1).toString() %>><%=list4.get(1).toString() %></option>
    		<%}} %>
      	</select>
      </td>
    </tr>  
     <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>出发地：</td>
      <td class="font1" align=left><input type="text" name=departure  value="<%=departure %>" size=50/></td>
    </tr>  
     <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>到达地：</td>
      <td class="font1" align=left><input type="text" name=arrival  value="<%=arrival %>" size=50/></td>
    </tr>
    <tr bgColor=#ffffff>
      <td class="font1" height="26" width="35%" align=right>里程（公里）：</td>
      <td class="font1" align=left><input type="text" name=distance value="<%=distance %>" size=50/></td>
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
