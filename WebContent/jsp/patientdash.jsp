<%@page import="com.sarvesh.hms.dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="./css/patientdash.css">
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

<body>
	<% Patient patient = (Patient)request.getAttribute("patient"); %>


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
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">person</i><%= patient.getFirstName() +" " +patient.getLastName() %>
					</p>
					<p>
						<i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i><%= patient.getAddress() %>
						
					</p>
					<p>
						<i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i><%= patient.getDob() %>
				
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">bloodtype</i><%= patient.getBloodGroup() %>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">call</i><%= patient.getPhoneNo() %>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">mail</i><%= patient.getEmailId() %>
					</p>

				</div>
			</div>




		</div>
		<div class="right-container">

			<div class="w3-card w3-round w3-white">
				<table>
					<tr>
						<th>Id</th>
						<th>Appointment</th>
						<th>Doctor Name</th>
						<th>Diagnosis</th>
					</tr>
					<tr>
						<td>Alfreds Futterkiste</td>
						<td>Maria Anders</td>
						<td>Germany</td>
						<td>hitler</td>
					</tr>
					<tr>
						<td>Alfreds Futterkiste</td>
						<td>Maria Anders</td>
						<td>Germany</td>
						<td>hitler</td>
					</tr>
					<tr>
						<td>Alfreds Futterkiste</td>
						<td>Maria Anders</td>
						<td>Germany</td>
						<td>hitler</td>
					</tr>
					<tr>
						<td>Alfreds Futterkiste</td>
						<td>Maria Anders</td>
						<td>Germany</td>
						<td>hitler</td>
					</tr>
					<tr>
						<td>Alfreds Futterkiste</td>
						<td>Maria Anders</td>
						<td>Germany</td>
						<td>hitler</td>
					</tr>
				</table>
			</div>
		</div>

	</div>
	<br>

	<div class="lower">
		<div class="w3-card w3-round w3-white" style="padding: 28px">
			<form action="patientservlet" id="ft-form" method="POST"
				accept-charset="UTF-8">
				<fieldset>
					<legend class="w3-text-theme">Book an appointment</legend>
					<div class="two-cols">
						<label class="w3-text-theme"> Doctor Name </label> <select
							name="drs" id="cars" form="carform">
							<option value="volvo">Dr.RAM</option>
							<option value="saab">Dr.Shyam</option>
							<option value="opel">Dr.Om</option>
							<option value="audi">Dr.Rahul</option>
						</select> <label class="w3-text-theme"> Date & Time <input
							type="datetime-local" class="w3-text-theme"
							name="Appointment request" required>
						</label> <input type="text" class="w3-text-theme" name="_gotcha" value=""
							style="display: none;"> <input type="submit"
							class="submit-button" value="Submit Request">

					</div>
				</fieldset>


			</form>
		</div>
	</div>



</body>
</html>