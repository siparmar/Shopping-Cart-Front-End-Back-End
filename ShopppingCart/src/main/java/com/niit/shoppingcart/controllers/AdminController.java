package com.niit.shoppingcart.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopppingcart.dao.CategoryDAO;
import com.niit.shopppingcart.domain.Category;


@Controller
public class AdminController {

	// define 3 methods
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;

	
	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories() {
		System.out.println("method called manage categories");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedCategories", "true");

		// get the categories from the db .
		
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList",categoryList);
		mv.addObject("category", category); //to access category domain object in category.jsp
		
		return mv;

	}

	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSuppliers() {
		System.out.println("method called manage suppliers ");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");

		return mv;

	}

	@RequestMapping("/manage_products")
	public ModelAndView manageProducts() {
		System.out.println("method called manage products ");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedProducts", "true");

		return mv;

	}

}
