package com.niit.shopppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopppingcart.dao.UserDAO;
import com.niit.shopppingcart.domain.User;

@Transactional
@Repository("userDAO")

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<User> list() {
		return getSession().createQuery("from User").list();
	}

	public User getUser(String id) {
		return (User) getSession().get(User.class, id);
	}

	public boolean save(User user) {
		try {
			getSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		try {
			getSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(String id, String password){
		//select * from User where id = 'niit' and password = 'niit'
		
		String hql ="from User where id = '"+id+"' and password ='"+password+ "'" ;
		
		if (getSession().createQuery(hql).uniqueResult()==null){
		return false;
	}
		return true;
	}

	/*public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validate(User user) {
		// TODO Auto-generated method stub
		return false;
	}*/
}
