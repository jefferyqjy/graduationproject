<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="<%=basePath %>admin/images/admin.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
	function expand(el)
	{
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none')
		{
			childObj.style.display = 'block';
		}
		else
		{
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>
<%
	String username=(String)session.getAttribute("user"); String sf=(String)session.getAttribute("sf"); 
	if(username==null){
		response.sendRedirect(path+"index.jsp");
	}
	else{ 
%>
<body>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170 background=<%=basePath %>admin/images/menu_bg.jpg border=0>
  <TR>
    <TD vAlign=top align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0><TR><TD height=10></TD></TR></TABLE> 
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(1) href="javascript:void(0);">������Ϣ����</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/system/editpwd.jsp" target="MainFrame">�޸ĵ�½����</A></TD></TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE> 
	 <%if(sf.equals("����Ա")){ %> 
	  
	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(3) href="javascript:void(0);">�û���Ϣ����</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/teacher/index.jsp" target="MainFrame">�û���Ϣ����</A></TD>
		</TR> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/teacher/add.jsp?method=addteacher" target="MainFrame">�����û���Ϣ</A></TD>
		</TR> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/teacher/s.jsp" target="MainFrame">��ѯ�û���Ϣ</A></TD>
		</TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE> 
	  <%} %>
	  
	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(10) href="javascript:void(0);">��ʻԱ����</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child10 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/jsy/index.jsp" target="MainFrame">��ʻԱ����</A></TD>
		</TR>  
		<%if(sf.equals("����Ա")){ %> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/jsy/add.jsp?method=addjsy" target="MainFrame">�ǼǼ�ʻԱ</A></TD>
		</TR> 
		<%} %>
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/jsy/s.jsp" target="MainFrame">��ѯ��ʻԱ</A></TD>
		</TR>  
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  
	  
	  
	  
	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(4) href="javascript:void(0);">������Ϣ����</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/classes/index.jsp" target="MainFrame">������Ϣ����</A></TD>
		</TR>  
		<%if(sf.equals("����Ա")){ %>
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/classes/add.jsp?method=addclasses" target="MainFrame">���ӳ�����Ϣ</A></TD>
		</TR> 
		<%} %> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/classes/s.jsp" target="MainFrame">��ѯ������Ϣ</A></TD>
		</TR>  
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  
	  <!-- ����Լ���µ����� -->
	   <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(6) href="javascript:void(0);">Լ����������</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child6 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
      	<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/order/index.jsp" target="MainFrame">Լ��������Ϣ����</A></TD>
		</TR> 
		
      	<!-- �û�����Լ���µ�������Աֻ�ܲ�ѯ���� -->
      	<%if(!sf.equals("����Ա")){ %>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/order/add.jsp?method=addorder" target="MainFrame">Լ���µ�</A></TD>
		</TR> 
		<%} %> 
		<%if(sf.equals("����Ա")){ %>
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/order/s.jsp" target="MainFrame">��ѯԼ������</A></TD>
		</TR>
		<%} %> 
		<!-- ����Ա������������λ����Ϣ���û�ֻ�ܲ�ѯ����λ����Ϣ -->
		<%if(sf.equals("����Ա")){ %>
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/record/add.jsp?method=addrecord" target="MainFrame">���ӳ���λ����Ϣ</A></TD>
		</TR> 
		<%} %> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/record/s.jsp" target="MainFrame">��ѯ����λ��</A></TD>
		</TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  <!-- ����Լ���µ����� -->
	   
	  <%if(sf.equals("����Ա")){ %>
	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(5) href="javascript:void(0);">����Ԥ������</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/tb/index.jsp" target="MainFrame">����Ԥ������</A></TD>
		</TR> 
		 <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/tb/add.jsp?method=addtb" target="MainFrame">�ǼǱ�����Ϣ</A></TD>
		</TR> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/tb/s.jsp" target="MainFrame">��ѯ������Ϣ</A></TD>
		</TR>   
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  <%} %>
	  
	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(19) href="javascript:void(0);">Ӫ����Ϣ����</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child19 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/wz/index.jsp" target="MainFrame">Ӫ����Ϣ����</A></TD>
		</TR>   
		<%if(sf.equals("����Ա")){ %>
		 <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/wz/add.jsp?method=addwz" target="MainFrame">�Ǽ�Ӫ����Ϣ</A></TD>
		</TR>
		 <%} %>
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/wz/s.jsp" target="MainFrame">��ѯӪ����Ϣ</A></TD>
		</TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  
	  
	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(119) href="javascript:void(0);">����֧������</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child119 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/zc/index.jsp" target="MainFrame">����֧������</A></TD>
		</TR>  
		<%if(sf.equals("����Ա")){ %> 
		 <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/zc/add.jsp?method=addzc" target="MainFrame">�ǼǷ���֧��</A></TD>
		</TR>
		  <%} %>
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/zc/s.jsp" target="MainFrame">��ѯ����֧��</A></TD>
		</TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  
	  <%if(sf.equals("����Ա")){ %> 
	   <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(149) href="javascript:void(0);">��ͬ��Ϣ����</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child149 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/cc/index.jsp" target="MainFrame">��ͬ��Ϣ����</A></TD>
		</TR>   
		 <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/cc/add.jsp?method=addcc" target="MainFrame">�ǼǺ�ͬ��Ϣ</A></TD>
		</TR> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/cc/s.jsp" target="MainFrame">��ѯ��ͬ��Ϣ</A></TD>
		</TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
	  
       
       <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=basePath %>admin/images/menu_bt.jpg>
          <A class=menuParent onclick=expand(1149) href="javascript:void(0);">��Ϣ�������</A></TD>
		</TR>
        <TR height=4><TD></TD></TR>
	  </TABLE>
      <TABLE id=child1149 style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/bb/c.jsp" target="MainFrame">������Ϣ����</A></TD>
		</TR>   
		 <TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/bb/s.jsp?method=addcc" target="MainFrame">˾����Ϣ����</A></TD>
		</TR> 
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/bb/p.jsp" target="MainFrame">Ӫ����Ϣ����</A></TD>
		</TR>  
		<TR height=20>
          <TD align=middle width=30><IMG height=9 src="<%=basePath %>admin/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild href="<%=basePath %>admin/bb/zc.jsp" target="MainFrame">��˾֧������</A></TD>
		</TR> 
        <TR height=4>
          <TD colSpan=2></TD>
		</TR>
	  </TABLE>
       <%} %>
	  
       </TD>
     </TR> 
</TABLE>
</body>
<%} %>
</HTML>
