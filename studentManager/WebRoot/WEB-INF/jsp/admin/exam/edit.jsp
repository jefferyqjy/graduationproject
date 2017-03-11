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
							<strong>学生考试信息管理</strong>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							学生：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<select name="studentId">
									<c:forEach items="${studentList }" var="studentLists">
										<option value="${studentLists.id }" ${bean.studentId==studentLists.id?'selected':'' }>${studentLists.studentName }</option>
									</c:forEach>
								</select>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							课程：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<select name="kcId">
									<c:forEach items="${kcList }" var="kcLists">
										<option value="${kcLists.id }" ${bean.kcId==kcLists.id?'selected':'' }>${kcLists.kcName }</option>
									</c:forEach>
								</select>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							考试名称：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.examName }" name="examName"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							考试时间：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.examDate }" name="examDate"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							监考老师：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.jkls }" name="jkls"/>
						</td>
					</tr>
					<tr height="25">
						<td class="outDetail" style="width: 30%">
							分数：
							<label style="font-weight: bold; color: red">
								*
							</label>
						</td>
						<td class="outDetail2">
								<input type="text" value="${bean.code }" name="code"/>
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
</script>
</html>