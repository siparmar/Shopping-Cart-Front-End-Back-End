package com.niit.shopppingcart.dao;

import java.util.List;

import com.niit.shopppingcart.domain.Product;

public interface ProductDAO {

	public List<Product> list();

	public Product getProduct(String id);

	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);
	
}
