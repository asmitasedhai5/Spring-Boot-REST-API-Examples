package com.itglance.springbootdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itglance.springbootdemo.entity.User;
import com.itglance.springbootdemo.repository.UserService;

@RestController
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> userlist = userservice.findAll();
		if (userlist.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
	}

	@PostConstruct
	public void insert() {
		User user = new User(1, "Asmita");
		User user1 = new User(2, "Alina");
		userservice.save(user);
		userservice.save(user1);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<List<User>> retrieve(@RequestBody User user) {
		user = userservice.save(user);
		return new ResponseEntity<List<User>>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		logger.info("Updating User with id {}", id);

		User user1 = userservice.findOne(id);

		if (user1 == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		user1.setName(user.getName());

		userservice.save(user1);
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		logger.info("Fetching & Deleting User with id {}", id);

		User user = userservice.findOne(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		userservice.delete(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
