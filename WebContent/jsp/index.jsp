<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

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
  <title>Login Page with Background Image Example</title>
  <link rel="stylesheet" href="./css/style.css">

</head>
<body>

<div id="snackbar">user created successfully..</div>

<% String result = (String)request.getAttribute("result"); %>
<%if(result!=null && result.equalsIgnoreCase("done") ){  %>
	 <script type="text/javascript" language="JavaScript">
	
	  var x = document.getElementById("snackbar");
	  x.className = "show";
	  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
  </script>
<% }  %>


<!-- partial:index.partial.html -->
<div id="bg"></div>

<form action="SigninServlet" method="post">
    
    <div class="form-heading">
<h1>Shree Hospital</h1>
        </div>
       
  <div class="form-field">
    <input type="text" name="username" placeholder="Email / Username" required/>
  </div>
  
  <div class="form-field">
    <input type="password" name="password" placeholder="Password" required/>          
               </div>
              <div class="form-field center">
               <a href="#" class="link">Forgot Your Password?</a>
               </div>
  <div class="form-field">
    <button class="btn" type="submit">Log in</button>
    <button onclick="openSignup()" class="btn" type="button">Sign up</button>
  </div>

</form>
<form  id="signup" action="SignupServlet" method="get">
</form>
  
</body>
<script type="text/javascript"> 
function openSignup(){
	
	document.getElementById("signup").submit();
}

</script>
</html>