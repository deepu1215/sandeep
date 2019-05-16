package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Registration;
import com.example.service.RegistrationService;

@Controller
public class RegistrationController 
{
private RegistrationService registrationService;
	
	@Autowired
	@Qualifier("registrationSerive")
	public void setProductService(RegistrationService registrationService) {
		this.registrationService = registrationService;
		
	}
	
	@RequestMapping(value="/registrations",method=RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("reg", new Registration());
		//model.addAttribute("listProducts", this.productSevice.listProducts());
		
		return "registration";
		
	}
	
	@RequestMapping(value="/registration/add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("reg") Registration reg)
	{
		this.registrationService.addRegistration(reg);
		
		return "redirect:/registrations ";
		
	}
	
}
