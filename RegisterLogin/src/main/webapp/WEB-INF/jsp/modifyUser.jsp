<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/register.css" rel="stylesheet">
<link rel="icon" href="../images/favicon.ico">
<title>Setting</title>
</head>

<body >
	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>

	<div class="container" style="height: 500px;">

		<form class="form-register" action="modifyUser.action" method="post">
			<h2 class="form-register-heading">Setting</h2>
			<br>
			<input type="hidden" name="user.id" value="<s:property value="user.id" />" />
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input
				type="email" id="inputEmail" class="form-control" name="user.username"
				value="<s:property value="user.username" />" required autofocus> 
			<br>
			<label
				for="inputPassword" class="sr-only">Password</label> 
			<input
				type="password" id="inputPassword" class="form-control" name="user.password"
				value="<s:property value="user.password" />" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
		</form>

	</div>
	<!-- /container -->

	
	
		<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
