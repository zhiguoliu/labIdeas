<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>LabIdeas for Researchers</title>
</head>
<body>
	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>
	<br>

	<div class="container">
		<div style="position: relative; height: 40px;">
			<p>
				<span style="float: left;"><a href="#"
					class="btn btn-primary" role="button"> 我要咨询 </a></span>
			</p>
			<p>
				<span style="float: right;"><a
					href="../schedule/toAddSchedule.action?facilityId=<s:property value="id" />"
					class="btn btn-primary" role="button"> 我要预约 </a></span>
			</p>
		</div>
		<table class="table table-striped">
			<tr>
				<td>facility.id</td>
				<td>facility.keeperId</td>
				<td>facility.facilityName</td>
				<td>facility.picture</td>
				<td>facility.introduction</td>
			</tr>
			<tr>
				<td><s:property value="facility.id" /></td>
				<td><s:property value="facility.keeperId" /></td>
				<td><s:property value="facility.facilityName" /></td>
				<td><s:property value="facility.picture" /></td>
				<td><s:property value="facility.introduction" /></td>
				<td><button type="button" onclick="location.href=''">ddddddddd</button></td>
			</tr>

		</table>
	</div>
	<hr>



	<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>