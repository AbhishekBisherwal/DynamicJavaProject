package com.myjavaproject.course.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myjavaproject.course.model.Course;


public class CourseDao {
	
	public int registerCourse(Course course) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO coursedetails" +
            "  (userID, courseID) VALUES " +
            " (?, ?);";
        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, course.getStudentID());
            preparedStatement.setString(2, course.getCourseID());
           
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
