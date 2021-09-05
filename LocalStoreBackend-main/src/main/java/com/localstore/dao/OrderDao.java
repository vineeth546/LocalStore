package com.localstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localstore.modal.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
