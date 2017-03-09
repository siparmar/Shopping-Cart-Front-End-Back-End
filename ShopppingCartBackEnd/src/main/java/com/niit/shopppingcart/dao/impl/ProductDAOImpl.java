package com.niit.shopppingcart.dao.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopppingcart.dao.ProductDAO;
import com.niit.shopppingcart.domain.Product;


@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	
		@Autowired
		private SessionFactory sessionFactory;

		private Session getSession() {
			return sessionFactory.getCurrentSession();
		}
		
		public List<Product> list() {
			return getSession().createQuery("from Product").list();
		}

		public Product getProduct(String id) {
			return (Product) getSession().get(Product.class, id);
		}

		public boolean save(Product product) {
			try {

				// sessionFactory.getCurrentSession().save(product);
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(product);
				session.getTransaction().commit();
				session.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}

		public boolean update(Product product) {
		
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
		
		
		
		public boolean delete(Product product) {
			// TODO Auto-generated method stub
			return false;
		}

		
	}


		

		





