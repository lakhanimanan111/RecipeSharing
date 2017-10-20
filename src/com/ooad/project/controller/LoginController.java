package com.ooad.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ooad.project.model.DbAction;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		System.out.println("User Name: " + uname);
		
		String psw = req.getParameter("psw");
		System.out.println("Password: " + psw);
		
		DbAction model = new DbAction();
		
		boolean result = model.authenticateUser(uname, psw);
		System.out.println("Connected");
		if("root".equals(uname) && "root".equalsIgnoreCase(psw)) {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
			requestDispatcher.forward(req,resp);
		}
		else {
			
		}
		
			
	}

}
