package com.niit.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// CURD Operations

	@PostMapping("/manage_category_create")
	public ModelAndView createCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description)

	{
		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		ModelAndView mv = new ModelAndView("/Admin/AdminHome");

		if (categoryDAO.save(category)) {
			mv.addObject("message", "Successfully created the category");
		} else {
			mv.addObject("message", "Not able to create category , contact administrator");
		}

		return mv;
	}

	@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) 
	
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
	Category category =(Category)	categoryDAO.getCategoryById(id); //the id is taken into getCategoryById and casted into category 
	// then category is declared in delete below.
		
		
		if (categoryDAO.delete(category))
		{
			mv.addObject("message", "Successfully deleted the category");
		} 
		else 
		{
			mv.addObject("message", "Not able to delete category , contact administrator");
		}
		return mv;
	}
	
	@

}
