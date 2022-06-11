<%@page import="com.sarvesh.hms.dto.Tests"%>
<%@page import="com.sarvesh.hms.dto.Prescription"%>
<%@page import="com.sarvesh.hms.dto.PrescriptionDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/prescription.css">
<title>Insert title here</title>
</head>
<body>
	<% PrescriptionDetails details =(PrescriptionDetails) request.getAttribute("details"); %>

	<div class="container">
		<header class="row">
			<div class="col-10">
				<div class="doc-details">
					<p class="doc-name"><%= details.getDocrotName() %></p>
					<p class="doc-meta"><%=details.getDocDegree() %></p>

				</div>

				<div class="clinic-details">
					<p class="doc-meta">Shree Hospital</p>
					<p class="doc-meta">Nutan Road , Selu</p>
				</div>

			</div>
			<div class="col-2 datetime">
				<p>Date: 18/03/16</p>
				<p>Time: 03:13</p>
			</div>
		</header>
		<div class="prescription">
			<p style="margin-left: 15px; font-size: 10px; font-weight: bold;">
				Rx
				<%=details.getPatientName() %></p>
			<table style="padding:10px">
				<tr style="padding: 2px">
					<th></th>
					<th>Type</th>
					<th>Name of the drug</th>
					<th>Dosage</th>
					<th>Frequency</th>
					<th>Period</th>
				</tr>
				<%  int i=1; %>
				<% for(Prescription pre : details.getPrescriptions()){ %>
				<tr>
					<td style="padding: 2px"><%=i %></td>
					<td><%=pre.getDrugs() %></td>

				</tr>
				<%  i++; } %>

			</table >
			<br> <br>
			<table style="padding:10px">
				<tr   style="padding: 2px">
					
					<th>Recommended Tests</th>
				</tr>

				<% int j=1; %>
				<% for(Tests test : details.getTests() ){ %>
				<tr>

					<td>  <%=j %> . <%= test.getTests() %></td>
					<td></td>
					<td></td>
					<td></td>

				</tr>
				<% j++ ; }%>
			</table>

		</div>

		<p
			style="font-size: 9px; text-align: right; padding-bottom: 15px; padding-right: 25px;">Dr.Shrinivas
			Kulkarni</p>
	</div>

</body>
</html>