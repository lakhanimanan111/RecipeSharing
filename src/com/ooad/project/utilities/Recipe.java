package com.ooad.project.utilities;

import java.util.List;

public class Recipe {

	String name;
	List<String> ingredientList;
	List<String> stepList;
	float avgRate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(List<String> ingredientList) {
		this.ingredientList = ingredientList;
	}
	public List<String> getStepsList() {
		return stepList;
	}
	public void setStepsList(List<String> stepsList) {
		this.stepList = stepsList;
	}
	public float getAvgRate() {
		return avgRate;
	}
	public void setAvgRate(float avgRate) {
		this.avgRate = avgRate;
	}
	
}
