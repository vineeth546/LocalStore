package com.localstore.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localstore.modal.Cart;
import com.localstore.service.CartService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class CartController {
	private static final Logger log=Logger.getLogger(CartController.class);
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/addCartToUser/{idUser}")
	Cart addCartToUser(@RequestBody Cart cart, @PathVariable long idUser) {
		log.info("addCartToUser method in CartController is running");
		return cartService.addCartToUser(cart, idUser);
	}
	@DeleteMapping("/deleteCart/{id}")
	void deleteCart(@PathVariable long id) {
		cartService.deleteCart(id);
		log.info("deleteCart method in CartController is running");
	}
	@GetMapping("/findCartsForUser/{idUser}")
	List<Cart> findCartsForUser(@PathVariable long idUser) {
		log.info("findCartsForUser method in CartController is running");
		return cartService.findCartsForUser(idUser);
	}
	@GetMapping("/findCartById/{id}")
	Cart findCartById(@PathVariable long id) {
		log.info("findCartById method in CartController is running");
		return cartService.findCartById(id);
	}
	@DeleteMapping("/removeFromCart/{idCart}/{idUser}")
	void removeFromCart(@PathVariable long idCart, @PathVariable long idUser) {
		log.info("removeFromCart method in CartController is running");
		cartService.removeFromCart(idCart, idUser);
	}
	
	@GetMapping("/findByCartName/{name}")
	Cart findByCartName(@PathVariable String name) {
		log.info("findByCartName method in CartController is running");
		return cartService.findByCartName(name);
	}

}
