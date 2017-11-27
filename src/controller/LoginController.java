package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;

import model.DBMngr;


public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Boolean loginStatus = false;
		Boolean isAdmin = false;
		
		String userName = request.getParameter("uname");		
		String pswd = request.getParameter("psw");
		
		DBMngr dbMgr = new DBMngr();		
		User u = dbMgr.getUser(userName);
		
		if(u != null) {
			loginStatus = u.verify(pswd);
			isAdmin = u.getAdminAuthority();
		}
		if(loginStatus && isAdmin) {
			request.getSession().setAttribute("currentUser", request.getParameter("uname"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminHome.jsp");
			requestDispatcher.forward(request,response);
		}
		else if(loginStatus) {
			request.getSession().setAttribute("currentUser", request.getParameter("uname"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(request,response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request,response);
		}			
	}

}
