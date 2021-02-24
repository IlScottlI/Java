package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.CategoryProduct;
import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.services.CategoryProductService;
import com.codingdojo.mvc.services.CategoryService;
import com.codingdojo.mvc.services.ProductService;

@Controller
public class IndexController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CategoryProductService categoryProductService;

    public IndexController(ProductService productService, CategoryService categoryService, CategoryProductService categoryProductService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.categoryProductService = categoryProductService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Product> products = productService.allItems();
        List<Category> categories = categoryService.allItems();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "dashboard.jsp";
    }
    
    @RequestMapping("/products/new")
    public String newProduct(@Valid @ModelAttribute("product") Product product) {
        return "new-product.jsp";
    }
    
    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "new-product.jsp";
        } else {
            productService.createItem(product);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "new-category.jsp";
    }
    
    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "new-category.jsp";
        } else {
            categoryService.createItem(category);
            return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/categoryproduct/new", method = RequestMethod.POST)
    public String updateProduct(
    		@RequestParam(value="type") String type,
    		@RequestParam(value="page") String page,
    		@RequestParam(value="id") Long id,
    		@Valid @ModelAttribute("categoryproduct") CategoryProduct categoryproduct, 
    		BindingResult result
    		) {
        if (result.hasErrors()) {
            return page;
        } else {
            categoryProductService.createItem(categoryproduct);
            return "redirect:/" + type + "/" + id;
        }
    }
    
    @RequestMapping("/products/{id}")
    public String viewProduct(@PathVariable("id") Long id,@ModelAttribute("categoryproduct") CategoryProduct categoryproduct,Model model) {
    	Product product =  productService.findItem(id);
    	List<Category> categories = categoryService.getUnused(product.getCategories());
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "view-product.jsp";
    }
    
    @RequestMapping("/categories/{id}")
    public String viewCategory(@PathVariable("id") Long id,@ModelAttribute("categoryproduct") CategoryProduct categoryproduct,Model model) {
    	Category category = categoryService.findItem(id);
    	List<Product> products = productService.getUnused(category.getProducts());
    	model.addAttribute("products", products);
    	model.addAttribute("category", category);
        return "view-category.jsp";
    }
}