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
	<div class="container">
	<div><button class="btn btn-primary" type="button" onclick="location.href='toAddFacility.action'">addFacility</button><span>     </span>
	<input type="button"  value="addFacility" onclick="location.href='toAddFacility.action'" /></div>
	</div>
	<br>

	<div class="container">
		<table class="table">
			<tr>
				<td>id</td>
				<td>keeperId</td>
				<td>facilityName</td>
				<td>picture</td>
				<td>introduction</td>
				

			</tr>
			<s:iterator value="facilityList">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="keeperId" /></td>
					<td><s:property value="facilityName" /></td>
					<td><s:property value="picture" /></td>
					<td><s:property value="introduction" /></td>
					<td><button type="button" onclick="location.href='../schedule/toAddSchedule.action?facilityId=<s:property value="id" />'">addSchedule</button></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<hr>
	
	
	<div class="container">
		<div class="row">
			<s:iterator value="facilityList">
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
						<a href="selectFacilityById.action?id=<s:property value="id" />"><img src="/ScienceBridge/upload/<s:property value="picture" />"
							alt="通用的占位符缩略图"></a>
					</div>
					<div class="caption">
						<h3>
							<s:if test="facilityName.length()<=20">
								<a href="selectFacilityById.action?id=<s:property value="id" />"><s:property value="facilityName" /></a>
							</s:if>
							<s:else>
								<a href="selectFacilityById.action?id=<s:property value="id" />"><s:property value="facilityName.substring(0,20)" />...	</a></s:else>
						</h3>
						<p>
							<a href="selectFacilityById.action?id=<s:property value="id" />"><s:property value="introduction" /></a>
						</p>

					</div>
				
				</div>
			</s:iterator>
		</div>
	</div>
	
	
	
	<div class="container">
		<table>
			<tr>
				<td>id</td>
				<td>facilityId</td>
				<td>userId</td>
				<td>startTime</td>
				<td>endTime</td>
				
			</tr>
			<s:iterator value="scheduleSet">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="facilityId" /></td>
					<td><s:property value="userId" /></td>
					<td><s:property value="startTime" /></td>
					<td><s:property value="endTime" /></td>
					
				</tr>
			</s:iterator>
		</table>
	</div>
	<br><hr>



		<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>