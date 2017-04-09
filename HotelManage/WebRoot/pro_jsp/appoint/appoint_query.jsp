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
				var url = "appoint/appoint_query.do?curPage="+pageNum;
				self.location.href = encodeURI(url);
			}
		</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：查询预定</div>
			<div class="pageColumn">
			<form id="searchForm" name="searchForm" action="appoint/appoint_query.do" method="post">
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
						序号
					</th>
					<th>
						客人姓名
					</th>
					<th>
						身份证号 
					</th>
					
					<th>
						入住时间
					</th>
					<th>
						退房时间
					</th>
					<th>
						状态
					</th>
					<th>
						联系方式
					</th>
					<th>
						备注
					</th>
					<th>
						操作
					</th>
					</thead>
				<tbody>
				<c:forEach items="${result}" var="record" varStatus="status">
				<tr>
					<td class="checkBox">
					<input name="id" type="checkbox" value="${record.id }" />
					</td>
					<td>
						${status.index+1 }
					</td>
					<td>
						${record.custname }
					</td>
					<td>
						${record.identityid }
					</td>
					
					<td>
						${record.begintime }
					</td>
					<td>
						${record.endtime }
					</td>
					<td>
						${record.status }
					</td>
					<td>
						${record.phone }
					</td>
					<td>
						${record.remarks }
					</td>
						<td>
							<img title="修改" src="<%=basePath%>/sys_css/icon/edit2.png" width="16" height="16" onclick="mdy('<%=basePath%>/appoint/appoint_modify.do?id=${record.id}')"/>
							<img title="删除" src="<%=basePath%>/sys_css/icon/del.png" width="16" height="16" onclick="del('<%=basePath%>/appoint/appoint_del.do?id=${record.id}')"/>
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
				&nbsp;<img title="删除" src="<%=basePath%>/sys_css/icon/del.png" width="16" height="16" onclick="dels('<%=basePath%>/appoint/appoint_dels.do')"/>
			</div>
			</div></div></div>
		</body>
	</html>
