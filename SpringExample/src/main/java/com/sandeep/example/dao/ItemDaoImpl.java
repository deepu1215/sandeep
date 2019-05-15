package com.sandeep.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sandeep.example.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}
	public void addItem(Item it) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(it);
		
	}

	public List<Item> listItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> itemList =  session.createQuery("from Item").list();
		return itemList;
	}
	public void deleteItem(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Item item = (Item) session.get(Item.class, new Integer(id));
		session.delete(item);
	}
	public Item getItemById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Item item1 = (Item) session.get(Item.class, new Integer(id));
		return item1;
	}
	public void updateItem(Item it) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(it);
	}

}
