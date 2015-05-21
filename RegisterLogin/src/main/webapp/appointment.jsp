<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>LabIdeas For Researchers</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet"
	media="screen">


</head>
<body style="padding-top: 50px;">
	<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#"><span
							class="glyphicon glyphicon-home"> Home</span></a></li>
					<li><a href="#shop"><span
							class="glyphicon glyphicon-shopping-cart"> Shop</span></a></li>
					<li><a href="#support"><span
							class="glyphicon glyphicon-headphones"> Support</span></a></li>
				</ul>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div style="height: 960px;" class="container">
	<table class="table table-bordered">
		<caption>边框表格布局</caption>
		<thead>
			<tr>
				<th>名称</th>
				<th>城市</th>
				<th>密码</th>
				<th>名称</th>
				<th>城市</th>
				<th>密码</th>
				<th>名称</th>
				<th>城市</th>
				<th>密码</th>
				<th>名称</th>
				<th>城市</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<tr id="tr1">
				<td id="td1" onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
				<td onclick="bgcolorToggle(this)">&nbsp&nbsp&nbsp&nbsp</td>
			</tr>
			<tr>
				<td>Sachin</td>
				<td>Mumbai</td>
				<td >400003</td>
				<td>Sachin</td>
				<td>Mumbai</td>
				<td>400003</td>
				<td>Sachin</td>
				<td>Mumbai</td>
				<td>400003</td>
				<td>Sachin</td>
				<td>Mumbai</td>
				<td>400003</td>
			</tr>
			<tr>
				<td>Uma</td>
				<td>Pune</td>
				<td>411027</td>
				<td>Uma</td>
				<td>Pune</td>
				<td>411027</td>
				<td>Uma</td>
				<td>Pune</td>
				<td>411027</td>
				<td>Uma</td>
				<td>Pune</td>
				<td>411027</td>
			</tr>
		</tbody>
	</table>
	<button class="btn btn-primary" onclick="appointmentTime()" >提交预约</button>
	
</div>
	<!-- 超大屏幕 -->
	<div class="jumbotron" style="margin-bottom: 0px; margin-top: 30px; background-color: #222;">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<ul>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>

					</ul>
				</div>
				<div class="col-md-3">
					<ul>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<ul>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<ul>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>
						<li><a>公司简介</a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 超大屏幕 -->
	
	
	
	
	
	

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/appointment.js"></script>
	<!--  <script src="bootstrap/js/myjs.js"></script> -->
	
</body>
</html>
