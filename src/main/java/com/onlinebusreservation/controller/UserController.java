package com.onlinebusreservation.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.exceptions.RecordNotFoundException;
import com.onlinebusreservation.model.User;
import com.onlinebusreservation.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addUser(@RequestBody User newUser) {

		userService.createUser(newUser);
	}

	@GetMapping("/readAllUser")
	public Iterable<User> readAllUser() {

		return userService.displayAllUser();
	}

	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") BigInteger userId) {

		userService.deleteUser(userId);
	}
}
