<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@taglib
	prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
		<script type="text/javascript" src="js/atts.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/date.js" charset="utf-8"></script>
		<link href="css/four.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
		<script type="text/javascript">
	function selfile(){
		window.open("saveimage.jsp","","toolbar=no,location=no,directories=no,status=no,menubar=no,resizable=yes,copyhistory=no,scrollbars=yes,width=400,height=240,top="+(screen.availHeight-240)/2+",left="+(screen.availWidth-400)/2+"");
	}
</script>
	</head>
	<%
		String message = (String) request.getAttribute("message");
		if (message == null) {
			message = "";
		}
		if (!message.trim().equals("")) {
			out.println("<script language='javascript'>");
			out.println("alert('" + message + "');");
			out.println("</script>");
		}
		request.removeAttribute("message");
	%><body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td bgcolor="#FFFFFF">
					<s:form action="atts/updateAtts.action" name="myform"
						onsubmit="return check()">
						<table width="80%" border="0" align="center" cellpadding="4"
							cellspacing="1" bgcolor="#aec3de">
							<tr align="center" bgcolor="#F2FDFF">
								<td align="left" colspan="2" class="optiontitle">
									修改景点
								</td>
							</tr>
							<input type="hidden" name="id" value="${id}" />
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									景点名称
								</td>
								<td align="left">
									<input type="text" name="atts.name" style="width: 160px"
										id="name" value="${atts.name}" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									景点图片
								</td>
								<td align="left">
									<input type="text" name="atts.image" style="width: 160px" readonly="readonly" onclick="selfile()" 
										id="image" value="${atts.image}" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									景点介绍
								</td>
								<td align="left">
									<textarea cols="80" id="intro" name="atts.intro"
										rows="10">${atts.intro}</textarea>
									<script type="text/javascript">
											    CKEDITOR.replace( 'intro',
											     {
											      language : 'zh-cn'
											     });
											  </script>
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									点击数
								</td>
								<td align="left">
									<input type="text" name="atts.hits" style="width: 160px" 
										readonly="readonly" id="hits" value="${atts.hits}" />
								</td>
							</tr>
							<tr align="center" bgcolor="#ebf0f7">
								<td colspan="2">
									<input type="submit" name="Submit" value="提交" />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" name="Submit2" value="重置" />
								</td>
							</tr>
						</table>
					</s:form>
				</td>
			</tr>
		</table>
	</body>
</html>