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
		<script type="text/javascript" src="js/users.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/date.js" charset="utf-8"></script>
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
					<s:form action="users/addUsers.action" name="myform"
						onsubmit="return check()">
						<table width="40%" border="0" align="center" cellpadding="4"
							cellspacing="1" bgcolor="#aec3de">
							<tr align="center" bgcolor="#F2FDFF">
								<td align="left" colspan="2" class="optiontitle">
									添加系统用户
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									用户名
								</td>
								<td align="left">
									<input type="text" name="users.username" style="width: 160px"
										id="username" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									密码
								</td>
								<td align="left">
									<input type="password" name="users.password" style="width: 160px"
										id="password" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									姓名
								</td>
								<td align="left">
									<input type="text" name="users.realname" style="width: 160px"
										id="realname" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									性别
								</td>
								<td align="left">
									<input type="radio" name="users.sex" id="sex" value="男" checked="checked"/>男
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="users.sex" id="sex" value="女" />女
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									出生日期
								</td>
								<td align="left">
									<input type="text" name="users.birthday" style="width: 160px" readonly="readonly" onclick="setDay(this)"
										id="birthday" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									联系方式
								</td>
								<td align="left">
									<input type="text" name="users.contact" style="width: 160px"
										id="contact" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									联系地址
								</td>
								<td align="left">
									<input type="text" name="users.address" style="width: 160px"
										id="address" />
								</td>
							</tr>
							<tr align="center" bgcolor="#F2FDFF">
								<td width="20%" align="right">
									权限
								</td>
								<td align="left">
									<input type="radio" name="users.powers" id="powers" value="用户" checked="checked"/>用户
									&nbsp;&nbsp;
									<input type="radio" name="users.powers" id="powers" value="管理员" />管理员
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