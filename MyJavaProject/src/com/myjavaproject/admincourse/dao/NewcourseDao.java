package com.myjavaproject.admincourse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myjavaproject.admincourse.model.NewCourse;

public class NewcourseDao {
	
	public int registerNewCourse(NewCourse newcourse) throws ClassNotFoundException {
        String INSERT_NEWCOURSES_SQL = "INSERT INTO courses" +
            "  (courseID, courseName, courseDesc, courseFee) VALUES " +
            " (?, ?, ?, ?);";
        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWCOURSES_SQL)) {
            preparedStatement.setString(1, newcourse.getCourseID());
            preparedStatement.setString(2, newcourse.getCourseName());
            preparedStatement.setString(3, newcourse.getCourseDesc());
            preparedStatement.setInt(4, newcourse.getCourseFee());
           
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        return result;
    }
	
	
	public int deleteCourse(NewCourse newcourse) throws ClassNotFoundException {
		String DELETE_COURSE_SQL = "DELETE FROM courses where courseID ="+
	            " ( ?);";
        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COURSE_SQL)) {
            preparedStatement.setString(1, newcourse.getCourseID());
           
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
