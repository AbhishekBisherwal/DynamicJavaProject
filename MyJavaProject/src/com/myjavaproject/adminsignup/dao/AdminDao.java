package com.myjavaproject.adminsignup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myjavaproject.adminsignup.model.Admin;

public class AdminDao {
	
	public int registerAdmin(Admin admin) throws ClassNotFoundException	{
		int result = 0;
		String INSERT_ADMIN_SQL = "INSERT INTO admins " +
									"(ID, Name, Email, pass) VALUES " + 
									"(?,?,?,?);";
		String INSERT_LOGIN_SQL = "INSERT INTO login" +
                "  (userID, Pass) VALUES " +
                " (?, ?);";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
	            preparedStatement.setInt(1, admin.getID());
	            preparedStatement.setString(2, admin.getName());
	            preparedStatement.setString(3, admin.getEmail());
	            preparedStatement.setString(4, admin.getPass());

	            System.out.println(preparedStatement);
	            result = preparedStatement.executeUpdate();
	            
	            

	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        try (Connection connection = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

	                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOGIN_SQL)) {
	                preparedStatement.setInt(1, admin.getID());
	                preparedStatement.setString(2, admin.getPass());

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
