package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utility.DatabaseConnection;
import entities.Recipe;
import entities.User;
import entities.UserAccount;

public class DBMngr {
	
	Connection dbConnection;
	
	/*
	 * Save user to database during sign up
	 */
	public Boolean saveUser(User u) {
		try {
			dbConnection = DatabaseConnection.getConnection();
			String insertTableSQL = "INSERT INTO user"
									+ "(name, email, username, user_password, admin_authority) VALUES"
									+ "(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getEmail());
			preparedStatement.setString(3, u.getAccount().getUserName());
			preparedStatement.setString(4, u.getAccount().getPassword());
			preparedStatement.setBoolean(5, u.getAdminAuthority());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
		return true;
	}
	
	/*
	 * Get User from DB for verification
	 */
	public User getUser(String userName) {
		User u = null;
		try {
			dbConnection = DatabaseConnection.getConnection();
			String selectSQL = "SELECT * FROM user WHERE username = '" + userName + "'";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs;		
			rs = preparedStatement.executeQuery();
			if(rs.next())
				u = new User();
			rs.beforeFirst();
			while (rs.next()) {	
				u.setUserId(rs.getInt("user_id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				String username = rs.getString("username");
				String password = rs.getString("user_password");
				u.setAccount(new UserAccount(username, password));
				u.setAdminAuthority(rs.getBoolean("admin_authority"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	/*
	 * Upload Recipe to DB
	 */
	public Boolean uploadRecipe(User user, Recipe recipe) {
		try {
			dbConnection = DatabaseConnection.getConnection();
			String insertTableSQL = "INSERT INTO recipe"
									+ "(user_id, recipe_name, ingredients, steps, approve_status) VALUES"
									+ "(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, recipe.getRecipeName());
			preparedStatement.setString(3, recipe.getIngredients());
			preparedStatement.setString(4, recipe.getSteps());
			preparedStatement.setBoolean(5, recipe.getApproveStatus());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
		return true;
	}
	
	/*
	 * Get Recipe List for a user
	 */
	public List<Recipe> getRecipeList(User user) {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		try {			
			dbConnection = DatabaseConnection.getConnection();
			String selectSQL = "SELECT * FROM recipe WHERE user_id = '" + user.getUserId() + "'";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs;		
			rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				Recipe recipe = new Recipe();
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setUserId(rs.getInt("user_id"));
				recipe.setRecipeName(rs.getString("recipe_name"));
				recipe.setIngredients(rs.getString("ingredients"));
				recipe.setSteps(rs.getString("steps"));
				recipeList.add(recipe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeList;
	}
	
	/*
	 * Get Recipe List for admin
	 */
	public List<Recipe> getRecipeList() {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		try {			
			dbConnection = DatabaseConnection.getConnection();
			String selectSQL = "SELECT * FROM recipe WHERE approve_status = " + false;
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs;		
			rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				Recipe recipe = new Recipe();
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setUserId(rs.getInt("user_id"));
				recipe.setRecipeName(rs.getString("recipe_name"));
				recipe.setIngredients(rs.getString("ingredients"));
				recipe.setSteps(rs.getString("steps"));
				recipe.setApproveStatus(rs.getBoolean("approve_status"));
				recipeList.add(recipe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeList;
	}
	
	public Recipe getRecipe(Integer recipeId) {
		Recipe recipe = new Recipe();
		try {			
			dbConnection = DatabaseConnection.getConnection();
			String selectSQL = "SELECT * FROM recipe WHERE recipe_id = '" + recipeId + "'";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs;		
			rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setUserId(rs.getInt("user_id"));
				recipe.setRecipeName(rs.getString("recipe_name"));
				recipe.setIngredients(rs.getString("ingredients"));
				recipe.setSteps(rs.getString("steps"));
				recipe.setApproveStatus(rs.getBoolean("approve_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipe;
	}
	
	public Boolean editRecipe(Integer recipeId, Recipe recipe) {
		try {
			dbConnection = DatabaseConnection.getConnection();
			String insertTableSQL = "UPDATE recipe "
									+ "SET recipe_name = ?, ingredients = ?, steps = ? "
									+ "WHERE recipe_id = '" + recipeId + "'";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, recipe.getRecipeName());
			preparedStatement.setString(2, recipe.getIngredients());
			preparedStatement.setString(3, recipe.getSteps());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
		return true;
	}
	
	public Boolean deleteRecipe(Integer recipeId) {
		try {
			dbConnection = DatabaseConnection.getConnection();
			String deleteTableSQL = "DELETE FROM recipe "
									+ "WHERE recipe_id = '" + recipeId + "'";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(deleteTableSQL);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
		return true;
	}
	
	public List<Recipe> searchRecipe(String searchString) {
		
		List<Recipe> recipeList = new ArrayList<Recipe>();
		try {			
			dbConnection = DatabaseConnection.getConnection();
			String selectSQL = "SELECT * FROM recipe " +
							   "WHERE approve_status = " + true + " AND" + 
							   " (ingredients LIKE '%"  + searchString + "%' OR steps LIKE '%"  + searchString  + "%')";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs;		
			rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				Recipe recipe = new Recipe();
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setUserId(rs.getInt("user_id"));
				recipe.setRecipeName(rs.getString("recipe_name"));
				recipe.setIngredients(rs.getString("ingredients"));
				recipe.setSteps(rs.getString("steps"));
				recipe.setApproveStatus(rs.getBoolean("approve_status"));
				recipeList.add(recipe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeList;
	}

	public Boolean approveRecipe(Integer recipeId) {
		try {
			dbConnection = DatabaseConnection.getConnection();
			String approveTableSQL = "UPDATE recipe "
									+ "SET approve_status = " + true
								    + " WHERE recipe_id = '" + recipeId + "'";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(approveTableSQL);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
		return true;
	}

}
