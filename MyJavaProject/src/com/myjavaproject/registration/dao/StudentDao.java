package com.myjavaproject.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myjavaproject.registration.model.Student;


public class StudentDao {

    public int registerStudent(Student student) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO student" +
            "  (ID, Name, Phone, Email, Address, Reg_Date, Pass) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";
        String INSERT_LOGIN_SQL = "INSERT INTO login" +
                "  (userID, Pass) VALUES " +
                " (?, ?);";
        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, student.getID());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getReg_date());
            preparedStatement.setString(7, student.getPass());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
            

        } catch (SQLException e) {
            printSQLException(e);
        }
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/LearningPortal?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOGIN_SQL)) {
                preparedStatement.setInt(1, student.getID());
                preparedStatement.setString(2, student.getPass());

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