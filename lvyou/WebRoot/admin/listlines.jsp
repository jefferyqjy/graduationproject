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
								旅游线路信息列表
							</td>
						</tr>
						<tr align="center">
							<td align="center" bgcolor="#ebf0f7">
								线路名称
							</td>
							<td align="center" bgcolor="#ebf0f7">
								线路类型
							</td>
							<td align="center" bgcolor="#ebf0f7">
								图片
							</td>
							<td align="center" bgcolor="#ebf0f7">
								单价
							</td>
							<td align="center" bgcolor="#ebf0f7">
								是否推荐
							</td>
							<td align="center" bgcolor="#ebf0f7">
								是否特价
							</td>
							<td align="center" bgcolor="#ebf0f7">
								操作
							</td>
						</tr>
						<s:iterator value="list" id="list">
							<tr align="center" bgcolor="#FFFFFF">
								<td align="center">
									<s:property value="linename" />
								</td>
								<td align="center">
									<s:property value="cate.catename" />
								</td>
								<td align="center">
									<img src="<s:property value="image" />" alt="" width="100" height="100"/>
								</td>
								<td align="center">
									<s:property value="price" />
								</td>
								<td align="center">
									<s:property value="recommend" />
								</td>
								<td align="center">
									<s:property value="special" />
								</td>
								<td align="center">
									【
									<s:a href="lines/getLinesById.action?id=%{linesid}">编辑</s:a>
									】|【
									<s:a href="lines/deleteLines.action?lines.linesid=%{linesid}"
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