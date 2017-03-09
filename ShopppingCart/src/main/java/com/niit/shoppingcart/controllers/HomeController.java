package com.niit.shoppingcart.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopppingcart.dao.UserDAO;
import com.niit.shopppingcart.domain.User;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	/*
	 * @RequestMapping("/") public String showHomePage() {
	 * System.out.println("starting of the method"); return "home"; }
	 */

	@Autowired
	private HttpSession session;

	// http://localhost:8080/ShopppingCart/

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		System.out.println("Starting of Home Page");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("msg", "Welcome to Shopping Cart");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView showLoginPage() {
		System.out.println("clicked login page");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("hasClickedLogin", "true");

		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		System.out.println("clicked registration page");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("hasClickedRegistration", "true");
		return mv;
	}

	@RequestMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam("userID") String id, @RequestParam("password") String pwd) {

		// Actually you have to get the data from database
		// temp user->niit password = niit@123

		ModelAndView mv = new ModelAndView("/home");

		// calling directly from back end project

		if (userDAO.validate(id, pwd) == true) {

			 mv.addObject("msg","Welcome to Shopping Cart");
		

			// if (id.equals("niit") && pwd.equals("niit@123")) {
			 
			// to know the role in the userdao itself we have a method called
			// getuser this getuser will call all the info
			// of the user .

			user = userDAO.getUser(id);
			
			  if(user.getRole().equals("ROLE_ADMIN"))
			   {
			  mv.addObject("isAdmin","true");
			   } else 
			   {
			  mv.addObject("isAdmin","false");
			   }

			mv.addObject("successMessage", "Valid Credentials");
			session.setAttribute("loginMessage", "Welcome :" + id);
		} 
		else
		{
			mv.addObject("errorMessage", "InValid Credentials , please try again ");

		}

		return mv;

	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("/home");
		// session.invalidate();
		session.removeAttribute("loginMessage");

		return mv;
	}

}
