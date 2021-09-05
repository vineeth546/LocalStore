package com.localstore.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.localstore.dao.UserDao;
import com.localstore.modal.User;
import com.localstore.service.UserService;

@Transactional
@Component
public class UserServiceImpl implements UserService {
	
	
	private static final Logger log=Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		log.info("addUser method in UserServiceImpl  is running");
		List<User> users = userDao.findAll();
		if (users.size() == 0) {
			user.setAdmin(true);
		}
		
		for (User userExist : users) {
			if (user.getUsername().equals(userExist.getUsername())) {
				userExist.setUsername(userExist.getUsername());
				userExist.setPassword(userExist.getPassword());
				return userDao.save(userExist);
			}
		}
	
		return userDao.save(user);	
	}

	@Override
	public List<User> findAllUsers() {
		log.info("findAllUsers method in UserServiceImpl  is running");
		return userDao.findAll();
	}

	@Override
	public User editUser(User user, long id) {
		log.info("editUser method in UserServiceImpl  is running");
		User existUser = userDao.findById(id).orElse(null);
		existUser.setUsername(user.getUsername());
		existUser.setPassword(user.getPassword());
		existUser.setAdmin(user.isAdmin());
		existUser.setEmail(user.getEmail());
		existUser.setNameOnCard(user.getNameOnCard());
		existUser.setCardNumber(user.getCardNumber());
		existUser.setCvv(user.getCvv());
		existUser.setAddress(user.getAddress());
		return userDao.save(existUser);
	}

	@Override
	public User findUserById(long id) {
		log.info("findUserById method in UserServiceImpl  is running");
      return userDao.findById(id).orElse(null);
	}

	@Override
	public void deleteUser(long id) {
		log.info("deleteUser method in UserServiceImpl  is running");
		userDao.deleteById(id);
	} 
	
	@Override
	 public User findByUsername(String username) {
		log.info("findByUsername method in UserServiceImpl  is running");
		   Optional<User> users = userDao.findByUsername(username);
		    if (users.isPresent()) {
		     User user = users.get();
		   return user;
		  }
		   return null;
		 }


}
