package com.niit.shopppingcart.client;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopppingcart.config.ApplicationContextConfig;
import com.niit.shopppingcart.dao.CategoryDAO;

import com.niit.shopppingcart.domain.Category;

public class Client {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

		CategoryDAO cdao = (CategoryDAO) ctx.getBean("CategoryDAO");

		Category category = new Category();
		category.setId("1");
		category.setName("nokia");
		category.setDescription("lumia720");

		if (cdao.save(category)) {

			System.out.println("it is saved");
		}

		else {

			System.out.println("Not saved..");
		}

	}

}