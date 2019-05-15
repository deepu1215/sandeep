package com.sandeep.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sandeep.example.Item;
import com.sandeep.example.dao.ItemDao;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao=itemDao;
	}
	public List<Item> listItems() {
		return this.itemDao.listItems();
	}

	public void addItem(Item it) {
		this.itemDao.addItem(it);
		
	}
	public void deleteItem(int id) {
		this.itemDao.deleteItem(id);
		
	}
	public Item getItemById(int id) {
		return this.itemDao.getItemById(id);
	}
	public void updateItem(Item it) {
this.itemDao.updateItem(it);		
	}

}
