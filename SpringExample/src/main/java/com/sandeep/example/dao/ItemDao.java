package com.sandeep.example.dao;

import java.util.List;

import com.sandeep.example.Item;

public interface ItemDao {

public	void addItem(Item it);

public List<Item> listItems();

public void deleteItem(int id);

public Item getItemById(int id);

public void updateItem(Item it);
}
