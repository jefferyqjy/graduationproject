<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
<body>
	<display:table name="list" requestURI="list.html" class="list" id="row"
		cellspacing="0" cellpadding="0" pagesize="5">
		<display:column style="width: 60px;" media="html" title="编号">
			<c:out value="${row_rowNum}" />
		</display:column>
		<display:column title="课程名称">${row.kcName }</display:column>
		<display:column title="专业">${row.zy }</display:column>
		<display:column title="是否选修">${row.sfxu }</display:column>
		<display:column title="上课时间">${row.sksj }</display:column>
		<display:column title="上课老师">${row.skls }</display:column>
		<display:column title="上课地点">${row.skdd }</display:column>
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
		var params = {
			id : id
		};
		$.post("editDelete.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.parent.form1.submit();
			}
		});
	}
	function modifyOne(id) {
		MyWindow.OpenCenterWindow('edit.html?id=' + id, 'modifyOld', 500, 600);
	}
</script>
</html>