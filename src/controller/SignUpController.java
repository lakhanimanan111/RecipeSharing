package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBMngr;

import entities.User;
import entities.Visitor;
import entities.UserAccount;

public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		User user = new Visitor();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		UserAccount account = new UserAccount();
		account.setUserName(request.getParameter("uname"));
		account.setPassword(request.getParameter("psw"));
		user.setAccount(account);
		user.setAdminAuthority(false);
		
		DBMngr dbMngr = new DBMngr();
		Boolean signUpStatus = dbMngr.saveUser(user);
		
		if(signUpStatus) {
			request.getSession().setAttribute("currentUser", request.getParameter("uname"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(request,response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request,response);
		}
		
	}
}
