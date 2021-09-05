package com.localstore.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.localstore.controller.UserController;
import com.localstore.dao.CartDao;
import com.localstore.dao.UserDao;
import com.localstore.modal.Cart;
import com.localstore.modal.User;
import com.localstore.service.CartService;

@Transactional
@Component
public class CartServiceImpl implements CartService {
	
	private static final Logger log=Logger.getLogger(CartServiceImpl.class);
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Cart addCartToUser(Cart cart, long idUser) {
		log.info("addCartToUser method in CartServiceImpl  is running");
		User user = userDao.findById(idUser).orElse(null);
		user.addCartToUser(cart);
		return cartDao.save(cart);
	}

	@Override
	public void deleteCart(long id) {
		log.info("deleteCart method in CartServiceImpl  is running");
		cartDao.deleteById(id);
		
	}

	@Override
	public List<Cart> findCartsForUser(long idUser) {
		log.info("findCartsForUser method in CartServiceImpl  is running");
		User user = userDao.findById(idUser).orElse(null);
		return user.getCarts();
	}

	@Override
	public Cart findCartById(long id) {
		log.info("findCartById method in CartServiceImpl  is running");
		return cartDao.findById(id).orElse(null);
	}

	@Override
	public void removeFromCart(long idCart, long idUser) {
		log.info("removeFromCart method in CartServiceImpl  is running");
		User user = userDao.findById(idUser).orElse(null);
		Cart cart = cartDao.findById(idCart).orElse(null);
		user.removeFromCart(cart);
		cartDao.delete(cart);
	}
         
	@Override
	public Cart findByCartName(String name) {
		log.info("findByCartName method in CartServiceImpl  is running");
		Optional<Cart> carts = cartDao.findByName(name);
		if (carts.isPresent()) {
			Cart cart = carts.get();
			return cart;
		}
		return null;
	}

}
