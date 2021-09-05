package com.localstore.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.localstore.dao.ProductDao;
import com.localstore.modal.Product;
import com.localstore.service.ProductService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductController {

	private static final Logger log=Logger.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDao productDao;

	@PostMapping("/addProductToCategory/{idCategory}")
	Product addProductToCategory(@RequestBody Product product, @PathVariable long idCategory) {
		log.info("addProductToCategory method in ProductController  is running");
		return productService.addProductToCategory(product, idCategory);
	}

	@PutMapping("/editProduct/{id}")
	Product editProduct(@RequestBody Product product, @PathVariable long id) {
		log.info("editProduct method in ProductController  is running");
		 return productService.editProduct(product, id);
	}

	@GetMapping("/findProductById/{id}")
	Product findProductById(@PathVariable long id) {
		log.info("findProductById method in ProductController  is running");
		return productService.findProductById(id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	void deleteProduct(@PathVariable long id) {
		log.info("deleteProduct method in ProductController  is running");
		productService.deleteProduct(id);
	}

	@GetMapping("/findAllProducts")
	List<Product> findAllProducts() {
		log.info("findAllProducts method in ProductController  is running");
		return productService.findAllProducts();
	}

	@GetMapping("/findProductsForCategory/{idCategory}")
	List<Product> findProductsForCategory(@PathVariable long idCategory) {
		log.info("findProductsForCategory method in ProductController  is running");
		return productService.findProductsForCategory(idCategory);
	}

	@GetMapping("/findByName/{name}")
	List<Product> findByName(@PathVariable String name) {
		log.info("findByName method in ProductController  is running");
		return productDao.findByName("%" + name + "%");
	}

}
