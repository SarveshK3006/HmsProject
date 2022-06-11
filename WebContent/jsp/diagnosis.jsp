<%@page import="com.sarvesh.hms.dao.DbConnection"%>
<%@page import="com.sarvesh.hms.dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="../css/docdash.css">
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
	
	
	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  
	

<script type="text/javascript">
	function addRow(tableID,name) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var colCount = table.rows[0].cells.length;

		for (var i = 0; i < colCount; i++) {

			var newcell = row.insertCell(i);
			console.log(newcell)

			newcell.innerHTML = table.rows[0].cells[i].innerHTML;
			console.log(newcell.childNodes[0],"LL")
			switch (newcell.childNodes[0].type) {
			case "text":
				newcell.childNodes[0].value = "";
				newcell.childNodes[0].name = name+i;
				break;
			case "checkbox":
				newcell.childNodes[0].checked = false;
				break;
			case "select-one":
				newcell.childNodes[0].selectedIndex = 0;
				break;
			}
		}
	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					if (rowCount <= 1) {
						alert("Cannot delete all the rows.");
						break;
					}
					table.deleteRow(i);
					rowCount--;
					i--;
				}

			}
		} catch (e) {
			alert(e);
		}
	}
	
	
	function submit() {

		var per = document.querySelectorAll("#dataTable input[type=text]");
		var test = document.querySelectorAll("#dataTableTest input[type=text]");
		var pres = "prescription:";
		var tests="test:";
		var remark = document.getElementById("rem").value;
		var patientid=document.getElementById("patientid").value;
		var doctorid=document.getElementById("docid").value;
		
		alert(doctorid);
		
		alert(remark);
		for (var i = 0; i < per.length; i++) {
			pres=pres+"@"+ per[i].value
		
		}
		for (var i = 0; i < test.length; i++) {
			tests=tests+"@"+ test[i].value
		
		}
	
		
		 
	$.ajax({
			url : '../PrescriptionServlet',
			data : {
				pre: pres,
				test : tests,
				remark:remark,
				doctorid:doctorid,
				patientid:patientid,
				appoId:document.getElementById("appoId").value
			},
			type : 'post',
			 dataType:'json',
			cache : false,
			success : function(data) {
				alert("Booking Done Sucessfully !!!");
				// $('#somediv').text(responseText); 
			},
			error : function() {
				alert('error');
			}
		});

		console.log(pres)
	}
</script>
</head>

<body onload="load()">
	<% DbConnection con =  new DbConnection(); %>
  	<% String id =  request.getParameter("id"); %>
  		<% String appoId =  request.getParameter("appoId"); %>
   <%  String doctorid = request.getParameter("docid"); %>
	<% Patient patient =  con.getPatientDetails(id); %>

<input type="hidden" id="patientid" value = <%=id %>>
<input type="hidden" id="docid" value=<%=doctorid %>>
<input type="hidden" id="appoId" value=<%=appoId %>>
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
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">person</i><%= patient.getFirstName() + " " + patient.getLastName() %>
					</p>
					<p>
						<i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i><%=patient.getAddress() %>

					</p>
					<p>
						<i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i><%=patient.getDob() %>

					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">bloodtype</i><%=patient.getBloodGroup() %>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">call</i><%=patient.getPhoneNo() %>
					</p>
					<p>
						<i
							class="material-symbols-outlined fa-fw w3-margin-right w3-text-theme">mail</i><%=patient.getEmailId() %>
					</p>

				</div>
			</div>
		</div>



		<div class="middle-container">
			<fieldset>
				<legend>Test</legend>
				<INPUT type="button" value="Add Row" onclick="addRow('dataTable','pre')" />
				<INPUT type="button" value="Delete Row"
					onclick="deleteRow('dataTable')" />



				<TABLE id="dataTable" width="350px" border="1">
					<TR>
						<TD><INPUT type="checkbox" name="chk" /></TD>
						<TD><INPUT type="text" name="pre1" size="60" placeholder="Prescription"></TD>
					</TR>
				</TABLE>
			</fieldset>


		</div>
		<div class="middle-container" style="width: 30% !important">
			<fieldset>
				<legend>Test</legend>
				<INPUT type="button" value="Add Row"
					onclick="addRow('dataTableTest','test')" /> 
					<INPUT type="button"
					value="Delete Row" onclick="deleteRow('dataTableTest')" />



				<TABLE id="dataTableTest" width="350px" border="1">
					<TR>
						<TD><INPUT type="checkbox" name="chk" /></TD>
						<TD><input type="text" name="test1" size="30" placeholder="Prescription" ></TD>
					</TR>
				</TABLE>
			</fieldset>

		</div>


	</div>

	<div class="bottom-container ">

		<fieldset>
			<legend>Remark</legend>
			<textarea id="rem" rows="4" cols="135"></textarea>
            
			<div>
				<button  onclick="submit()" class="button">submit</button>
			</div>

		</fieldset>

	</div>
</body>

</html>