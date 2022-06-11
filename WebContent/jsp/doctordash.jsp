<%@page import="com.sarvesh.hms.dto.AppointmentDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.sarvesh.hms.dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="./css/docdash.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}
</style>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
</head>

<body onload="load()">

	<% Doctor doc = (Doctor)request.getAttribute("doctor"); %>

	<% List<AppointmentDetails> details = ( List<AppointmentDetails>) request.getAttribute("details"); %>

	<div class="topnav">
		<a class="active" href="#home">Home</a> <a href="#contact">Contact</a>
		<a href="#about">About</a> <a href="#" class="notification"> <span>Inbox</span>
			<span class="badge">1</span>
		</a>
	</div>

	<div class="container">
		<div class="left-container">
			<!-- Profile -->
			<div class="w3-card w3-round w3-white">
				<div class="w3-container">
					<h4 class="w3-center">My Profile</h4>

					<hr>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">person</i><%= doc.getFirstName() +" " +doc.getLastName() %>
					</p>
					<p>
						<i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i><%= doc.getAddress() %>

					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">stars</i><%= doc.getSpecialization() %>

					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">bloodtype</i><%= doc.getBloodGroup() %>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">call</i><%= doc.getPhoneNo() %>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">mail</i><%= doc.getEmailId() %>
					</p>

				</div>
			</div>




		</div>
		<div class="right-container">

			<div class="w3-card w3-round w3-white">
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Appointment Time</th>
							<th>Patient Name</th>
							<th>Diagnosis</th>
						</tr>

					</thead>
					<tbody>
						<% for( AppointmentDetails ad : details) { %>
						<tr>
							<td><%= ad.getId() %></td>
							<td><%=ad.getDate() + " " + ad.getTimeSlot() %></td>
							<td><%=ad.getPatientName() %></td>
							<td><a href="${pageContext.request.contextPath}/jsp/diagnosis.jsp?id=<%=ad.getPatientId()%>&docid=<%=ad.getDoctorId()%>&appoId=<%=ad.getId() %>"  >diganosis</a></td>
						</tr>
						<% } %>
					</tbody>

				</table>
			</div>
		</div>

	</div>

</body>

</html>