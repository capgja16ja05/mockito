package com.example.testapp.dao;

import java.util.List;

import com.example.testapp.model.Product;


public interface CustomProductRepository {

	public List<Product> getProductByCategory(String proudctCategory);
	public List<Product> getProductByCategoryAndPrice(String proudctCategory,int range1,int range2);
	
}
