package entities;

import java.util.List;

public class Visitor extends User {

	List<Recipe> recipeList = null;

	public List<Recipe> getRecipeList() {
		return recipeList;
	}
	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
}
