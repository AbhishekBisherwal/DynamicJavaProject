<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning Portal: Admin Signup</title>
</head>
<body>
 <div align="center">
  <h1>Admin Sign up </h1>
  <form action="<%= request.getContextPath() %>/adminsignup" method="post">
   <table style="with: 80%">
    <tr>
     <td>ID</td>
     <td><input type="number" name="ID" /></td>
    </tr>
    <tr>
     <td>Name</td>
     <td><input type="text" name="Name" /></td>
    </tr>
     <td>Email</td>
     <td><input type="text" name="Email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="Pass" /></td>
    </tr>
   </table>
   <input type="submit" value="SignUp" />
  </form>
 </div>
</body>
</html>
<form action="<%= request.getContextPath() %>/logout">
  <input type="submit" value="Home" />
 </form>