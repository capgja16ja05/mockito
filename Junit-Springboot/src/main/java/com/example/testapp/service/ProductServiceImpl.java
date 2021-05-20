package com.example.testapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testapp.dao.ProductRepository;
import com.example.testapp.model.Product;




@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	public ProductServiceImpl(ProductRepository repo) {
		super();
		this.repo = repo;
	}

	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getAllProducts() {
		
		System.out.println(" Inside get All products from mockito call ");
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product saveProduct(Product p) {
		// validate the values inside p 
		
		repo.save(p);
		return p;
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) 
	{
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}

	@Override
	public Product getProductById(int id)  {
		return repo.findById(id).get();
		
	}

	
	

}
