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
			var url = "message/message_query2.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
	</script>
		
	</head>

	<body id="page">
		<div id="contentWrap">
  		<div id="widget table-widget">
  		<div class="pageTitle">当前位置：留言板</div>
  		<div class="pageColumn">	
		<c:choose>
		<c:when test="${empty result}">
		</c:when>
		<c:otherwise>
		<table>
			<thead>
				<th>
					标题
				</th>
				<th>
					内容
				</th>
			</thead>
			<tbody>
			<c:forEach items="${result}" var="record">
			<tr>
				<td>
					<a style="cursor: pointer;color: blue" onclick="viewDetail('<%=basePath%>/message/message_detail.do?id=${record.id}')">${record.title }</a>
				</td>
				<td>
					<textarea rows="2" cols="30">${record.content }</textarea>
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
		</div>
		</div>
		</div>
	</body>
</html>
