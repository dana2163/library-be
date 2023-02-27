package sk.umb.example.lib.category.controller;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.customer.service.CustomerRequestDTO;
import sk.umb.example.library.customer.service.CustomerDetailDTO;
import sk.umb.example.library.customer.service.CustomerService;


import java.util.List;
  @RestController
  public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories")
    public List<CategoryDetailDTO> searchCategory(@RequestParam(required = false) String name) {
      System.out.println("Search category called.");

      return Strings.isEmpty(name) ? categoryService.getAllCategories()
        : categoryService.searchCategoryByName(name);
    }

    @GetMapping("/api/categories/{categoryId}")
    public CategoryDetailDTO getCategory(@PathVariable Long categoryId) {
      System.out.println("Get category called.");
      return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/api/categories")
    public Long createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
      System.out.println("Create category called:");
      return categoryService.createCategory(categoryRequestDTO);
    }

    @PutMapping("/api/categories/{categoryId}")
    public void updateCategory(@PathVariable Long categoryId, @RequestBody CategoryRequestDTO categoryRequestDTO) {
      System.out.println("Update category called: ID = " + categoryId);
      categoryService.updateCategory(categoryId, categoryRequestDTO);
    }

    @DeleteMapping("/api/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
      System.out.println("Delete category called: ID = " + categoryId);
      categoryService.deleteCategory(categoryId);
    }
  }
