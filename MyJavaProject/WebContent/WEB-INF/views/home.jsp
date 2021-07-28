<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
 <div align="center">
  <h1>Welcome to the Learning Portal</h1>
  <div align="center">
  		<a href="<%= request.getContextPath() %>/adminsignup">Admin SignUp</a>
  		<br>
  		<a href="<%= request.getContextPath() %>/adminlogin">Admin Login</a>
  		<br>
  		<a href ="<%= request.getContextPath() %>/signup">Learner SignUp</a>
  		<br>
  		<a href ="<%= request.getContextPath() %>/login">Learner Login</a>
  </div>
 </div>
</body>
</html>