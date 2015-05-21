<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/register.css" rel="stylesheet">
<title>add Facility</title>

</head>
<body style="padding-top: 70px;">

	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>

	<div class="container" style="height: 500px;">

		<form class="form-register" action="addFacility.action" method="post"
			enctype="multipart/form-data">
			<h2 class="form-register-heading">Add Facility</h2>
			<br> <label for="keeperId" class="sr-only">KeeperId</label> <input
				type="hidden" id="keeperId" class="form-control"
				name="facility.keeperId"
				value="<s:property value="#session.admin.id"/>"
				placeholder="keeperId" required autofocus> <br> <label
				for="facilityName" class="sr-only">FacilityName</label> <input
				type="text" id="facilityName" class="form-control"
				name="facility.facilityName" placeholder="facilityName" required>
			<br> <label for="picture" class="sr-only">picture</label> <input
				type="file" id="picture" class="form-control" name="some" required>
			<br> <label for="introduction" class="sr-only">introduction</label>
			<textarea  id="introduction" class="form-control"
				name="facility.introduction" placeholder="introduction" required></textarea>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form>

	</div>
	<!-- /container -->

	
		<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>