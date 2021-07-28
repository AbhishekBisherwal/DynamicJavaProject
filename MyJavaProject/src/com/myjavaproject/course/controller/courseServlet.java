package com.myjavaproject.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaproject.course.dao.CourseDao;
import com.myjavaproject.course.model.Course;


@WebServlet("/addcourse")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourseDao courseDao = new CourseDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ID = Integer.parseInt(request.getParameter("ID"));
		String CourseID = request.getParameter("CourseID");
		
		Course course = new Course();
		course.setStudentID(ID);
		course.setCourseID(CourseID);
		try {
			courseDao.registerCourse(course);
			}catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.print("Course addition Successfull !");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/courses.jsp");
			dispatcher.forward(request, response);
		
	}

}
