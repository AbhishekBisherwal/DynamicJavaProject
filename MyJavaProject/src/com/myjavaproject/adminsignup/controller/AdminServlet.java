package com.myjavaproject.adminsignup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaproject.adminsignup.dao.AdminDao;
import com.myjavaproject.adminsignup.model.Admin;

@WebServlet("/adminsignup")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDao admindao = new AdminDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminregister.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Pass = request.getParameter("Pass");
		
		Admin admin = new Admin();
		admin.setID(ID);
		admin.setName(Name);
		admin.setEmail(Email);
		admin.setPass(Pass);
		
		try {
			admindao.registerAdmin(admin);
			}catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.print("Registration Successfull ! Please Login to Continue");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminlogin.jsp");
			dispatcher.forward(request, response);
	}

}
