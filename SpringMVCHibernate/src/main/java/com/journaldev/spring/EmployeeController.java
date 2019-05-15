package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Employee;

import com.journaldev.spring.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService es){
		this.employeeService = es;
		
		System.out.println("main");
		System.out.println("main");
		System.out.println("main");
		System.out.println("main");
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployees());
		
		System.out.println("main");
		return "employee";
	}
	
	//For add and update employee both
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee e){
		
		if(e.getId() == 0){
			//new employee, add it
			this.employeeService.addEmployee(e);
		}else{
			//existing employee, call update
			this.employeeService.updateEmployee(e);
		}
		
		System.out.println("main");
		
		return "redirect:/employees";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employee";
    }
	
}
