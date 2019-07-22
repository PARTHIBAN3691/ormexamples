package com.test.orm.dao;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.test.orm.model.User;

@Repository
public interface UserDao {

	User getById(String id);

	String addUser(@Valid User user);

}
