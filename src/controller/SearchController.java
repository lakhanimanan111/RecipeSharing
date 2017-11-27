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

import model.DBMngr;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBMngr dbMngr = new DBMngr();	
		String searchString = request.getParameter("searchString");
		List<Recipe> recipeList = dbMngr.searchRecipe(searchString);
		request.setAttribute("searchedRecipe", recipeList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("displaySearchResults.jsp");
		requestDispatcher.forward(request,response);
	}

}
