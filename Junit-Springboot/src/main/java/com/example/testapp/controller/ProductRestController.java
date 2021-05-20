package com.example.testapp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import javax.websocket.server.PathParam;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.testapp.exceptions.InvalidCostRangeException;
import com.example.testapp.model.Product;
import com.example.testapp.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Online Laptop Store",description = "Various api works on laptop inventory management")
public class ProductRestController {

	Logger log = org.slf4j.LoggerFactory.getLogger(ProductRestController.class);
	
	@Autowired
	private ProductService service;
	
	@ApiOperation(value = "product post mapping" , response = Product.class)
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product product)
	{
		log.info("inside insert products");
		service.saveProduct(product);
		return product;
		
	}
	
	public ProductRestController() {
		log.info("ProductRestController -- constructor ");
	}

	@GetMapping("/home")
	public String homeRequest()
	{
		return "Welcome : My Shopping App "+LocalDateTime.now();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
		
	}
	
	
	@ApiOperation(value = "product Get mapping to fatch all products" , response = List.class)
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category)
	{
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
		
}//end class

















