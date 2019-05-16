package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductSevice {

	public List<Product> listProducts();

	public void addProduct(Product p);

	public void updateProduct(Product p);

	public void deleteProduct(int id);

	public Product getProductById(int id);


}
