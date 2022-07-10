 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<!--=== Coding by CodingLab | www.codinglabweb.com === -->
<html lang="en">
<head>
<style>
#snackbar {
  visibility: hidden;
  min-width: 250px;
  margin-left: -125px;
  background-color: #333;
  color: #fff;
  text-align: center;
  border-radius: 2px;
  padding: 16px;
  position: fixed;
  z-index: 1;
  left: 50%;
  bottom: 30px;
  font-size: 17px;
}

#snackbar.show {
  visibility: visible;
  -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
  animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
  from {bottom: 0; opacity: 0;} 
  to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
  from {bottom: 0; opacity: 0;}
  to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
  from {bottom: 30px; opacity: 1;} 
  to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
  from {bottom: 30px; opacity: 1;}
  to {bottom: 0; opacity: 0;}
}
</style>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!----======== CSS ======== -->
    <link rel="stylesheet" href="./css/newstyle.css">
     
    <!----===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="./css/line.css">

    <title> Regisration Form </title> 
</head>
<body>
<div id="snackbar">user not created..PLease Try again</div>
<% String result = (String)request.getAttribute("result"); %>
<%if(result!=null && result.equalsIgnoreCase("fail") ){  %>
	 <script type="text/javascript" language="JavaScript">
	
	  var x = document.getElementById("snackbar");
	  x.className = "show";
	  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 5000);
  </script>
<% }  %>

    <div class="container">
        <header>Registration</header>

        <form id="signupform"action="SignupServlet" method="POST">
            <div class="form first">
                <div class="details personal">
                    <span class="title">Personal Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>First Name</label>
                            <input type="text" name="fname" placeholder="Enter your name" required>
                        </div>
                        <div class="input-field">
                          <label>Middle Name</label>
                          <input type="text" name="mname" placeholder="Enter your name" required>
                      </div>
                      <div class="input-field">
                        <label>Last Name</label>
                        <input type="text" name="lname" placeholder="Enter your name" required>
                    </div>

                        <div class="input-field">
                            <label>Date of Birth</label>
                            <input type="date" name="dob" placeholder="Enter birth date" required>
                        </div>

                        <div class="input-field">
                            <label>Email</label>
                            <input type="text" name="email" placeholder="Enter your email" required>
                        </div>

                        <div class="input-field">
                            <label>Mobile Number</label>
                            <input type="number" name="mob" placeholder="Enter mobile number" required>
                        </div>

                        <div class="input-field">
                            <label>Gender</label>
                            <select name="gen" required>
                                <option disabled selected>Select gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Others">Others</option>
                            </select>
                        </div>

                        <div class="input-field">
                          <label>Blood Group</label>
                          <select name="bg" required>
                              <option disabled selected>Select Blood Group</option>
                              <option value="A+">A+</option>
                              <option value="A-">A-</option>
                              <option value="B+">B+</option>
                              <option value="B-">B-</option>
                              <option value="AB+">AB+</option>
                              <option value="AB-">AB-</option>
                              <option value="O+">O+</option>
                              <option value="O-">O-</option>
                              
                          </select>
                      </div>
                        <div class="input-field">
                            <label>Age</label>
                            <input type="text" name="age"placeholder="Enter your age" required>
                        </div>
                        <div class="input-field"  style="width: calc(100% / 2 - 15px) !important">
                          <label>Username</label>
                          <input type="text" name="username" placeholder="Enter your Username" required>
                      </div>
                        <div class="input-field"  style="width: calc(100% / 2 - 15px) !important">
                          <label>Password</label>
                          <input type="text" name="password" placeholder="Create your password" required>
                      </div>
                      <div class="input-field"  style="width: calc(100% - 15px) !important">
                        <label>Address</label>
                        <textarea name="address" id="address" name="address" placeholder="Enter your address"  cols="30" rows="3"></textarea>
                    </div>
                       
                    </div>
                    
                </div>

                <button class="submit">
                  <span class="btnText">Submit</span>
                
              </button>
                
            </div>

           
        </form>
    </div>

  
</body>
<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("snackbar");
	  x.className = "show";
	  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	}
</script>

<script type="text/javascript">


const form = document.querySelector("form"),
submit = form.querySelector(".submit")


submit.addEventListener("click", ()=> {
	document.getElementById("signupform").submit();
})
</script>
</html>
    