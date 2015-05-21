<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function deleteAffiche(id) {
		var r = window.confirm("are you sure? " + id);
		if (r) {
			window.location.href = "deleteUser?id=" + id;
		}
	}
</script>
<title>LabIdeas for Researchers</title>
</head>
<body>
	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>
	<br>
	

	<div class="container" style="text-align: center;">
		<table class="table table-bordered">
			<tr style="font-weight: bold;background-color: #ccc;">
				<td>facilityId</td>
				<td>appointDate</td>
				<td>startTime</td>
				<td>endTime</td>
				<td>operate</td>
			</tr>
			<s:iterator value="scheduleList">
				<tr>
					<td><s:property value="facilityId" /></td>
					<td><s:property value="startTime.substring(0,10)" /></td>
					<td><s:property value="startTime.substring(11)" /></td>
					<td><s:property value="endTime.substring(11)" /></td>
					<td><button type="button" onclick="location.href='toModifySchedule.action?id=<s:property value="id" />'">modify</button>
					<button type="button" onclick="location.href='toDeleteSchedule.action?id=<s:property value="id" />'">delete</button>(undo)</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<hr>
	
	
	<div class="container">
		<div class="row">
			<s:iterator value="facilitySet" status="st">
			
				<div class="col-sm-6 col-md-4" style="text-align: justify; height: 450px; overflow: hidden;">
					<div style="position: relative;height: 40px; ">
						<p >
							<span style="float: left;"><a href="#" class="btn btn-primary" role="button" > 我要咨询
							</a></span></p>
						<p >	<span style="float: right;"><a href="../schedule/toAddSchedule.action?facilityId=<s:property value="id" />" class="btn btn-primary" role="button" > 我要预约
							</a></span>
						</p>
					</div>
				
					<div class="thumbnail">
						<a href="../facility/selectFacilityById.action?id=<s:property value="id" />"><img src="/ScienceBridge/upload/<s:property value="picture" />"
							alt="通用的占位符缩略图"></a>
					</div>
					<div class="caption"  style="text-align: justify;">
						<h3>
							<s:if test="facilityName.length()<=20">
								<a href="../facility/selectFacilityById.action?id=<s:property value="id" />"><s:property value="facilityName" /></a>
							</s:if>
							<s:else>
								<a href="../facility/selectFacilityById.action?id=<s:property value="id" />"><s:property value="facilityName.substring(0,20)" />...	</a></s:else>
						</h3>
						<p>
							<a href="../facility/selectFacilityById.action?id=<s:property value="id" />"><s:property value="introduction" /></a>
						</p>

					</div>
				
				</div>
				
			</s:iterator>
		</div>
	</div>



	<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>