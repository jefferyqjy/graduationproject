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
				<table class="mobile" style="width: 95%;">
					<tr class="pageheader">
						<td colspan="2">
							<strong>课程管理</strong>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							课程名称：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.kcName }" name="kcName"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							专业：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.zy }" name="zy"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							是否选修：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<select name="sfxu">
									<option value="男" ${bean.sfxu=='是'?'selected':'' }>是</option>
									<option value="女" ${bean.sfxu=='否'?'selected':'' }>否</option>
								</select>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							上课时间：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.sksj }" name="sksj"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							上课老师：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.skls }" name="skls"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							上课地点：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.skdd }" name="skdd"/>
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