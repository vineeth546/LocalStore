package com.localstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localstore.modal.Category;

public interface CategoryDao extends JpaRepository<Category, Long>  {

}
