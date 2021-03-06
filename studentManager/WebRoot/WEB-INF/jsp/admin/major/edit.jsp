<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/easy_validator.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.bgiframe.min.js"></script>
	<script type="text/javascript" src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<link href="${ctx}/css/validate.css" rel="stylesheet" type="text/css" />
<html>
	<head>
		<title>信息内容功能</title>
	</head>
	<body>
		<form id="form1" name="form1" action=""
			method="post">
			<input type="hidden" value="${bean.id }" name="id" id="id" />
			<center>
				<table class="mobile" style="width: 95%;" border="1" >
					<tr class="pageheader">
						<td colspan="2">
							<strong>专业管理</strong>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							专业名称：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.majorName }" name="majorName"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							隶属学院：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<select name="deptId">
									<c:forEach items="${deptList }" var="deptLists">
										<option value="${deptLists.id }" ${bean.deptId==deptLists.id?'selected':'' }>${deptLists.deptName }</option>
									</c:forEach>
								</select>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							专业人数：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.studentNum }" name="studentNum"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							专业简介：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<textarea rows="4" name="introduce" >${bean.introduce }</textarea>
						</td>
					</tr>
				</table>
			</center>
			<p align="center">
				<br>
					<input type="button" class="btn" value="保  存" onclick="save(this);" />
				<input type="button" class="btn" value="关  闭"
					onclick="window.close();" />
			</p>
		</form>
	</body>
	<script type="text/javascript">
	function save(src) {
		$.post("editSave.html",$("#form1").serializeArray(),
		       function(result){
		        	result = eval("("+result+")");
		    		if(result.status == "true" || result.status == true){
		    			alert('成功');
		    			saveAnd();
		    		}else{
		    			alert('保存失败，请重试');
		    		}
		        }
			);
		
	}

	function triggerUpload(src) {
			$.ajaxFileUpload({
				url : '${ctx}/file/upload.json',
				secureuri : false,
				fileElementId : 'f_file',
				dataType : 'json',
				data : {
					fileloc : 'upload/',
					dir : 'temp'
				},
				success : function(data, status) {
					$("input[name='imgUrl']").val(data.data.filepath);
					$("#imgUrlShow").attr("src","${ctx}/"+data.data.filepath+"");
				},
				error : function(data, status, e) {
					alert('文件上传失败');
				}
			});
		}
</script>
</html>