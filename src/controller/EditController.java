package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Recipe;
import entities.User;

import model.DBMngr;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean editStatus = false;
		DBMngr dbMngr = new DBMngr();
		String jspname = request.getParameter("jspname");
		
		if( !("edit".equalsIgnoreCase(jspname)) ) {
			String userName = (String) request.getSession().getAttribute("currentUser");
			//Integer userId = dbMngr.getUserId(userName);
			User user = dbMngr.getUser(userName);
			if(user == null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
				requestDispatcher.forward(request,response);
				return;
			}
			Integer recipeId = Integer.parseInt(request.getParameter("recipeId"));
			Recipe recipe = dbMngr.getRecipe(recipeId);
			request.setAttribute("recipeToBeEdited", recipe);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("editRecipe.jsp");
			requestDispatcher.forward(request,response);
			return;
		} else {
			Integer recipeId = Integer.parseInt(request.getParameter("myObjectId"));
			Recipe recipe = dbMngr.getRecipe(recipeId);
			recipe.setRecipeName(request.getParameter("recipeName"));
			recipe.setIngredients(request.getParameter("ingredients"));
			recipe.setSteps(request.getParameter("steps"));
			recipe.setApproveStatus(false);
			editStatus = dbMngr.editRecipe(recipeId, recipe);
			if(editStatus) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("intermediate.jsp");
				requestDispatcher.forward(request,response);
			}
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
				requestDispatcher.forward(request,response);
			}
		}
	}
}
