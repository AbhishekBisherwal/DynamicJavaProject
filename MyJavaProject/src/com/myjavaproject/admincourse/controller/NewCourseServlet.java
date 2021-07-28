package com.myjavaproject.admincourse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaproject.admincourse.dao.NewcourseDao;
import com.myjavaproject.admincourse.model.NewCourse;


@WebServlet("/admincourseadd")
public class NewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewcourseDao newcoursedao = new NewcourseDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admincourses.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CourseID = request.getParameter("courseid");
		String CourseName = request.getParameter("Coursename");
		String CourseDesc = request.getParameter("desc");
		int CourseFee = Integer.parseInt(request.getParameter("fee"));
		String flag = request.getParameter("flag");
		
		NewCourse newcourse = new NewCourse();
		newcourse.setCourseID(CourseID);
		newcourse.setCourseName(CourseName);
		newcourse.setCourseDesc(CourseDesc);
		newcourse.setCourseFee(CourseFee);
		if(flag.equals("Add")) {
		try {
			newcoursedao.registerNewCourse(newcourse);
			}catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			System.out.println("Course added database");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admincourses.jsp");
			dispatcher.forward(request, response);}
		else
		{
			try {
				newcoursedao.deleteCourse(newcourse);
				}catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				System.out.println("Course deleted from database");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admincourses.jsp");
				dispatcher.forward(request, response);
		}
	}

}
