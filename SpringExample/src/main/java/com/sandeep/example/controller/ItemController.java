package com.sandeep.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sandeep.example.Item;
import com.sandeep.example.service.ItemService;

@Controller
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItemService(ItemService itemService) {
		this.itemService=itemService;
		
	}
	
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public String listItems(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("listItems", this.itemService.listItems());
		return "item";
		
	}
	
	@RequestMapping(value="/item/add",method=RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item it) {
		if(it.getId()==0) {
			this.itemService.addItem(it);
		}
		else{
			this.itemService.updateItem(it);
		}
		
		return "redirect:/items";
		
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		this.itemService.deleteItem(id);
		return "redirect:/items";
		
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editItem(@PathVariable("id") int id, Model model) {
		model.addAttribute("item", this.itemService.getItemById(id));
		model.addAttribute("listItems", this.itemService.listItems());
		return "item";
		
	}

}
