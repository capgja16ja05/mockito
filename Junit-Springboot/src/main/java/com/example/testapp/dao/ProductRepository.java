package com.example.testapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testapp.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>,CustomProductRepository
{
   /*
    * finaAll
    * save
    * update
    * delete
    * 
    * + 
    * all methods from custom repo.
    * 
    * */
}
