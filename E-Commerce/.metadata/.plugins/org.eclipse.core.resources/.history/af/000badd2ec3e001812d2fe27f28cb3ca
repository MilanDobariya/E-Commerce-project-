package com.niit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
public HomeController(){
	System.out.println("HomeController bean is created");
}




//This a handler method
//It can handle the request "http://localhost:8080/project1frontend/home -> DispatcherServlet -> "home"->
// /WEB-INF/views/home.jsp
@RequestMapping(value="/")
public String getHomePage(){
	return "home";
}
@RequestMapping(value="/home")
public String getHome(){
	return "home";
}
}
