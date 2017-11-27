package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;

import model.DBMngr;

@WebServlet("/ApproveController")
public class ApproveController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DBMngr dbMngr = new DBMngr();
		String userName = (String) request.getSession().getAttribute("currentUser");
		User user = dbMngr.getUser(userName);
		if(user == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request,response);
			return;
		}
		Integer recipeId = Integer.parseInt(request.getParameter("recipeId"));
		Boolean approveStatus = dbMngr.approveRecipe(recipeId);
		
		if(approveStatus) {
			request.getSession().setAttribute("currentUser", userName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("intermediate.jsp");
			requestDispatcher.forward(request,response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request,response);
		}	
		
	}
}
