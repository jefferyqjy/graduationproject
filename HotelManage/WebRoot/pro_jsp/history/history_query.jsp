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
				var url = "history/history_query.do?curPage="+pageNum;
				self.location.href = encodeURI(url);
			}
		</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：查询入住历史记录</div>
			<div class="pageColumn">
			<form id="searchForm" name="searchForm" action="history/history_query.do" method="post">
				<input name="Submit" type="submit" class="bt" value="查询" />
			</form>
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
						房间号
					</th>
					
					<th>
						姓名
					</th>
					<th>
						身份证号
					</th>
					<th>
						备注
					</th>
					<th>
						入住时间
					</th>
					<th>
						退房时间
					</th>
					<th>
						总费用
					</th>
					
					</thead>
				<tbody>
				<c:forEach items="${result}" var="record" varStatus="status">
				<tr>
					
					<td>
						${status.index+1 }
					</td>
					
					<td>
						${record.roomid }
					</td>
					
					<td>
						${record.custid }
					</td>
					<td>
						${record.identityid }
					</td>
					<td>
						${record.remarks }
					</td>
					<td>
						${record.begintime }
					</td>
					<td>
						${record.endtime }
					</td>
					<td>
						${record.totalprice }
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
