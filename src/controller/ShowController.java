package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Recipe;
import entities.User;

import model.DBMngr;

@WebServlet("/intermediate.jsp")
public class ShowController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = (String) request.getSession().getAttribute("currentUser");
		DBMngr dbMngr = new DBMngr();
		User user = dbMngr.getUser(userName);
		if(user == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request,response);
			return;
		}
		List<Recipe> recipeList = null;
		if("admin".equalsIgnoreCase(userName)) {
			recipeList = dbMngr.getRecipeList();
		} else {
			recipeList = dbMngr.getRecipeList(user);
		}
		request.setAttribute("RecipeList", recipeList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showRecipe.jsp");
		requestDispatcher.forward(request,response);
	}
}
