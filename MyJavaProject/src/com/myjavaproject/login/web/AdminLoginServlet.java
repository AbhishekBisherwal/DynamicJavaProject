package com.myjavaproject.login.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaproject.login.bean.LoginBean;
import com.myjavaproject.login.database.LoginDao;


@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	public void init() {
        loginDao = new LoginDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminlogin.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUserID(userID);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
            	request.setAttribute("userID", userID);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminlanding.jsp");
        		dispatcher.forward(request, response);
            } else {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        		dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
