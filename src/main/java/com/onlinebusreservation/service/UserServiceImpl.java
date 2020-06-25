package com.onlinebusreservation.service;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.onlinebusreservation.dao.UserDao;
import com.onlinebusreservation.exceptions.RecordAlreadyPresentException;
import com.onlinebusreservation.exceptions.RecordNotFoundException;
import com.onlinebusreservation.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public ResponseEntity<?> createUser(User newUser) {

		Optional<User> findUserById = userDao.findById(newUser.getUserId());
		try {
			if (!findUserById.isPresent()) {
				userDao.save(newUser);
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException("User with Id: " + newUser.getUserId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public String deleteUser(BigInteger UserId) {

		Optional<User> findBookingById = userDao.findById(UserId);
		if (findBookingById.isPresent()) {
			userDao.deleteById(UserId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	public Iterable<User> displayAllUser() {
			return userDao.findAll();
	}

}
