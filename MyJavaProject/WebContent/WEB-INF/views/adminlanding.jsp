<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
	String ID = request.getParameter("userID");
	out.println("welcome! to Admin section\n");
	out.println("Your Admin ID: " + ID);
%>
<title>Admin Home</title>
<div align="center">
	<a href="<%=request.getContextPath()%>/admincourseadd">Courses</a> <br>
	<title>Admin: All Students</title>

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
	<h2 align="center">All Students</h2>
	<table align="center" border="1">
		<tr>

		</tr>
		<tr>
			<td><b>Student ID</b></td>
			<td><b>Name</b></td>
			<td><b>Phone</b></td>
			<td><b>Email</b></td>
			<td><b>Address</b></td>
			<td><b>Registration Date</b></td>
		</tr>
		<%
			try {
				connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
				statement = connection.createStatement();
				String sql = "select ID,Name,Phone,Email,Address,Reg_date from student;";

				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>

			<td><%=resultSet.getString("ID")%></td>
			<td><%=resultSet.getString("Name")%></td>
			<td><%=resultSet.getInt("Phone")%></td>
			<td><%=resultSet.getString("Email")%></td>
			<td><%=resultSet.getString("Address")%></td>
			<td><%=resultSet.getString("Reg_date")%></td>

		</tr>

		<%
			}

			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
</div>
<div align="center">
	
	<h2 align="center">Course Enroll List</h2>
	<table align="center" border="1">
		<tr>

		</tr>
		<tr>
			<td><b>Student ID</b></td>
			<td><b>Course ID</b></td>
			<td><b>Student Name</b></td>
		</tr>
		<%
			try {
				connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
				statement = connection.createStatement();
				String sql = "select distinct courseDetails.userID, courseDetails.courseID, student.Name from courseDetails join student on courseDetails.userID = student.ID order by courseDetails.userID; ";

				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>

			<td><%=resultSet.getInt("courseDetails.userID")%></td>
			<td><%=resultSet.getString("courseDetails.courseID")%></td>
			<td><%=resultSet.getString("student.Name")%></td>

		</tr>

		<%
			}

			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
</div>
<form action="<%= request.getContextPath() %>/logout">
  <input type="submit" value="LogOut" />
 </form>