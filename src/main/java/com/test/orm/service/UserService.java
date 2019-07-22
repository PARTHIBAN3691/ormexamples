package com.test.orm.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.test.orm.model.User;

@Service
public interface UserService extends BaseService {
	
	public User getUser(String id);

	public String addUser(@Valid User user);

}
