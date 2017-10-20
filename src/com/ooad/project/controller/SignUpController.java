package com.ooad.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ooad.project.model.DbAction;
import com.ooad.project.utilities.Customer;
import com.ooad.project.utilities.CustomerAccount;

public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		System.out.println("Name: " + name);
		
		String email = req.getParameter("email");
		System.out.println("Email: " + email);
		
		Customer customer = new Customer(name, email);
		
		String userName = req.getParameter("uname");
		System.out.println("User Name: " + userName);
		
		String password = req.getParameter("psw");
		System.out.println("Password: " + password);
		
		CustomerAccount custAccount = new CustomerAccount(userName, password);
		customer.setAccount(custAccount);
		
		//DbAction model = new DbAction();		
		//model.createCustomer(customer);
		
		if(true) {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SignUpSuccess.jsp");
			requestDispatcher.forward(req,resp);
		} else {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SignUpFailure.jsp");
			requestDispatcher.forward(req,resp);
		}
		
	}
}
