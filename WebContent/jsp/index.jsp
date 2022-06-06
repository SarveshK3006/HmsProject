<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Login Page with Background Image Example</title>
  <link rel="stylesheet" href="./css/style.css">

</head>
<body>
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