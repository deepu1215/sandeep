package com.example.dao;

import java.util.List;

import com.example.model.Product;

public interface ProductDao {

	void addProduct(Product p);

	void updateProduct(Product p);

	void deleteProduct(int id);

	Product getProductById(int id);

	List<Product> listProducts();

}
