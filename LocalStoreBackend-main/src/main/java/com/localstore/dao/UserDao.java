package com.localstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localstore.modal.User;

public interface UserDao extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String name);
}
