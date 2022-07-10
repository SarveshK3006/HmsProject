<%@page import="com.sarvesh.hms.dto.AppointmentDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.sarvesh.hms.dto.Patient"%>
<%@page import="com.sarvesh.hms.dto.Doctor"%>
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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script>
  
  function load() {
	  var today = new Date();
	  var dd = today.getDate()+1;
	  var mm = today.getMonth() + 1; //January is 0!
	  var yyyy = today.getFullYear();
	  if (dd < 10) {
	    dd = '0' + dd
	  }
	  if (mm < 10) {
	    mm = '0' + mm
	  }

	  today = yyyy + '-' + mm + '-' + dd;
	  document.getElementById("date").setAttribute("min", today);
}

  function myFunction() {
	  let e =  document.getElementById("docs"); 
	  //alert(JSON.stringify(e.options[e.selectedIndex].value) )
	   
	let date  = document.getElementById("date").value; 
	  if(date!=null && typeof date!=='undefined' && date.length>2){
	  
	  $.ajax({
	      url:'BookAppoint',
	      data:{petientId: document.getElementById("petientId").value,
	    	  datetime:document.getElementById("date").value ,
	    	  doc: e.options[e.selectedIndex].value,
	    	  timeslot:document.getElementById("timeslot").value
	    	  },
	      type:'post',
	      cache:false,
	      success:function(data){
	         alert("Booking Done Sucessfully !!!");
	         location.reload();
	        // $('#somediv').text(responseText); 
	      },
	      error:function(){
	        alert('error');
	      }
	      
	   }
	);   
	  }else{
		  alert("Please Select Appropriat Date")
	  }
	  
}


	function Download(id) {

		$.ajax({
			url : 'PrescriptionLetter',
			data : {
				diag : id
			},
			type : 'post',
			cache : false,
			success : function(data) {
				//alert("Booking Done Sucessfully !!!");
			},
			error : function() {
				alert('error');
			}
		});

	}
</script>

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
	<%
		Patient patient = (Patient) request.getAttribute("patient");
	%>
	<%
		List<Doctor> list = (List<Doctor>) request.getAttribute("doctor");
	%>
	<%
		List<AppointmentDetails> details = (List<AppointmentDetails>) request.getAttribute("details");
	%>



	<div class="topnav">
		<a class="active" href="#home">Home</a> <a href="#contact">Contact</a>
		<a href="#">About</a> <a href="http://localhost:8080/HMSproj/" class="notification"> <span>Log Out</span>
			
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
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">person</i><%=patient.getFirstName() + " " + patient.getLastName()%>
					</p>
					<p>
						<i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i><%=patient.getAddress()%>

					</p>
					<p>
						<i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i><%=patient.getDob()%>

					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">bloodtype</i><%=patient.getBloodGroup()%>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">call</i><%=patient.getPhoneNo()%>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">mail</i><%=patient.getEmailId()%>
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
							<th>Appointment Date</th>
							<th>Doctor Name</th>
							<th>Diagnosis</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (AppointmentDetails ad : details) {
						%>
						<tr>
							<td><%=ad.getId()%></td>
							<td><%=ad.getDate() + " " + ad.getTimeSlot()%></td>
							<td><%=ad.getDoctorName()%></td>
							<%
								if (ad.getDiagnosis() != null) {
							%>
							<td><a href="${pageContext.request.contextPath}/PrescriptionLetter?diag=<%=ad.getDiagnosis()%>" >Download</a></td>
							<%
								} else {
							%>
							<td>NA</td>
							<%
								}
							%>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<br>

	<div class="lower">
		<div class="w3-card w3-round w3-white" style="padding: 28px">

			<fieldset>
				<legend class="w3-text-theme">Book an appointment</legend>
				<div class="two-cols">
					<label class="w3-text-theme"> Doctor Name </label> <select
						name="doc" id="docs">
						<%
							for (Doctor doc : list) {
						%>
						<option value=<%=doc.getId()%>>><%=doc.getFirstName() + " " + doc.getDegree()%></option>
						<%
							}
						%>
					</select> <label class="w3-text-theme"> <input type="date"
						class="w3-text-theme" id="date" name="datetime" required>
						<input type="hidden" id="petientId" value="<%=patient.getId()%>"
						name="petientId">
					</label> <label class="w3-text-theme"> Select Time </label> <select
						name="timeslot" id="timeslot">
						<option value="10am-11am">10am-11am</option>
						<option value="11am-12pm">11am-12pm</option>
						<option value="12pm-1pm">12pm-1pm</option>
						<option value="1pm-2pm">1pm-2pm</option>
						<option value="2pm-3pm">2pm-3pm</option>
						<option value="3pm-4pm">3pm-4pm</option>
						<option value="4pm-5pm">4pm-5pm</option>
					</select> <input type="text" class="w3-text-theme" name="_gotcha" value=""
						style="display: none;">

					<button class="submit-button" onclick="myFunction()">Book Appointment
				</button>


				</div>
			</fieldset>


		</div>
	</div>



</body>


</html>