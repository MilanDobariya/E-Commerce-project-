package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Customer;
import com.niit.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

@RequestMapping(value="/all/registrationform")
public ModelAndView getRegistrationForm(){
	return new ModelAndView("registrationform","customer",new Customer());
}

@RequestMapping(value="/all/registercustomer")
public String registerCustomer(@ModelAttribute Customer customer ){
	customerService.registerCustomer(customer);
	return "login";
}
}
