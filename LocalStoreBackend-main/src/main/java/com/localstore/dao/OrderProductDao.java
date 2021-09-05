package com.localstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localstore.modal.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Long> {

}
