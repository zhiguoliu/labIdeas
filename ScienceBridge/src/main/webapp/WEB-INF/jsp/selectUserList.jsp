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
	<br>

	<div class="container">
		<table>
			<tr>
				<td>id</td>
				<td>keeperId</td>
				<td>facilityName</td>

			</tr>
			<s:iterator value="facilitySet">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="keeperId" /></td>
					<td><s:property value="facilityName" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<hr>
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

	<div class="container">
		<table>
			<tr>
				<td>id</td>
				<td>username</td>
				<td>password</td>
				<td>facilities</td>
				<td>modify</td>
				<td>delete</td>
			</tr>
			<s:iterator value="userList">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="username" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="facilities.size() " /></td>

					<td><input type="button" value="修改"
						onclick="location.href='toModifyUser?id=<s:property value="id" />';" />
					</td>
					<td><input type="button" value="删除"
						onclick="location.href='deleteUser?id=<s:property value="id" />';" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	
	
	
	
	

	<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>