package entities;

public class Recipe {

	Integer recipeId;
	Integer userId;
	String recipeName;
	String ingredients;
	String steps;
	Boolean approveStatus;
	
	public String getRecipeName() {
		return recipeName;
	}
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	
	public Boolean getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(Boolean approveStatus) {
		this.approveStatus = approveStatus;
	}
}
