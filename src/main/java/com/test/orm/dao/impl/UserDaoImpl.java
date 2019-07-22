package com.test.orm.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.orm.dao.UserDao;
import com.test.orm.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;	
	

	@Override
	public User getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		User user =session.get(User.class, id);
		return user;
	}

	@Override
	public String addUser(@Valid User user) {
		Session session = sessionFactory.getCurrentSession();

		
		String resultUser = (String) session.save(user);

	//	session.flush();
	//	session.close();
		return resultUser;
	}
	
	

}
