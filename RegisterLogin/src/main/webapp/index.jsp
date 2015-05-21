<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/RegisterLogin/css/bootstrap.min.css" rel="stylesheet">
<link rel="icon" href="/RegisterLogin/images/favicon.ico">
<title>index.jsp</title>

</head>
<body>
	<!-- 导航条 -->
	<%@ include file="jspf/navigation.jspf"%>

	<!-- 幻灯片 -->
	<%@ include file="jspf/carousel.jspf"%>
	<!-- 缩略图 -->
	<%@ include file="jspf/thumbnail.jspf"%>
	<hr>
	<div class="container">
		<div>
			<a href="user/toAddUser.action">add User</a>
		</div>
		<hr>
		<div>
			<a href="user/selectUserList.action">select User List</a>
		</div>
		<hr>
	</div>

		<!-- 页脚 -->
	<%@ include file="jspf/footer.jspf"%>
	<script src="/RegisterLogin/js/bootstrap.min.js"></script>

</body>
</html>