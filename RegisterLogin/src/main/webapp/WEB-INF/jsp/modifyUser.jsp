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
<script type="text/javascript">
	function updateUser() {
		var userId = $('form input[type=hidden]').val();
		
		var username = $('form input[type=email]').val();
		var password = $('form input[type=password]').val();
		alert(userId +";"+username+";"+password);
		$.ajax({
            url : "modifyUser.action?user.id=" + userId + "&user.username=" + username + "&user.password=" + password,
            type : "post",
            dataType : "json",
            success : function(data) {
                $('.alert-info h3').text(data.result);
                $('.alert-info').show();
            },
            error : function() {
                alert("error");
            }
        });
		return false;
	}
</script>

</head>

<body >
	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>
	<div class="container alert alert-info" style="display: none;text-align: center;font-weight: bold;">
		<h3></h3>
	</div>
	<div class="container" style="height: 500px;">

		<form class="form-register" >
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
			<button class="btn btn-lg btn-primary btn-block" type="button" onclick="return updateUser()">Update</button>
		</form>

	</div>
	<!-- /container -->

	
	
		<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
