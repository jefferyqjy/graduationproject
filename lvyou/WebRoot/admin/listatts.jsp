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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/four.css" rel="stylesheet" type="text/css" />
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
					<table width="96%" border="0" align="center" cellpadding="4"
						cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="20" class="optiontitle">
								景点信息列表
							</td>
						</tr>
						<tr align="center">
							<td align="center" bgcolor="#ebf0f7">
								景点名称
							</td>
							<td align="center" bgcolor="#ebf0f7">
								景点图片
							</td>
							<td align="center" bgcolor="#ebf0f7">
								点击数
							</td>
							<td align="center" bgcolor="#ebf0f7">
								操作
							</td>
						</tr>
						<s:iterator value="list" id="list">
							<tr align="center" bgcolor="#FFFFFF">
								<td align="center">
									<s:property value="name" />
								</td>
								<td align="center">
									<img src="<s:property value="image" />" alt="" width="100" height="100"/>
								</td>
								<td align="center">
									<s:property value="hits" />
								</td>
								<td align="center">
									【
									<s:a href="atts/getAttsById.action?id=%{attsid}">编辑</s:a>
									】|【
									<s:a href="atts/deleteAtts.action?atts.attsid=%{attsid}"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</s:a>
									】
								</td>
							</tr>
						</s:iterator>
						<tr align="right" bgcolor="#ebf0f7">
							<td colspan="20">
								&nbsp;${html}
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>