package com.test.orm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.orm.model.User;
import com.test.orm.service.BaseService;
import com.test.orm.service.UserService;
import com.test.orm.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		return userService.getUser(id);
	}
	
	@PostMapping
	public String createUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}
	
}


