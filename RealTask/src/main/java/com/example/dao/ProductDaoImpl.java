package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory=sf;
	}

	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	public void deleteProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if(null !=p) {
			session.delete(p);
		}
	}

	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p =(Product) session.get(Product.class, new Integer(id));
		return p;
	}

	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList =session.createQuery("from Product").list();
		return productList;
	}

}
