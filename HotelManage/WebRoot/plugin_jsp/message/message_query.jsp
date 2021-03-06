<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Query</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function toPage(pageNum){
			var url = "message/message_query.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
	</script>
		
	</head>

	<body id="page">
		<div id="contentWrap">
  		<div id="widget table-widget">
  		<div class="pageTitle">当前位置：留言板</div>
  		<div class="pageColumn">	
  		<form id="searchForm" name="searchForm" action="message/message_query.do" method="post">
			标题：<input type="text" name="title">
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<c:choose>
		<c:when test="${empty result}">
		</c:when>
		<c:otherwise>
		<table>
			<thead>
				<th width="25">
					<input class="select-all" name="" type="checkbox" value="" />
				</th>
				<th>
					编号
				</th>
				<th>
					标题
				</th>
				<th>
					内容
				</th>
				<th>
					发布时间
				</th>
				<th>
					发布人
				</th>
				<th>
					执行操作
				</th>
			</thead>
			<tbody>
			<c:forEach items="${result}" var="record">
			<tr>
				<td class="checkBox">
					<input name="id" type="checkbox" value="${record.id }" />
				</td>
				<td>
					<a style="cursor: pointer;color: blue" onclick="viewDetail('<%=basePath%>/message/message_detail.do?id=${record.id}')">${record.id }</a>
				</td>
				<td>
					${record.title }
				</td>
				<td>
					<textarea rows="2" cols="30">${record.content }</textarea>
				</td>
				<td>
					${record.datetime }
				</td>
				<td>
					${record.username }
				</td>
				<td>
					<img title="删除" src="<%=basePath%>/sys_css/icon/del.png" width="16" height="16" onclick="del('<%=basePath%>/message/message_del.do?id=${record.id}')"/>
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:otherwise>
		</c:choose>
		<div class="pageButton">
				${pageInfo }
		</div>
		<div>
			&nbsp;<img title="删除" src="<%=basePath%>/sys_css/icon/del.png" width="16" height="16" onclick="dels('<%=basePath%>/message/message_dels.do')"/>
		</div>
		</div>
		</div>
		</div>
	</body>
</html>
