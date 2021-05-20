package com.example.testapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.testapp.dao.ProductRepository;
import com.example.testapp.model.Product;

//@SpringBootTest
@DataJpaTest
//@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {

	// @Mock  // test through approach 1
	ProductRepository productRepo;
	private static ProductServiceImpl productService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
		productRepo = mock(ProductRepository.class); // test through approach 2
		productService = new ProductServiceImpl(productRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	void testSaveProduct() {
		Product input = new Product(101,"HP-123",2000,4,"Laptop");
		Product savedProduct = new Product(101,"HP-123",2000,4,"Laptop");
	
		when(productRepo.save(input)).thenReturn(savedProduct);
		productService.saveProduct(input);
		verify(productRepo).save(input);
		
	}
	
	@Test
	@DisplayName("Test-Get All Products , Args:- No Args to pass")
	void testGetAllProducts() {
		
		
		List<Product> productList = mock(List.class); 
		//when() and 	//thenReturn()
		when(productRepo.findAll()).thenReturn(productList);
		//call the actual method 
		productService.getAllProducts();
		//verify
		verify(productRepo).findAll();
		
	}

	

}
