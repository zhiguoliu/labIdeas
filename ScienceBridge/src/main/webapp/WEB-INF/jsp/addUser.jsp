<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/register.css" rel="stylesheet">
<title>add User</title>

</head>
<body style="padding-top: 70px;">

	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>
	
	<div class="container">

      <form class="form-register" action="addUser.action" method="post">
        <h2 class="form-register-heading">Sign up</h2>
        <br>
        <label for="inputEmail" class="sr-only">UserName</label>
        <input type="email" id="inputEmail" class="form-control" name="user.username" placeholder="Email address" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="user.password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
      </form>

    </div> <!-- /container -->
	
	
		<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>