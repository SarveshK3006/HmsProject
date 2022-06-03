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

<form action="SignupServlet" method="post">
    
    <div class="form-heading">
<h1>Shree Hospital</h1>
        </div>
       
  <div class="form-field">
    <input type="email" name="username" placeholder="Email / Username" required/>
  </div>
  
  <div class="form-field">
    <input type="password" name="password" placeholder="Password" required/>          
               </div>
              <div class="form-field center">
               <a href="#" class="link">Forgot Your Password?</a>
               </div>
  <div class="form-field">
    <button class="btn" type="button">Log in</button>
    <button class="btn" type="submit">Sign up</button>
  </div>

</form>
<!-- partial -->
  
</body>

</html>