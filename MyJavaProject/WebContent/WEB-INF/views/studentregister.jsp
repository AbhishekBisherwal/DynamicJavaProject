<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning Portal</title>
</head>
<body>
 <div align="center">
  <h1>Student Sign up Form</h1>
  <form action="<%= request.getContextPath() %>/signup" method="post">
   <table style="with: 80%">
    <tr>
     <td>ID</td>
     <td><input type="number" name="ID" /></td>
    </tr>
    <tr>
     <td>Name</td>
     <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
     <td>Phone</td>
     <td><input type="number" name="Phone" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="Email" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="Address" /></td>
    </tr>
    <tr>
     <td>Registration Date</td>
     <td><input type="text" name="Reg_date" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="Pass" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>
<form action="<%= request.getContextPath() %>/logout">
  <input type="submit" value="Home" />
 </form>