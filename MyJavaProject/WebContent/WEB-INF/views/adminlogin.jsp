<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
 <div align="center">
  <h1>Admin Login</h1>
  <form action="<%=request.getContextPath()%>/adminlogin" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserID</td>
     <td><input type="number" name="userID" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Login" />
  </form>
 </div>
</body>
</html>