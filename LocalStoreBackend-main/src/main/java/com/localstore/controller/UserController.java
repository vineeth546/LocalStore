package com.localstore.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.localstore.modal.User;
import com.localstore.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserController {
	private static final Logger log=Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	User addUser(@RequestBody User user) {
	log.info("addUser method in UserController  is running");
		return userService.addUser(user);
	}

	@GetMapping("/admin/findAllUsers")
	public List<User> findAllUsers() {
		log.info("findAllUsers method in UserController  is running");
		return userService.findAllUsers();
	}

	@PutMapping("/editUser/{id}")
	User editUser(@RequestBody User user, @PathVariable long id) {
		log.info("editUser method in UserController  is running");
		return userService.editUser(user, id);
	}

	@GetMapping("/findUserById/{id}")
	User findUserById(@PathVariable long id) {
		log.info("findUserById method in UserController  is running");
		return userService.findUserById(id);
	}

	@DeleteMapping("/deleteUser/{id}")
	void deleteUser(@PathVariable long id) {
		log.info("deleteUser method in UserController  is running");
		userService.deleteUser(id);
	}
	
	@GetMapping("/findByUsername/{username}")
	User findByUsername(@PathVariable String username) {
		log.info("findByUsername method in UserController  is running");
		return userService.findByUsername(username);
	}
}
