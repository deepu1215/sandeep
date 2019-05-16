package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Product;
import com.example.service.ProductSevice;

@Controller
public class ProductController {
	
	private ProductSevice productSevice;
	
	@Autowired
	@Qualifier("productService")
	public void setProductService(ProductSevice ps) {
		this.productSevice=ps;
		
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productSevice.listProducts());
		return "product";
		
	}
	
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product p) {
		if(p.getId()==0) {
			this.productSevice.addProduct(p);
		}
		else
		{
			this.productSevice.updateProduct(p);
		}
		return "redirect:/products ";
		
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		this.productSevice.deleteProduct(id);
		return "redirect:/products";
		
	}
	
	@RequestMapping(value="/edit/{id}")
	public String updateProduct(@PathVariable("id") int id , Model model) {
		model.addAttribute("product", this.productSevice.getProductById(id));
		model.addAttribute("listProducts", this.productSevice.listProducts());
		return "product";
		
	}

}
