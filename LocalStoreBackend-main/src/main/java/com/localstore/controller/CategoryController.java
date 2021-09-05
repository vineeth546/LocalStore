package com.localstore.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.localstore.modal.Category;
import com.localstore.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CategoryController {

	private static final Logger log=Logger.getLogger(CategoryController.class);
	
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addCategoryToUser/{idUser}")
	Category addCategoryToUser(@RequestBody Category category, @PathVariable long idUser) {
		log.info("addCategoryToUser method in CategoryController is running");
		return categoryService.addCategoryToUser(category, idUser);
	}

	@PutMapping("/editCategory/{id}")
	Category editCategory(@RequestBody Category category, @PathVariable long id) {
		log.info("editCategory method in CategoryController is running");
		return categoryService.editCategory(category, id);
	}

	@GetMapping("/findCategoryById/{id}")
	Category findCategoryById(@PathVariable long id) {
		log.info("findCategoryById method in CategoryController is running");
		return categoryService.findCategoryById(id);
	}

	@DeleteMapping("/deleteCategory/{id}")
	void deleteCategory(@PathVariable long id) {
		log.info("deleteCategory method in CategoryController is running");
		categoryService.deleteCategory(id);
	}

	@GetMapping("/findAllCategories")
	List<Category> findAllCategories() {
		log.info("findAllCategories method in CategoryController is running");
		return categoryService.findAllCategories();
	}

	@GetMapping("/findCategoriesForUser/{id}")
	List<Category> findCategoriesForUser(@PathVariable long id) {
		log.info("findCategoriesForUser method in CategoryController is running");
		return categoryService.findCategoriesForUser(id);
	}

}
