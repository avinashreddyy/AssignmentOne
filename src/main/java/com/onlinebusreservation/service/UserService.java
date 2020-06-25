package com.onlinebusreservation.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.onlinebusreservation.model.User;

public interface UserService {
	public ResponseEntity<?> createUser(User newUser);

	public String deleteUser(BigInteger UserId);

	public Iterable<User> displayAllUser();

	}
