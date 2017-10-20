package com.ooad.project.utilities;

import java.util.List;

public class Customer {

	String name;
	String email;
	List<Recipe> recipeList = null;
	CustomerAccount account = null;
	
	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Recipe> getRecipeList() {
		return recipeList;
	}
	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	public CustomerAccount getAccount() {
		return account;
	}
	public void setAccount(CustomerAccount account) {
		this.account = account;
	}
}
