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
				var url = "menu/menu_query.do?curPage="+pageNum;
				self.location.href = encodeURI(url);
			}
		</script>
		</head>

		<body id="page">
			<div id="contentWrap">
			<div id="widget table-widget">
			<div class="pageTitle">当前位置：查询菜单信息</div>
			<div class="pageColumn">
			<form id="searchForm" name="searchForm" action="menu/menu_query.do" method="post">
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
						菜编号
					</th>
					<th>
						菜名
					</th>
					<th>
						价格
					</th>
					<th>
						类型
					</th>
					<th>
						单位
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
						${record.id }
					</td>
					<td>
						${record.name }
					</td>
					<td>
						${record.price }
					</td>
					<td>
						${record.type }
					</td>
					<td>
						${record.unit }
					</td>
					<td>
						<img title="修改" src="<%=basePath%>/sys_css/icon/edit2.png" width="16" height="16" onclick="mdy('<%=basePath%>/menu/menu_modify.do?id=${record.id}')"/>
						<img title="删除" src="<%=basePath%>/sys_css/icon/del.png" width="16" height="16" onclick="del('<%=basePath%>/menu/menu_del.do?id=${record.id}')"/>
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
				&nbsp;<img title="删除" src="<%=basePath%>/sys_css/icon/del.png" width="16" height="16" onclick="dels('<%=basePath%>/menu/menu_dels.do')"/>
			</div>
			</div></div></div>
		</body>
	</html>
