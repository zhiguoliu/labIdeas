<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Schedule</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<style type="text/css">
td {
	height: 40px;
}
</style>

</head>
<body>
	<!-- 导航条 -->
	<%@ include file="../../jspf/navigation.jspf"%>
	<br>
	<br>
	<div class="container" id="facilityId">
		<h3 style="color: red;"><s:property value="facilityId" /></h3>
	</div>
		<div class="container alert alert-info" style="text-align: center;display: none;">
		<table class="table table-bordered" id="tableForScheduleList">
			<tr style="font-weight: bold;background-color: #ccc;">
				<td>facilityId</td>
				<td>appointDate</td>
				<td>startTime</td>
				<td>endTime</td>
				<td>operate</td>
			</tr>
		</table>
	</div>
	<!--  <div class="container">
		<table class="table table-striped">
			<tr>
				<td>key</td>
				<td>value</td>
				<td>s:if</td>
			</tr>
			<s:iterator value="scheduleMap" id="column">
				<tr>
					<td><s:property value="key" /></td>
					<td><s:property value="value" /></td>
					<s:if test="value.contains(\"2\")">
						<td><s:property value="value" /></td>
					</s:if>
					<s:else>
						<td>12345</td>
					</s:else>
				</tr>
			</s:iterator>
		</table>
	</div>-->
<input type="hidden" id="userId" name="facility.userId" value="<s:property value="#session.admin.id"/>">
	<s:iterator begin="0" end="6" var="dayIndex">

		<div style="border: 2px solid #ccc; padding-top: 10px;"
			class="container">
			<span style="font-size: 20px; font-weight: bold;"
				id="appointmentDate"> <s:property
					value="daysStrings[#dayIndex]" />
			</span>
			<button class="btn btn-primary submitAppointment" 
				style="float: right; margin-bottom: 10px;" type="button">提交预约</button>
			<table class="table table-bordered" id="tab">

				<thead>
					<tr bgcolor="gray">
						<th colspan="2">00:00</th>
						<th colspan="2">01:00</th>
						<th colspan="2">02:00</th>
						<th colspan="2">03:00</th>
						<th colspan="2">04:00</th>
						<th colspan="2">05:00</th>
						<th colspan="2">06:00</th>
						<th colspan="2">07:00</th>
						<th colspan="2">08:00</th>
						<th colspan="2">09:00</th>
						<th colspan="2">10:00</th>
						<th colspan="2">11:00</th>

					</tr>
				</thead>
				<tbody>
					<tr id="tr1">
						<s:iterator begin="0" end="23" var="p">
							<s:if
								test='scheduleMap[daysStrings[#dayIndex]].contains(\",\"+#p+\",\")'>
								<td bgcolor="#00f"></td>
							</s:if>
							<s:else>
								<td></td>
							</s:else>
						</s:iterator>
					</tr>
					<tr id="tr1">
						<s:iterator begin="24" end="47" var="p">
							<s:if
								test='scheduleMap[daysStrings[#dayIndex]].contains(\",\"+#p+\",\")'>
								<td bgcolor="#00f"></td>
							</s:if>
							<s:else>
								<td></td>
							</s:else>
						</s:iterator>
					</tr>
				</tbody>
			</table>


		</div>

	</s:iterator>




		<!-- 页脚 -->
	<%@ include file="../../jspf/footer.jspf"%>
	<script src="/RegisterLogin/js/jquery.min.js"></script>
	<script src="/RegisterLogin/js/bootstrap.min.js"></script>
	<script src="/RegisterLogin/js/appointment.js"></script>
	<!--  <script src="bootstrap/js/myjs.js"></script> -->

</body>
</html>
