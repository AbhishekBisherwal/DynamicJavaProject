<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<title>Admin: Courses</title>
<% String ID = request.getParameter("userID"); 
out.println("welcome! to Admin section\n");
out.println("Your Admin ID: " +ID);
%>
<%
String driverName = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "learningportal";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center">All Courses</h2>
<table align="center" border="1">
<tr>

</tr>
<tr>
<td><b>Course ID</b></td>
<td><b>Course Name</b></td>
<td><b>Course Description</b></td>
<td><b>Course Fee</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM courses";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("courseID") %></td>
<td><%=resultSet.getString("courseName") %></td>
<td><%=resultSet.getString("courseDesc") %></td>
<td><%=resultSet.getString("courseFee") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<br>

<div align="center">
<h3>Course Add or Delete</h3>
  <form action="<%= request.getContextPath() %>/admincourseadd" method="post">
   <table style="with: 80%">
    <tr>
     <td>Course ID</td>
     <td><input type="text" name="courseid" /></td>
    </tr>
    <tr>
     <td>Course Name</td>
     <td><input type="text" name="Coursename" /></td>
    </tr>
      <tr>
     <td>Course Description</td>
     <td><input type="text" name="desc" /></td>
    </tr>
     <tr>
     <td>Course Fee</td>
     <td><input type="number" name="fee" /></td>
    </tr>
     <tr>
     <td>Please mention: Add / Delete</td>
     <td><input type="text" name="flag" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
</div>
<form action="<%= request.getContextPath() %>/logout">
  <input type="submit" value="LogOut" />
 </form>

