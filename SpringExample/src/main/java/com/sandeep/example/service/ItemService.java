package com.sandeep.example.service;

import java.util.List;

import com.sandeep.example.Item;

public interface ItemService {

	public List<Item> listItems();
	public void addItem(Item it);
	public void deleteItem(int id);
	public Item getItemById(int id);
	public void updateItem(Item it);

}
