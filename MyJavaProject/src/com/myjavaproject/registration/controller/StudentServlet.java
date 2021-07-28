package com.myjavaproject.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaproject.registration.dao.StudentDao;
import com.myjavaproject.registration.model.Student;

@WebServlet("/signup")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao   = new StudentDao();
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentregister.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ID = Integer.parseInt(request.getParameter("ID"));
		String Name = request.getParameter("Name");
		int Phone = Integer.parseInt(request.getParameter("Phone"));
		String Email = request.getParameter("Email");
		String Address = request.getParameter("Address");
		String Reg_date = request.getParameter("Reg_date");
		String Pass = request.getParameter("Pass");
		
		Student student = new Student();
		student.setID(ID);
		student.setName(Name);
		student.setPhone(Phone);
		student.setEmail(Email);
		student.setAddress(Address);
		student.setReg_date(Reg_date);
		student.setPass(Pass);
		try {
		studentDao.registerStudent(student);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print("Registration Successfull ! Please Login to Continue");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

}
