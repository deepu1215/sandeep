package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductSevice {
	
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao=productDao;
		
	}

	public List<Product> listProducts() {
		return	productDao.listProducts();
		
	}

	public void addProduct(Product p) {
		this.productDao.addProduct(p);
		
	}

	public void updateProduct(Product p) {
		this.productDao.updateProduct(p);
		
	}

	public void deleteProduct(int id) {
		this.productDao.deleteProduct(id);
		
	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

}
