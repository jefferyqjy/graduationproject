<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--#include file="inc/Conn.asp"-->
<!--#include file="inc/AllFunction.asp" -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>管理页面</TITLE>
<STYLE type=text/css>BODY {
 BACKGROUND: #799ae1; MARGIN: 0px; FONT: 9pt 宋体
}
TABLE {
 BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
TD {
 FONT: 12px 宋体
}
IMG {
 BORDER-RIGHT: 0px; BORDER-TOP: 0px; VERTICAL-ALIGN: bottom; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
A {
 FONT: 12px 宋体; COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
 COLOR: #428eff; TEXT-DECORATION: underline
}
.sec_menu {
 BORDER-RIGHT: white 1px solid; BACKGROUND: #d6dff7; OVERFLOW: hidden; BORDER-LEFT: white 1px solid; BORDER-BOTTOM: white 1px solid
}
.menu_title {
 
}
.menu_title SPAN {
 FONT-WEIGHT: bold; LEFT: 7px; COLOR: #215dc6; POSITION: relative; TOP: 2px
}
.menu_title2 {
 
}
.menu_title2 SPAN {
 FONT-WEIGHT: bold; LEFT: 8px; COLOR: #428eff; POSITION: relative; TOP: 2px
}
</STYLE>

<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>

<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2900.2180" name=GENERATOR></HEAD>
<BODY bgcolor="#99CCFF" leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">

<TABLE cellSpacing=0 cellPadding=0 width="100%" align=left border=0>
<TBODY>
<TR>
    <TD vAlign=top bgColor=#99CCFF> 
      
    <TABLE cellSpacing=0 border=0 cellPadding=0 width=158 align=center>
      <TBODY>
      <TR>
            
          <TD class=menu_title onMouseOver="this.className='menu_title2';" 
        onmouseout="this.className='menu_title';" background="" height=25> <SPAN>| 
            <A href="login.html" target=_parent><B>退出</B></A></SPAN> <SPAN>
            
      </TR>
      </TBODY></TABLE>
 <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
      <TBODY>
      <TR>
            
          <TD
          height=25 bgcolor="#99CCFF" class=menu_title id=menuTitle1 onclick=showsubmenu(0) 
        onmouseover="this.className='menu_title2';" 
        onmouseout="this.className='menu_title';"><span><B>新闻管理</B></span></TD>
      </TR>
      <TR>
        <TD id=submenu0>
          <DIV class=sec_menu style="WIDTH: 158px ">
          <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
            <TBODY>             
             <TR>
                      <TD height=20><a href="admin.html?ssh=newlist" target="frams">新闻列表</a></TD>
             </TR>
	         <TR>
                      <TD height=20><a href="admin.html?ssh=atclist" target="frams">最新活动</a></TD>
             </TR>
            
            </TBODY></TABLE>
          </DIV>
          </TD></TR></TBODY></TABLE>
 
          
          
          
          <TABLE cellSpacing=0 border=0 cellPadding=0 width=158 align=center>
      <TBODY>
      <TR>
            
          <TD
          height=20 bgcolor="#99CCFF" class=menu_title id=menuTitle1 onclick=showsubmenu(26) 
        onmouseover="this.className='menu_title2';" 
        onmouseout="this.className='menu_title';"><span><b>用户管理</b></span></TD>
      </TR>
      <TR>
        <TD id=submenu26>
          <DIV class=sec_menu style="WIDTH: 158px ">
          <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
            <TBODY>
            <TR>
                      <TD height=20><a href="zc.html?ssh=zhuce" target="frams">添加用户</a></TD>
            </TR>
             <TR>
                      <TD height=20><a href="admin.html?ssh=alluser" target="frams">用户列表</a></TD>
            </TR>
             <TR>
                      <TD height=20><a href="admin.html?ssh=huf" target="frams">禁用用户</a></TD>
            </TR>
            </TBODY></TABLE>
          </DIV>
          </TD></TR></TBODY></TABLE>
          
          
    </TABLE>
   
      </BODY>
      </HTML>