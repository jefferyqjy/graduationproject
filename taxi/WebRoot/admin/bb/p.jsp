<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"  contentType="text/html;charset=gb2312"%> 
<jsp:useBean id="cb" scope="page" class="com.bean.ComBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
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
<script  language="javascript" >
function top(){
   	form3.action="<%=basePath%>admin/wz/index.jsp?page=1";
    form3.submit();
}
function last(){
    if(form3.pageCount.value==0){//如果总页数为0，那么最后一页为1，也就是第一页，而不是第0页
    form3.action="<%=basePath%>admin/wz/index.jsp?page=1";
    form3.submit();
	}else{
	form3.action="<%=basePath%>admin/wz/index.jsp?page="+form3.pageCount.value;
    	form3.submit();
	}
}
function pre(){
  var page=parseInt(form3.page.value);
  if(page<=1){
    alert("已至第一页");
  }else{
    form3.action="<%=basePath%>admin/wz/index.jsp?page="+(page-1);
    form3.submit();
  }
}

function next(){
  var page=parseInt(form3.page.value);
  var pageCount=parseInt(form3.pageCount.value);
  if(page>=pageCount){
    alert("已至最后一页");
  }else{
    form3.action="<%=basePath%>admin/wz/index.jsp?page="+(page+1);
    form3.submit();
  }
}
function bjump(){
  	var pageCount=parseInt(form3.pageCount.value);
  	if( fIsNumber(form3.busjump.value,"1234567890")!=1 ){
		alert("跳转文本框中只能输入数字!");
		form3.busjump.select();
		form3.busjump.focus();
		return false;
	}
	if(form3.busjump.value>pageCount){//如果跳转文本框中输入的页数超过最后一页的数，则跳到最后一页
	  if(pageCount==0){	
	  form3.action="<%=basePath%>admin/wz/index.jsp?page=1";
	  form3.submit();
	}
	else{
		form3.action="<%=basePath%>admin/wz/index.jsp?page="+pageCount;
		form3.submit();
	}
}
else if(form3.busjump.value<=pageCount){
var page=parseInt(form3.busjump.value);
   if(page==0){
      page=1;//如果你输入的是0，那么就让它等于1
      form3.action="<%=basePath%>admin/wz/index.jsp?page="+page;
      form3.submit();
   }else{
      form3.action="<%=basePath%>admin/wz/index.jsp?page="+page;
      form3.submit();
   }

}

}
//****判断是否是Number.
function fIsNumber (sV,sR){
var sTmp;
if(sV.length==0){ return (false);}
for (var i=0; i < sV.length; i++){
sTmp= sV.substring (i, i+1);
if (sR.indexOf (sTmp, 0)==-1) {return (false);}
}
return (true);
}
function del()
{
	pageform.submit();
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
		  <td><form action="" method="post" name="form3">	
			<table  id="content" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
			  <tr>
				<td class="font1" height="27" align="center" background="<%=basePath %>admin/images/index1_72.gif" bgcolor="#FFFFFF"><strong>序号</td> 
      <td class="font1" align="center" background="<%=basePath %>admin/images/index1_72.gif" bgcolor="#FFFFFF"><strong>车牌号码</strong></td> 
       <td class="font1" align="center" background="<%=basePath %>admin/images/index1_72.gif" bgcolor="#FFFFFF"><strong>买票日期</strong></td>
        <td class="font1" align="center" background="<%=basePath %>admin/images/index1_72.gif" bgcolor="#FFFFFF"><strong>买票金额</strong></td>
         <td class="font1" align="center" background="<%=basePath %>admin/images/index1_72.gif" bgcolor="#FFFFFF"><strong>票号区间</strong></td>
          <td class="font1" align="center" background="<%=basePath %>admin/images/index1_72.gif" bgcolor="#FFFFFF"><strong>备注说明</strong></td>  
    </tr>
<% 
	cb.setEVERYPAGENUM(12);
	int cou = cb.getMessageCount("select count(*) from wz");//得到信息总数			        
	String page1=request.getParameter("page");
	if(page1==null){
		page1="1";
	}
	session.setAttribute("busMessageCount", cou + "");
	session.setAttribute("busPage", page1);
	List pagelist1 = cb.getMessage(Integer.parseInt(page1),"select * from wz order by id desc",6);
	session.setAttribute("qqq", pagelist1);
	int pageCount = cb.getPageCount(); //得到页数  
	session.setAttribute("busPageCount", pageCount + ""); 
	List pagelist3=(ArrayList)session.getAttribute("qqq");
		if(!pagelist3.isEmpty()){
		for(int i=0;i<pagelist3.size();i++){
			List pagelist2 =(ArrayList)pagelist3.get(i); 
%> 
    <tr bgColor=#ffffff align=center>
      <td  class="font1" align=center height="23"><%=i+1 %></td>
      <td  class="font1" align=center><%=pagelist2.get(1).toString() %></td>  
      <td  class="font1" align=center><%=pagelist2.get(2).toString() %></td>  
      <td  class="font1" align=center><%=pagelist2.get(3).toString() %></td>  
      <td  class="font1" align=center><%=pagelist2.get(4).toString() %></td>  
      <td  class="font1" align=center><%=pagelist2.get(5).toString() %></td>  
    </tr>
<% }} %> 
  <tr align="center" bgcolor="#FFFFFF"> 
				<td class="font1" colspan=18><script>
function Excel_onclick()
    {
      var oXL = new ActiveXObject("Excel.Application"); 
      var oWB = oXL.Workbooks.Add(); 
      var oSheet = oWB.ActiveSheet;  
      var sel=document.body.createTextRange();
      sel.moveToElementText(content); //content就是下面的table id
      sel.select();
      sel.execCommand("Copy");
      oSheet.Paste();
      oXL.Visible = true;
    }
</script>
 
				</td>
			</tr>
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
