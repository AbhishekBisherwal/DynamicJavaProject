<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<title>Course Enroll</title>
<% String ID = request.getParameter("userID"); 

out.println("welcome ! Student\n");
out.println("Your Student ID: " +ID);
request.setAttribute("ID",ID);
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
<h2 align="center">Available Courses List</h2>
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
<h3>Enroll in new Courses here</h3>
  <form action="<%= request.getContextPath() %>/addcourse" method="post">
   <table style="with: 80%">
    <tr>
     <td>Student ID</td>
     <td><input type="number" name="ID" /></td>
    </tr>
    <tr>
     <td>Course ID</td>
     <td><input type="text" name="CourseID" /></td>
    </tr>
     
   </table>
   <input type="submit" value="Submit" />
  </form>
</div>


<h3 align="center">Your Courses</h3>

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

String sql ="select * from courses natural join courseDetails where courseDetails.userID ="+" (?);";
try (Connection conn = DriverManager
.getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
preparedStatement.setInt(1,1);
ResultSet result= preparedStatement.executeQuery();
while(result.next()){
	%>
<tr>

<td><%=resultSet.getString("courseID") %></td>
<td><%=resultSet.getString("courseName") %></td>
<td><%=resultSet.getString("courseDesc") %></td>
<td><%=resultSet.getString("courseFee") %></td>

</tr>
<%}} catch (SQLException e) {
	System.out.println(e);
	} %>

</table>
<br>


 <form action="<%= request.getContextPath() %>/logout">
  <input type="submit" value="LogOut" />
 </form>