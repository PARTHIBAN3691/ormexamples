package com.test.orm.service.impl;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.orm.dao.UserDao;
import com.test.orm.model.User;
import com.test.orm.service.BaseService;
import com.test.orm.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(String id) {
		return userDao.getById(id);
	}

	@Override
	public String addUser(@Valid User user) {
		return userDao.addUser(user);
	}

}
