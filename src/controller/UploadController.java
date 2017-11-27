package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBMngr;

import entities.Recipe;
import entities.User;

public class UploadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = (String) request.getSession().getAttribute("currentUser");
		DBMngr dbMngr = new DBMngr();
		User user = dbMngr.getUser(userName);
		if(user == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request,response);
			return;
		}	
		
		Boolean uploadStatus = false;
		Recipe recipe = new Recipe();
		recipe.setRecipeName(request.getParameter("recipeName"));
		recipe.setIngredients(request.getParameter("ingredients"));
		recipe.setSteps(request.getParameter("steps"));
		recipe.setApproveStatus(false);
		
		uploadStatus = dbMngr.uploadRecipe(user, recipe);
			
		if(uploadStatus) {
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
