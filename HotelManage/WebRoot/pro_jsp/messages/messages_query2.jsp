<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<html>
		<head>
			<base href="<%=basePath%>">
			<title>Query</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">

		<script type="text/javascript">
			function toPage(pageNum){
				var url = "messages/messages_query.do?curPage="+pageNum;
				self.location.href = encodeURI(url);
			}
		</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：查看客人留言</div>
			<div class="pageColumn">
			
			<c:choose>
			<c:when test="${empty result}">
			</c:when>
			<c:otherwise>
			<table>
				<thead>
					
					<th>
						序号
					</th>
					<th>
						标题
					</th>
					
					<th>
						客人姓名
					</th>
					<th>
						日期
					</th>
					<th>
						内容
					</th>
					</thead>
				<tbody>
				<c:forEach items="${result}" var="record" varStatus="status">
				<tr>
					<td>
						${status.index+1 }
					</td>
					<td>
						${record.title }
					</td>
					
					<td>
						${record.userid }
					</td>
					<td>
						${record.messagedate }
					</td>
					<td>
						${record.content }
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
			
			</div></div></div>
		</body>
	</html>
