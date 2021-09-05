package com.localstore.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.localstore.dao.CategoryDao;
import com.localstore.dao.ProductDao;
import com.localstore.modal.Category;
import com.localstore.modal.Product;
import com.localstore.service.ProductService;

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;


	@Override
	public Product addProductToCategory(Product product, long idCategory) {
		Category category = categoryDao.findById(idCategory).orElse(null);
		category.addProductToCategory(product);
		return productDao.save(product);
	}



	@Override
	public Product editProduct(Product product, long id) {
		Product existProduct = productDao.findById(id).orElse(null);
		existProduct.setName(product.getName());
		existProduct.setDescription(product.getDescription());
		existProduct.setPictureUrl(product.getPictureUrl());
		existProduct.setPrice(product.getPrice());
		return productDao.save(existProduct);
	}

	@Override
	public Product findProductById(long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	public void deleteProduct(long id) {
		productDao.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findProductsForCategory(long idCategory) {
		Category category = categoryDao.findById(idCategory).orElse(null);
		return category.getProducts();
	}

	@Override
	public Product getProduct(Long id) {
		return productDao.findById(id).orElse(null);
	}

}
