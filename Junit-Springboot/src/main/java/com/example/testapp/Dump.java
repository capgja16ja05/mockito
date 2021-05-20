package com.example.testapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.example.testapp.model.Product;

public class Dump {

	public boolean calculateIsLongString(String str)
	{
		
		if(str.length()>10) return true;
		else return false;
		
	}
	
	
	public Product doProductThings(Product product)
	{
		if(product.getStarRating()<0)
			throw new NullPointerException();
		product.setProductCost(product.getProductCost()+1000);
		
		return product;
	}
	
	public List<Product> getProducts() // get all SQL operation
	{
		Product p1 = new Product(101,"HP-123",2000,4,"Laptop");
		Product p2 = new Product(102,"HP-123",2000,4,"Laptop");
		Product p3 = new Product(103,"HP-123",2000,4,"Laptop");
		
		// 1000 lines code
		return new ArrayList<Product>(Arrays.asList(p1,p2,p3));
	}
	
	
	
	
}
