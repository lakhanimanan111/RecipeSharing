package com.ooad.project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.ooad.project.utilities.Customer;
import com.ooad.project.utilities.DatabaseConnection;
//import com.ooad.project.utilities.DatabaseConnection;
import com.ooad.project.utilities.Queries;

public class DbAction {

	public void createCustomer(Customer customer) {
		try {	    	 
			String url = "jdbc:mysql://localhost:3306/";
	        String dbName = "chefs_secret";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "root";
	        String password = "";
	        
        	Class.forName(driver).newInstance();
			Connection connection = DriverManager.getConnection(url + dbName, userName,password);
			System.out.println("Connectedddddddd");

	    	 PreparedStatement ps = connection.prepareStatement(Queries.INSERT_CUSTOMER);
		     ps.setString(1, customer.getName());
		     ps.setString(2, customer.getEmail());
		     ps.setString(3, customer.getAccount().getUserName());
		     ps.setString(4, customer.getAccount().getPassword());
	    	 ps.executeUpdate();	    	 
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DbAction db = new DbAction();
		Customer c = new Customer("", "");
		db.createCustomer(c);
	}
	public boolean authenticateUser(String uname, String psw) {
		boolean result = false;
		try {
	    	 
	    	 System.out.println("Connecting to database...");
	    	 Connection conn = DatabaseConnection.getConnection();
	    	 System.out.println("Connected to Database");
	    	 result = true;
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
