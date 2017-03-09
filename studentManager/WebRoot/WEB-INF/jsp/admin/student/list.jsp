<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
		<display:table name="list"
			requestURI="list.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="4">
			<display:column style="width: 60px;" media="html" title="编号">
				<c:out value="${row_rowNum}" />
			</display:column>
			<display:column title="姓名">${row.studentName }</display:column>
		<display:column title="学号">${row.studentNo }</display:column>
		<display:column title="年龄">${row.age }</display:column>
		<display:column title="性别">${row.sex }</display:column>
		<display:column title="住址">${row.address }</display:column>
		<display:column title="手机号">${row.mobile }</display:column>
		<display:column title="班级">${row.classdd.className }</display:column>
		<display:column title="班主任">${row.classdd.classMan }</display:column>
			<display:column title="修改" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return modifyOne('${row.id}');" style="cursor: hand;" />
			</display:column>
			<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor: hand;" />
			</display:column>
		</display:table>
	</body>
	<script type="text/javascript">
	function deleteOne(id) {
		if (!confirm("确定要删除吗？")) {
			return false;
		}
		var params = {id:id};
		$.post("editDelete.html", params, function(
				result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
		    	window.parent.form1.submit();
			}
		});
	}
	function modifyOne(id){
			MyWindow.OpenCenterWindow('edit.html?id='+id,'modifyOld',500,600);
	}
</script>
</html>