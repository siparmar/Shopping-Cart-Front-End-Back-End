package com.niit.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopppingcart.dao.CategoryDAO;
import com.niit.shopppingcart.domain.Category;

@Controller
public class CategoryController {

	// category.jsp -addCategory , deleteCategory , showCategoryList ,
	// updateCategory

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	//CURD Operations
	
	
}
